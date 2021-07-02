package com.espark.adarsh.spring.service;

import com.espark.adarsh.spring.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }


    public Employee getEmployee(Long employeeId) {
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
