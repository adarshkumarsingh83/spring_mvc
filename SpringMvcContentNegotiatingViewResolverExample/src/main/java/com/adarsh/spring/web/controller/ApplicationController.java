package com.adarsh.spring.web.controller;

import com.adarsh.spring.web.bean.Employee;
import com.adarsh.spring.web.bean.EmployeeList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Controller
public class ApplicationController {


    // http://localhost:8080/SpringMvcContentNegotiatingViewResolverExample/employee/adarsh
    // http://localhost:8080/SpringMvcContentNegotiatingViewResolverExample/employee/adarsh.json
    // http://localhost:8080/SpringMvcContentNegotiatingViewResolverExample/employee/adarsh.xml
    // http://localhost:8080/SpringMvcContentNegotiatingViewResolverExample/employee/adarsh.xls

    @RequestMapping(value = "/employee/{empName}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable String empName, ModelMap model) {

        model.addAttribute("employeeStore", getEmployeeList(empName));
        return "employeePage";
    }

    private static EmployeeList getEmployeeList(String empName) {
        final List<Employee> employees = new ArrayList<>();
        for (int index = 100; index < 110; index++) {
            Employee employee = new Employee(index, empName + index, "empEmail" + index, new ArrayList<String>() {
                {
                    add("spring");
                    add("java");
                    add("c#");
                    add("php");
                }
            });
            employees.add(employee);
        }
        final EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployeeList(employees);
        return employeeList;
    }

}
