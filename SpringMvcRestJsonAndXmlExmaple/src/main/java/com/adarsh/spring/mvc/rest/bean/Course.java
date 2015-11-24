package com.adarsh.spring.mvc.rest.bean;

/**
 * Created by Adarsh on 3/18/15.
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement(name = "course")
@XmlType(propOrder = {"courseName", "score"})
@JsonPropertyOrder({"courseName", "score"})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private String courseName;
    private Integer score;

    public Course() {
    }

    public Course(String courseName, Integer score) {
        this.courseName = courseName;
        this.score = score;
    }

    public
    @XmlElement
    String getCourseName() {
        return courseName;
    }

    public
    @XmlElement
    Integer getScore() {
        return score;
    }

    public void setCourseName(String value) {
        courseName = value;
    }

    public void setScore(Integer value) {
        score = value;
    }


}