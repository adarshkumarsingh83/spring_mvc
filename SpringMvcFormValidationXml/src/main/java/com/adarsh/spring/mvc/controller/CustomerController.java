package com.adarsh.spring.mvc.controller;

import com.adarsh.spring.mvc.model.Customer;
import com.adarsh.spring.mvc.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer.htm")
public class CustomerController {

    @Autowired
    private CustomerValidator customerValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("customer") Customer customer,
            BindingResult result, SessionStatus status) {

        customerValidator.validate(customer, result);

        if (result.hasErrors()) {
            //if validator failed
            return "CustomerForm";
        } else {
            status.setComplete();
            //form success
            return "CustomerSuccess";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        final Customer customer = new Customer() {
            {
                //Make "Spring MVC" as default checked value
                setFavFramework(new String[]{"Spring"});
                //Make "Make" as default radio button selected value
                setSex("M");
                //make "Hibernate" as the default java skills selection
                setJavaSkills("Hibernate");
                //initilize a hidden value
                setSecretValue("I'm hidden value");
            }
        };
        //command object
        model.addAttribute("customer", customer);

        //return form view
        return "CustomerForm";
    }

    @ModelAttribute("webFrameworkList")
    public List<String> populateWebFrameworkList() {
        //Data referencing for web framework checkboxes
        return new ArrayList<String>() {
            {
                add("Spring MVC");
                add("Struts 1");
                add("Struts 2");
                add("JSF");
                add("Apache Wicket");
            }
        };
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @ModelAttribute("numberList")
    public List<String> populateNumberList() {
        //Data referencing for number radiobuttons
        return new ArrayList<String>() {
            {
                add("Number 1");
                add("Number 2");
                add("Number 3");
                add("Number 4");
                add("Number 5");
            }
        };
    }

    @ModelAttribute("javaSkillsList")
    public Map<String, String> populateJavaSkillList() {

        //Data referencing for java skills list box
        return new LinkedHashMap<String, String>() {
            {
                put("Hibernate", "Hibernate");
                put("Spring", "Spring");
                put("Apache Wicket", "Apache Wicket");
                put("Struts", "Struts");
            }
        };
    }

    @ModelAttribute("countryList")
    public Map<String, String> populateCountryList() {

        //Data referencing for java skills list box
        return new LinkedHashMap<String, String>() {
            {
                put("US", "United Stated");
                put("CHINA", "China");
                put("SG", "Singapore");
                put("MY", "Malaysia");
            }
        };
    }

}