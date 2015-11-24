package com.javafws.blog.controllers;

import com.javafws.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user/register.do")
@SessionAttributes("user")
public class RegistrationController {

    /**
     * The default handler (page=0)
     */
    @RequestMapping
    public String getInitialPage(final ModelMap modelMap) {
        // put your initial user
        modelMap.addAttribute("user", new User());
        // populate the model Map as needed
        return "AddUser";
    }

    /**
     * First step handler (if you want to map each step individually to a method). You should probably either use this
     * approach or the one below (mapping all pages to the same method and getting the page number as parameter).
     */
    @RequestMapping(params = "_page1")
    public String processFirstStep(final @ModelAttribute("user") User user,
                                   final Errors errors) {
        // do something with user, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        if(user.getName().equals("")) {
            errors.rejectValue("name", "name.required");
            return "AddUser";
        }
        if(user.getUsername().equals("")) {
            errors.rejectValue("username", "username.required");
            return "AddUser";
        }

        return "AddUserCredential";
    }

    @RequestMapping(params = "_page2")
    public String processTwoStep(final @ModelAttribute("user") User user,
                                   final Errors errors) {
        // do something with user, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        if(user.getPassword().equals("")) {
            errors.rejectValue("password", "password.required");
            return "AddUserCredential";
        }
        if(!(user.getRpassword().equals(user.getPassword()))) {
            errors.rejectValue("rpassword", "rpassword.required");
            return "AddUserCredential";
        }
        if(user.getDob().equals("")) {
            errors.rejectValue("dob", "dob.required");
            return "AddUserCredential";
        }

        return "AddContactDetails";
    }




  /*  *//**
     * Maybe you want to be provided with the _page parameter (in order to map the same method for all), as you have in
     * AbstractWizardFormController.
     *//*
    @RequestMapping(method = RequestMethod.POST)
    public String processPage(@RequestParam("_page") final int currentPage,
                              final @ModelAttribute("user") User user,
                              final HttpServletResponse response) {
        // do something based on page number
        return pageViews[currentPage];
    }
*/
    /**
     * The successful finish step ('_finish' request param must be present)
     */
    @RequestMapping(params = "_finish")
    public String processFinish(final @ModelAttribute("user") User user,
                                final Errors errors,
                                final ModelMap modelMap,
                                final SessionStatus status) {
        if(user.getMobile().equals("")) {
            errors.rejectValue("mobile", "mobile.required");
            return "AddContactDetails";
        }

        if(user.getEmail().equals("")) {
            errors.rejectValue("email", "email.required");
            return "AddContactDetails";
        }

        // some stuff
        status.setComplete();
        return "UserAddedSuccess";
    }

  /*  @RequestMapping(params = "_cancel")
    public String processCancel(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final SessionStatus status) {
        status.setComplete();
        return "canceledView";
    }*/

}