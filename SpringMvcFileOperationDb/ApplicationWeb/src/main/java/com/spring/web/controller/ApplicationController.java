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
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);


    @RequestMapping(value = "/welcome.do", method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        logger.info(" ApplicationController welcomePage()");
        return new ModelAndView("welcomePage");
    }

    @RequestMapping(value = "/accessViolation.do", method = RequestMethod.GET)
    public ModelAndView accessViolation() {
        logger.info(" ApplicationController accessViolation()");
        return new ModelAndView("accessViolation");
    }


}
