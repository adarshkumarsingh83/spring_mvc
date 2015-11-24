package com.adarsh.spring.web.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@XmlRootElement(name = "employee")
public class Employee implements Serializable {

    private Integer empId;
    private String empName;
    private String empEmail;
    private List<String> empProject;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail, List<String> empProject) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empProject = empProject;
    }

    public Integer getEmpId() {
        return empId;
    }

    @XmlElement
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    @XmlElement
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    @XmlElement
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public List<String> getEmpProject() {
        return empProject;
    }

    @XmlElement
    public void setEmpProject(List<String> empProject) {
        this.empProject = empProject;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empProject=" + empProject +
                '}';
    }
}
