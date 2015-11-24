package com.adarsh.spring.web.controllers;


import com.adarsh.spring.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
public class RegistrationController {


    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String getInitialPage(final ModelMap modelMap,final HttpServletRequest httpServletRequest) {
        modelMap.addAttribute("user", new User());
        httpServletRequest.setAttribute("displayButton","Disable");
        return "AddUser";
    }


    @RequestMapping(value = "/register.do", method = RequestMethod.POST, params = "_page")
    public String processPage(final @RequestParam(required = true, value = "_page") int currentPage,
                              final @RequestParam(required = true, value = "action") String action,
                              final @RequestParam(required = false, value = "file") MultipartFile file,
                              final @ModelAttribute("user") User user,
                              final Errors errors,
                              final SessionStatus status,
                              final HttpServletRequest httpServletRequest,
                              final HttpServletResponse httpServletResponse) {
        final List<String> pageViews = new ArrayList<String>() {
            {
                add("AddUser");
                add("AddUserCredential");
                add("AddContactDetails");
                add("UserAddedSuccess");
                add("canceledView");
            }
        };

        if(action != null && action.equalsIgnoreCase("previous")){
            if (currentPage > 0) {
                return pageViews.get(currentPage - 1);
            }else{
                httpServletRequest.setAttribute("skipMsg","Can't Go Back To Previous Page");
                httpServletRequest.setAttribute("displayButton","Disable");
            }
        }else if (action != null && action.equalsIgnoreCase("Skip")) {
            if (currentPage < 2) {
                return pageViews.get(currentPage + 1);
            }else{
                httpServletRequest.setAttribute("skipMsg","Can't Skip To Next Page");
                httpServletRequest.setAttribute("displayButton","Disable");
            }
        } else if (action != null && action.equalsIgnoreCase("Cancel")) {
            status.setComplete();
            return pageViews.get(4);
        } else {
            switch (currentPage) {
                case 0:
                    if (user != null && user.getName().equals("")) {
                        errors.rejectValue("name", "name.required");
                    }
                    if (user.getUsername().equals("")) {
                        errors.rejectValue("username", "username.required");
                    }
                    if (!file.isEmpty()) {
                        try {
                            byte[] bytes = file.getBytes();
                            user.setUserImage(bytes);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        errors.rejectValue("userImage", "user.image.required");
                    }
                    break;
                case 1:
                    if (user != null && user.getPassword().equals("")) {
                        errors.rejectValue("password", "password.required");
                    }
                    if (user != null && user.getReTypePassword().equals("")) {
                        errors.rejectValue("reTypePassword", "reTypePassword.required");
                    }
                    if (!(user.getReTypePassword().equals(user.getPassword()))) {
                        errors.rejectValue("reTypePassword", "reTypePassword.notMatch");
                    }
                    if (user.getDob().equals("")) {
                        errors.rejectValue("dob", "dob.required");
                    }
                    break;
                case 2:
                    httpServletRequest.setAttribute("skipMsg","Can't Skip To Next Page");
                    if (user != null && user.getMobile().equals("")) {
                        errors.rejectValue("mobile", "mobile.required");
                    }
                    if (user.getEmail().equals("")) {
                        errors.rejectValue("email", "email.required");
                    }
                    break;
            }
            if (errors.hasErrors()) {
                return pageViews.get(currentPage);
            }
        }
    return pageViews.get(currentPage);
    }
}