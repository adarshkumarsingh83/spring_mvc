package com.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
@author Adarsh
@author $LastChangedBy: adarsh $
@version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView login() {
        logger.info(" LoginController login()");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView lout() {
        logger.info(" LoginController logout()");
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/loginFailed.do", method = RequestMethod.GET)
    public ModelAndView loginFailed() {
        logger.info(" LoginController loginFailed()");
        return new ModelAndView("login");
    }

}
