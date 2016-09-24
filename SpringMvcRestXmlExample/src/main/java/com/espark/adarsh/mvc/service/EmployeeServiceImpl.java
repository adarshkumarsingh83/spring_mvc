package com.espark.adarsh.mvc.service;

import com.espark.adarsh.mvc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDataStore.get(employeeId);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<Employee>();
        Set<Integer> empIdKeys = employeeDataStore.keySet();
        for (Integer i : empIdKeys) {
            emps.add(employeeDataStore.get(i));
        }
        return emps;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setCreatedDate(new Date());
        employeeDataStore.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(Integer employeeId) {
        Employee employee = employeeDataStore.get(employeeId);
        employeeDataStore.remove(employeeId);
        return employee;
    }

    @Override
    public Employee updateEmployee( Employee employee) {
        employeeDataStore.put(employee.getId(), employee);
        return employee;
    }
}
