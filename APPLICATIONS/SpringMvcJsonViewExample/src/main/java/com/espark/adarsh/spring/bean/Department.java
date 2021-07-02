package com.espark.adarsh.spring.bean;

import com.espark.adarsh.spring.bean.view.DepartmentDetailView;
import com.espark.adarsh.spring.bean.view.DepartmentView;
import com.espark.adarsh.spring.bean.view.EmployeeDetailView;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class Department implements Serializable {

    @JsonView({EmployeeDetailView.class, DepartmentView.class, DepartmentDetailView.class})
    private Long departmentId;

    @JsonView({EmployeeDetailView.class, DepartmentView.class, DepartmentDetailView.class})
    private String departmentName;

    @JsonView({EmployeeDetailView.class, DepartmentDetailView.class})
    private String departmentLocation;


    public Department() {
    }

    public Department(Long departmentId, String departmentName, String departmentLocation) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
