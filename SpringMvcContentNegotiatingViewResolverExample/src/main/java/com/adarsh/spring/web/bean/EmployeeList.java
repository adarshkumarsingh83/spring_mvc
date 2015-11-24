package com.adarsh.spring.web.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adarsh on 5/7/15.
 */
@XmlRootElement(name = "employeeList")
public class EmployeeList {

    private List<Employee> employeeList=new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    @XmlElement
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
