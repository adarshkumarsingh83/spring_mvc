package com.javafws.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.javafws.blog.model.User;

@SuppressWarnings("deprecation")
public class AddUserController extends AbstractWizardFormController {

	public AddUserController() {
		setCommandClass(User.class);
		setCommandName("user");
	}
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		
		User user = (User) command;
		
		switch (page) {

            case 0:

                if(user.getName().equals("")) {
                    errors.rejectValue("name", "name.required");
                }
                if(user.getUsername().equals("")) {
                    errors.rejectValue("username", "username.required");
                }

                break;

            case 1:

                if(user.getPassword().equals("")) {
                    errors.rejectValue("password", "password.required");
                }
                if(!(user.getRpassword().equals(user.getPassword()))) {
                    errors.rejectValue("rpassword", "rpassword.required");
                }
                if(user.getDob().equals("")) {
                    errors.rejectValue("dob", "dob.required");
                }

                break;

            case 2:

                if(user.getMobile().equals("")) {
                    errors.rejectValue("mobile", "mobile.required");
                }

                if(user.getEmail().equals("")) {
                    errors.rejectValue("email", "email.required");
                }

                break;
        }
		
	}
	
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		User user = (User) command;
		
		ModelAndView mav = new ModelAndView("UserAddedSuccess","user",user);
		
		return mav;
	}
}
