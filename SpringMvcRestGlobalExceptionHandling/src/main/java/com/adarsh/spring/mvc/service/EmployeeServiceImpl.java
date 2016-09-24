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
package com.adarsh.spring.mvc.service;

import com.adarsh.spring.mvc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeDataStore.put(employee.getId(),employee);
        return employee;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeDataStore.get(employeeId);
    }

    @Override
    public Employee deleteEmployee(int employeeId) {
        return employeeDataStore.remove(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDataStore.put(employee.getId(),employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        final List<Employee> employeeList = new ArrayList<Employee>();
        final Set<Integer> empIdKeys = employeeDataStore.keySet();
        for(Integer i : empIdKeys){
            employeeList.add(employeeDataStore.get(i));
        }
        return employeeList;
    }

    @Override
    public Boolean employeeExists(int employeeId) {
        return employeeDataStore.containsKey(employeeId);
    }

    @Override
    public Boolean employeeStoreEmpty() {
        return employeeDataStore.isEmpty();
    }
}
