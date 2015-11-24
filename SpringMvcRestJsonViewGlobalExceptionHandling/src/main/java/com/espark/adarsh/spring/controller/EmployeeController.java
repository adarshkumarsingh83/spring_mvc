package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Employee;
import com.espark.adarsh.spring.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.bean.view.EmployeeView;
import com.espark.adarsh.spring.exception.ApplicationGenericException;
import com.espark.adarsh.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class EmployeeController {

    @Qualifier(value = "employeeService")
    @Autowired(required = true)
    private EmployeeService employeeService;

    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee
    @RequestMapping("/employee")
    public
    @ResponseBody
    List<Employee> getEmployees() {
        if (!this.employeeService.employeeStoreEmpty()) {
            return this.employeeService.getEmployeeList();
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_STORE_EMPTY"
                    , "Employee Store Empty No Employee Exists ");
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/all
    @RequestMapping("/employee/all")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesSummaries() {
        if (!this.employeeService.employeeStoreEmpty()) {
            return this.employeeService.getEmployeeList();
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_STORE_EMPTY"
                    , "Employee Store Empty No Employee Exists ");
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/{employeeId}/data
    @RequestMapping("/employee/{employeeId}/data")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    Employee getSummary(@PathVariable("employeeId") Long employeeId) {
        if (this.employeeService.employeeExists(employeeId)) {
            return this.employeeService.getEmployee(employeeId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMP_NOT_FOUND"
                    , "Employee not found for the id " + employeeId);
        }
    }

    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/save
    @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    Employee getSummary(@RequestBody Employee employee) {
        if (employee != null) {
            return this.employeeService.saveEmployee(employee);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_NOT_CREATED"
                    , "Employee Not Created in the System ");
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/{employeeId}
    @RequestMapping("/employee/{employeeId}")
    public
    @ResponseBody
    Employee getEmployeeDetail(@PathVariable("employeeId") Long employeeId) {
        if (this.employeeService.employeeExists(employeeId)) {
            return this.employeeService.getEmployee(employeeId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMP_NOT_FOUND"
                    , "Employee not found for the id " + employeeId);
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/detail/all
    @RequestMapping(value = "/employee/detail/all", method = RequestMethod.GET)
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesDetailSummary() {
        if (!this.employeeService.employeeStoreEmpty()) {
            return this.employeeService.getEmployeeList();
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMPLOYEE_STORE_EMPTY"
                    , "Employee Store Empty No Employee Exists ");
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/employee/detail/{employeeId}/data
    @RequestMapping("/employee/detail/{employeeId}/data")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    Employee getDetailSummary(@PathVariable("employeeId") Long employeeId) {
        if (this.employeeService.employeeExists(employeeId)) {
            return this.employeeService.getEmployee(employeeId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_EMP_NOT_FOUND"
                    , "Employee not found for the id " + employeeId);
        }
    }
}
