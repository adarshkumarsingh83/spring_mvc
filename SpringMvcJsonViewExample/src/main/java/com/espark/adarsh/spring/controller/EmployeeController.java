package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.Employee;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.bean.view.EmployeeView;
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

    private static final List<Employee> employeeList = new ArrayList<Employee>() {
        {
            add(new Employee(101L, "adarsh kumar", "adarsh@kumar",new Department(100L,"INDIA")));
            add(new Employee(102L, "amit kumar", "amit@kumar",new Department(102L,"US")));
            add(new Employee(103L, "radha singh", "radha@singh",new Department(102L,"US")));
            add(new Employee(104L, "ashok kumar", "ashok@kumar",new Department(103L,"ENGLAND")));
            add(new Employee(105L, "sonu kumar", "sonu@kumar",new Department(103L,"ENGLAND")));
        }
    };

    // http://localhost:8080/SpringMvcJsonViewExample/employee
    @RequestMapping("/employee")
    public
    @ResponseBody
    List<Employee> getEmployees() {
        return employeeList;
    }


    // http://localhost:8080/SpringMvcJsonViewExample/employee/all
    @RequestMapping("/employee/all")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesSummaries() {
        return employeeList;
    }


    // http://localhost:8080/SpringMvcJsonViewExample/employee/{employeeId}/data
    @RequestMapping("/employee/{employeeId}/data")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    Employee getSummary(@PathVariable("employeeId") Long employeeId) {
        return this.getEmployee(employeeId);
    }

    // http://localhost:8080/SpringMvcJsonViewExample/employee/{employeeId}
    @RequestMapping("/employee/{employeeId}")
    public
    @ResponseBody
    Employee getEmployeeDetail(@PathVariable("employeeId") Long employeeId) {
        return this.getEmployee(employeeId);
    }


    // http://localhost:8080/SpringMvcJsonViewExample/employee/detail/all
    @RequestMapping("/employee/detail/all")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    List<Employee> getEmployeesDetailSummary() {
        return employeeList;
    }


    // http://localhost:8080/SpringMvcJsonViewExample/employee/detail/{employeeId}/data
    @RequestMapping("/employee/detail/{employeeId}/data")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    Employee getDetailSummary(@PathVariable("employeeId") Long employeeId) {
        return this.getEmployeeDetail(employeeId);
    }

    private Employee getEmployee(Long employeeId) {
        Employee employeeData = null;
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == employeeId) {
                employeeData = employee;
                break;
            }
        }
        return employeeData;
    }
}
