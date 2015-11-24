package com.adarsh.spring.mvc.controller;

import com.adarsh.spring.mvc.model.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/coffee")
public class XMLController {

    //http://localhost:8080/SpringMvcXmlResponse/rest/coffee/adarsh
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody
    Coffee getCoffeeInXML(@PathVariable String name) {
		Coffee coffee = new Coffee(name, 100);
		return coffee;
	}
	
}