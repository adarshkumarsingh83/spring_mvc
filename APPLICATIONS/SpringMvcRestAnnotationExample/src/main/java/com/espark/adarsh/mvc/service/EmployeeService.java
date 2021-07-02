package com.espark.adarsh.mvc.service;

import com.espark.adarsh.mvc.model.Employee;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public interface EmployeeService {
    final static Map<Integer, Employee> employeeDataStore = new HashMap<Integer, Employee>(){
        {
            put(101,new Employee(101,"adarsh kumar",new Date()));
            put(102,new Employee(102,"radha singh",new Date()));
            put(103,new Employee(103,"amit kumar",new Date()));
            put(104,new Employee(104,"sonu singh",new Date()));
            put(105,new Employee(105,"monu singh",new Date()));
        }
    };

    public Employee getEmployeeById(Integer employeeId);
    public Employee deleteEmployee(Integer employeeId);
    public Employee updateEmployee(Employee employee);
    public Employee saveEmployee(Employee employee);
    public List<Employee> getEmployees();
}
