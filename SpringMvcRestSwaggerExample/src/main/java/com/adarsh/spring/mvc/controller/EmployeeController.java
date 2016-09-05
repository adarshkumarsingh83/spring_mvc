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

import com.adarsh.spring.mvc.model.Employee;
import com.adarsh.spring.mvc.service.EmployeeService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Controller
@Api(value = "EmployeeController", description = "Employee Operation")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


   @Autowired
   private EmployeeService employeeService;


    @ApiOperation(value = "Get the Employee Based on supplied id ", nickname = "getEmployee", code = 200, httpMethod = "GET"
            , notes = "Return the matched Employee", response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful Response Send", responseContainer = "Employee")
            , @ApiResponse(code = 404, message = "Employees not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(value = "/rest/emp/{id}"
            , produces = "application/json"
            , method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getEmployee(@ApiParam(value = "ID of employee", required = true) @PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID=" + empId);
        return this.employeeService.getEmployee(empId);
    }


    @ApiOperation(value = "Get the List of Employee ", nickname = "getEmployees", code = 200, httpMethod = "GET"
            , notes = "Return the List of the Employee" , response = List.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful Response Send", responseContainer = "List<Employee>")
            , @ApiResponse(code = 404, message = "Employees not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(value = "/rest/emps"
            , produces = "application/json"
            , method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees.");
        return this.employeeService.getEmployee();
    }


    @ApiOperation(value = "Create New Employee", nickname = "createEmployee", notes = "Create the Employee", httpMethod = "POST"
            , response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Employee Exist")
            , @ApiResponse(code = 404, message = "Employee Exist")
            , @ApiResponse(code = 200, message = "Employee Created", responseContainer = "Employee")})
    @RequestMapping(value = "/rest/emp/create"
            , produces = "application/json"
            , consumes = "application/json"
            , method = RequestMethod.POST)
    public
    @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        return this.employeeService.createEmployee(emp);
    }


    @ApiOperation(value = "Employee", nickname = "employee", notes = "Delete the Employee"
            , httpMethod = "DELETE", response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied")
            , @ApiResponse(code = 404, message = "Employee not found")})
    @RequestMapping(value = "/rest/emp/delete/{id}"
            , produces = "application/json"
            , method = RequestMethod.DELETE)
    public
    @ResponseBody
    Employee deleteEmployee(@ApiParam(value = "ID of deleteEmployee", required = true) @PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        return this.employeeService.deleteEmployee(empId);
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap modelMap) {
        modelMap.put("serverTime", new Date());
        return "home";
    }
}
