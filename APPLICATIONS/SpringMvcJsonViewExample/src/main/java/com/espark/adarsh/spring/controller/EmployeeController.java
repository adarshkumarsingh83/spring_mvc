package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.Employee;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.bean.view.EmployeeView;
import com.espark.adarsh.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // http://localhost:8080/SpringMvcJsonViewExample/employee/{employeeId}/data
    @RequestMapping("/employee/{employeeId}/data")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    Employee getSummary(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.getEmployee(employeeId);
    }

    // http://localhost:8080/SpringMvcJsonViewExample/employee/detail/{employeeId}/data
    @RequestMapping("/employee/detail/{employeeId}/data")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    Employee getDetailSummary(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.getEmployee(employeeId);
    }

    // http://localhost:8080/SpringMvcJsonViewExample/employee/all
    @RequestMapping("/employee/all")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesSummaries() {
        return this.employeeService.getEmployeeList();
    }

    // http://localhost:8080/SpringMvcJsonViewExample/employee/detail/all
    @RequestMapping("/employee/detail/all")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesDetailSummary() {
        return this.employeeService.getEmployeeList();
    }

}
