package com.adarsh.spring.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.adarsh.spring.mvc.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";

	final static Map<Integer, Employee> employeeDataStore = new HashMap<Integer, Employee>(){
        {
            put(101,new Employee(101,"adarsh kumar",new Date()));
            put(102,new Employee(102,"radha singh",new Date()));
            put(103,new Employee(103,"amit kumar",new Date()));
            put(104,new Employee(104,"sonu singh",new Date()));
            put(105,new Employee(105,"monu singh",new Date()));
        }
    };

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap modelMap) {
        modelMap.put("serverTime",new Date());
        return "home";
    }

	@RequestMapping(value = GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);		
		return employeeDataStore.get(empId);
	}
	
	@RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = employeeDataStore.keySet();
		for(Integer i : empIdKeys){
			emps.add(employeeDataStore.get(i));
		}
		return emps;
	}
	
	@RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		employeeDataStore.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = employeeDataStore.get(empId);
		employeeDataStore.remove(empId);
		return emp;
	}

}
