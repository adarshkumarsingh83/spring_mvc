package com.adarsh.spring.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.espark.adarsh.mvc.configuration.WebMvcConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import com.espark.adarsh.mvc.model.Employee;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfiguration.class})
public class TestSpringMvcRestService {

	public static final String SERVER_URI = "http://localhost:8080/SpringMvcRestAnnotationExample";

    private static final String GET_EMP = "/rest/emp/{id}";
    private static final String GET_ALL_EMP = "/rest/emps";
    private static final String CREATE_EMP = "/rest/emp/create";
    private static final String DELETE_EMP = "/rest/emp/delete/{id}";


    @Test
	public  void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

    @Test
	public  void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(1);emp.setName("Adarsh Kumar");
		Employee response = restTemplate.postForObject(SERVER_URI+CREATE_EMP, emp, Employee.class);
		printEmpData(response);
	}


    @Test
    public  void testGetEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI+(GET_EMP.replace("{id}","101")), Employee.class);
        printEmpData(emp);
    }

	public  void printEmpData(Employee emp){
		System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate="+emp.getCreatedDate());
	}
}
