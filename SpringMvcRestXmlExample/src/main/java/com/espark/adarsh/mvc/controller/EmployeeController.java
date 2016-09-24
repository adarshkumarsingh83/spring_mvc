package com.espark.adarsh.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.espark.adarsh.mvc.model.Employee;
import com.espark.adarsh.mvc.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */

@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public static final String GET_EMP = "/rest/emp/{id}";
    public static final String GET_ALL_EMP = "/rest/emps";
    public static final String CREATE_EMP = "/rest/emp/create";
    public static final String UPDATE_EMP = "/rest/emp/update";
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";

	@Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap modelMap) {
        modelMap.put("serverTime",new Date());
        return "home";
    }

	@RequestMapping(value = GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);		
		return employeeService.getEmployeeById(empId);
	}
	
	@RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		return this.employeeService.getEmployees();
	}
	
	@RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		return this.employeeService.saveEmployee(emp);
	}


    @RequestMapping(value = UPDATE_EMP, method = RequestMethod.PUT)
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employee) {
        logger.info("Start updateEmployee.");
        return this.employeeService.updateEmployee(employee);
    }

	@RequestMapping(value = DELETE_EMP, method = RequestMethod.DELETE)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		return this.employeeService.deleteEmployee(empId);
	}

}
