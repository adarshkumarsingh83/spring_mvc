package com.espark.adarsh.spring.bean;

import com.espark.adarsh.spring.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.bean.view.EmployeeView;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class Employee implements Serializable {

    @JsonView({EmployeeDetailView.class,EmployeeView.class})
    private Long employeeId;

    @JsonView({EmployeeDetailView.class,EmployeeView.class})
    private String employeeName;

    @JsonView({EmployeeDetailView.class,EmployeeView.class})
    private String employeeEmail;

    @JsonView({EmployeeDetailView.class})
    private Department department;


    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
    }

    public Employee(Long employeeId, String employeeName, String employeeEmail, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.department = department;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
