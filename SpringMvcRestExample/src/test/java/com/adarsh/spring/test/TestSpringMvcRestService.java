package com.adarsh.spring.test;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import com.adarsh.spring.mvc.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class TestSpringMvcRestService {

	public static final String SERVER_URI = "http://localhost:8080/SpringMvcRestExample";

    private static final String GET_EMP = "/rest/emp/{id}";
    private static final String GET_ALL_EMP = "/rest/emps";
    private static final String CREATE_EMP = "/rest/emp/create";
    private static final String DELETE_EMP = "/rest/emp/delete/{id}";


    @Test
	public  void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> emps = restTemplate.getForObject(GET_ALL_EMP, List.class);
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
		Employee response = restTemplate.postForObject(CREATE_EMP, emp, Employee.class);
		printEmpData(response);
	}

    @Test
	public  void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(GET_EMP, Employee.class);
		printEmpData(emp);
	}

	public  void printEmpData(Employee emp){
		System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate="+emp.getCreatedDate());
	}
}
