package com.espark.adarsh.spring.service;

import com.espark.adarsh.spring.bean.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public interface DepartmentService {

    public static final List<Department> departmentList = new ArrayList<Department>() {
        {
            add(new Department(100L,"IT", "INDIA"));
            add(new Department(102L,"ACCOUNT", "US"));
            add(new Department(103L,"CIVIL", "ENGLAND"));
        }
    };


    public List<Department> getDepartmentList();

    public Department getDepartment(Long departmentId);
}
