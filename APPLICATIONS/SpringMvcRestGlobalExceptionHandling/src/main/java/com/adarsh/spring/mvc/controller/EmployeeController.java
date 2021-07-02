/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.adarsh.spring.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.adarsh.spring.mvc.exception.ApplicationGenericException;
import com.adarsh.spring.mvc.model.Employee;
import com.adarsh.spring.mvc.service.EmployeeService;
import com.adarsh.spring.mvc.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public static final String GET_EMP = "/rest/emp/{id}";
    public static final String GET_ALL_EMP = "/rest/emps";
    public static final String CREATE_EMP = "/rest/emp/create";
    public static final String UPDATE_EMP = "/rest/emp/update";
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";

    @Qualifier(value = "employeeService")
    @Autowired(required = true)
    private EmployeeService employeeService;


    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String getHome(ModelMap modelMap) {
        modelMap.put("msg", "WELCOME TO ESPARK ");
        modelMap.put("serverTime", new Date());
        return "welcomePage";
    }

    @RequestMapping(value = GET_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseView<Employee> getEmployee(@PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID=" + empId);
        if (this.employeeService.employeeExists(empId)) {
            return new ResponseView<Employee>(employeeService.getEmployee(empId)
                    , HttpStatus.OK
                    , "Employee Found for Id " + empId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMP_NOT_FOUND"
                    , "Employee not found for the id " + empId);
        }
    }

    @RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseView<List<Employee>> getAllEmployees() {
        logger.info("Start getAllEmployees.");
        if (!this.employeeService.employeeStoreEmpty()) {
            final ResponseView<List<Employee>> listResponseView = new ResponseView<List<Employee>>();
            listResponseView.setData(this.employeeService.getEmployeeList());
            listResponseView.setHttpStatus(HttpStatus.OK);
            listResponseView.setResponseMessage("List of the All the Employee");
            return listResponseView;
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_STORE_EMPTY"
                    , "Employee Store Empty No Employee Exists ");
        }
    }

    @RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseView<Employee> createEmployee(@RequestBody Employee employee) {
        logger.info("Start createEmployee.");
        employee.setCreatedDate(new Date());
        employee = this.employeeService.saveEmployee(employee);
        if (employee != null) {
            return new ResponseView<Employee>(employee
                    , HttpStatus.OK
                    , "Employee Saved for Id " + employee.getId());
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_NOT_CREATED"
                    , "Employee Not Created in the System ");
        }
    }

    @RequestMapping(value = DELETE_EMP, method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseView<Employee> deleteEmployee(@PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        if (this.employeeService.employeeExists(empId)) {
            final Employee employee = this.employeeService.deleteEmployee(empId);
            return new ResponseView<Employee>(employee
                    , HttpStatus.OK
                    , "Employee Found for Id " + empId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_NOT_FOUND_FOR_DELETION"
                    , "Employee not found for Deletion  " + empId);
        }
    }

    @RequestMapping(value = UPDATE_EMP, method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseView<Employee> updateEmployee(@RequestBody Employee employee) {
        logger.info("Start updateEmployee.");
        employee.setCreatedDate(new Date());
        if (this.employeeService.employeeExists(employee.getId())) {
            employee = this.employeeService.updateEmployee(employee);
            return new ResponseView<Employee>(employee
                    , HttpStatus.OK
                    , "Employee Updated for Id " + employee.getId());
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_NOT_FOUND_FOR_UPDATE"
                    , "Employee not found for Update  " + employee.getId());
        }
    }
}
