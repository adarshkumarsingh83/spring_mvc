package com.espark.adarsh.spring.service;

import com.espark.adarsh.spring.bean.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Override
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    @Override
    public Department getDepartment(Long departmentId){
        Department department=null;
        for(Department department1:departmentList){
            if(department1.getDepartmentId()== departmentId){
                department=department1;
                break;
            }
        }
        return department;
    }
}
