package com.adarsh.spring.mvc.rest.controller;

/**
 * Created by Adarsh on 3/18/15.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adarsh.spring.mvc.rest.bean.Course;
import com.adarsh.spring.mvc.rest.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentController {

    @ResponseBody
    @RequestMapping(value = "/getstudent/{id}/{name}",
            method = RequestMethod.GET,
            produces={"application/json", "application/xml"})
    public Student getStudent(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable("id") final int id,
                              @PathVariable("name") final String name) {

        // Create a new student object and return it
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Student student = new Student(id, name, dateFormatter.format(new Date()));

        List<Course> cources = student.getCourses();
        cources.add(new Course("Math", 15));
        cources.add(new Course("Politics", 100));

        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/echostudent",
            method = RequestMethod.POST,
            produces={"application/json", "application/xml"},
            consumes={"application/json", "application/xml"})
    public Student echoStudent(@RequestBody Student student,
                               HttpServletRequest request, HttpServletResponse response) {

        // Just echo the same student back
        return student;
    }
}