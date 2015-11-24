package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.exception.ApplicationGenericException;
import com.espark.adarsh.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class DepartmentController {

    @Qualifier(value = "departmentService")
    @Autowired(required = true)
    private DepartmentService departmentService;

    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/department/all
    @RequestMapping("/department/all")
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    List<Department> getDepartmentSummaries() {
        if (this.departmentService.departmentStoreEmpty()) {
            return departmentService.getAllDepartment();
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_DEPARTMENT_STORE_EMPTY"
                    , "Department Store Empty No Department Exists ");
        }
    }


    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/department/{departmentId}
    @RequestMapping("/department/{departmentId}")
    public
    @ResponseBody
    Department getDepartmentDetail(@PathVariable("departmentId") Long departmentId) {
        if (this.departmentService.departmentExists(departmentId)) {
            return this.departmentService.getDepartment(departmentId);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_DEPARTMENT_NOT_FOUND"
                    , "Department not found for the id " + departmentId);
        }
    }

    // http://localhost:8080/SpringMvcRestJsonViewGlobalExceptionHandling/department/save
    @RequestMapping(value = "/department/save", method = RequestMethod.POST)
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    Department getSummary(@RequestBody Department department) {
        if (department != null) {
            return this.departmentService.saveDepartment(department);
        } else {
            throw new ApplicationGenericException("APPLICATION_ERROR_DEPARTMENT_NOT_CREATED"
                    , "Department Not Created in the System ");
        }
    }

}
