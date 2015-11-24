package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.annotation.ResponseView;
import com.espark.adarsh.spring.bean.Department;
import com.espark.adarsh.spring.bean.ExceptionResponseView;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.bean.view.ExceptionView;
import com.espark.adarsh.spring.exception.ApplicationGenericException;
import com.espark.adarsh.spring.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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

    private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

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


    @ExceptionHandler(ApplicationGenericException.class)
    @ResponseView(ExceptionView.class)
    public
    @ResponseBody
    ExceptionResponseView<ApplicationGenericException> handleCustomException(ApplicationGenericException ex) {
        logger.info("Inside ApplicationException Handler");
        final ExceptionResponseView<ApplicationGenericException> exceptionExceptionResponseView =new ExceptionResponseView<ApplicationGenericException>();
        exceptionExceptionResponseView.setData(ex);
        exceptionExceptionResponseView.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        exceptionExceptionResponseView.setResponseMessage(ex.getErrorMessage());
        return exceptionExceptionResponseView;
    }

    @ExceptionHandler(Exception.class)
    @ResponseView(ExceptionView.class)
    public
    @ResponseBody
    ExceptionResponseView<Exception> handleAllException(Exception ex) {
        logger.info("Inside GenericException Handler");
        final ExceptionResponseView<Exception> exceptionExceptionResponseView =new ExceptionResponseView<Exception>();
        exceptionExceptionResponseView.setData(ex);
        exceptionExceptionResponseView.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        exceptionExceptionResponseView.setResponseMessage(ex.getLocalizedMessage());
        return exceptionExceptionResponseView;
    }

}
