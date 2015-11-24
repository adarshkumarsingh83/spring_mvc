package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.Employee;
import com.espark.adarsh.spring.bean.view.DepartmentView;
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
public class DepartmentController {

    private static final List<Department> departmentList=new ArrayList<Department>(){
        {
         add(new Department(100L,"INDIA"));
         add(new Department(102L,"US"));
         add(new Department(103L,"ENGLAND"));
        }
    };

    // http://localhost:8080/SpringMvcJsonViewExample/department/all
    @RequestMapping("/department/all")
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    List<Department> getDepartmentSummaries() {
        return departmentList;
    }


    // http://localhost:8080/SpringMvcJsonViewExample/department/{departmentId}
    @RequestMapping("/department/{departmentId}")
    public
    @ResponseBody
    Department getDepartmentDetail(@PathVariable("departmentId") Long departmentId) {
        return this.getDepartment(departmentId);
    }

    private Department getDepartment(Long departmentId){
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
