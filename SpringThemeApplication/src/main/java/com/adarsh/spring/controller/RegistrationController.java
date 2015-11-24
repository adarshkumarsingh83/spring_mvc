package com.adarsh.spring.controller;

import com.adarsh.spring.form.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes
public class RegistrationController {

    private static final String SUCCESS_PAGE = "registrationStatus";
    private static final String REGISTRATION_PAGE = "registrationForm";
    private static final String MODEL_NAME_USER = "user";

    @RequestMapping(value = "/addContact.do", method = RequestMethod.POST)
    public String addContact(ModelMap model
            , @ModelAttribute(MODEL_NAME_USER) @Valid User user
            , BindingResult result
            , HttpServletRequest httpServletRequest) {

        if (result.hasErrors()) {
            httpServletRequest.getSession().setAttribute("page", "registrationForm");
            return REGISTRATION_PAGE;
        } else {
            httpServletRequest.getSession().setAttribute("page", "registrationStatus");
            model.addAttribute(MODEL_NAME_USER, user);
            return SUCCESS_PAGE;
        }
    }

    @RequestMapping("/registrationForm.do")
    public ModelAndView showContacts(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("page", "registrationForm");
        return new ModelAndView(REGISTRATION_PAGE, MODEL_NAME_USER, new User());
    }
}
