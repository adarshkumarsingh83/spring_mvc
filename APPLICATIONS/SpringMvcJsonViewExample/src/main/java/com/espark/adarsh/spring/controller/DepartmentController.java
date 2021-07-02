package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.Employee;
import com.espark.adarsh.spring.bean.view.DepartmentDetailView;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.bean.view.EmployeeView;
import com.espark.adarsh.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DepartmentService departmentService;

    // http://localhost:8080/SpringMvcJsonViewExample/department/all
    @RequestMapping("/department/all")
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    List<Department> getDepartment() {
        return this.departmentService.getDepartmentList();
    }


    // http://localhost:8080/SpringMvcJsonViewExample/department/detail/all
    @RequestMapping("/department/detail/all")
    @ResponseView(DepartmentDetailView.class)
    public
    @ResponseBody
    List<Department> getDepartmentSummaries() {
        return this.departmentService.getDepartmentList();
    }


    // http://localhost:8080/SpringMvcJsonViewExample/department/{departmentId}
    @RequestMapping("/department/{departmentId}")
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    Department getDepartment(@PathVariable("departmentId") Long departmentId) {
        return this.departmentService.getDepartment(departmentId);
    }

    // http://localhost:8080/SpringMvcJsonViewExample/department/detail/{departmentId}
    @RequestMapping("/department/detail/{departmentId}")
    @ResponseView(DepartmentDetailView.class)
    public
    @ResponseBody
    Department getDepartmentDetail(@PathVariable("departmentId") Long departmentId) {
        return this.departmentService.getDepartment(departmentId);
    }


}
