package com.espark.adarsh.spring.service;

import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public interface EmployeeService {

    public static final List<Employee> employeeList = new ArrayList<Employee>() {
        {
            add(new Employee(101L, "adarsh kumar", "adarsh@kumar", new Department(100L, "IT", "INDIA")));
            add(new Employee(102L, "amit kumar", "amit@kumar", new Department(102L, "ACCOUNT", "US")));
            add(new Employee(103L, "radha singh", "radha@singh", new Department(102L, "IT", "US")));
            add(new Employee(104L, "ashok kumar", "ashok@kumar", new Department(103L, "CIVIL", "ENGLAND")));
            add(new Employee(105L, "sonu kumar", "sonu@kumar", new Department(103L, "IT", "ENGLAND")));
        }
    };

    public Employee getEmployee(Long employeeId);

    public List<Employee> getEmployeeList();
}
