package com.adarsh.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adarsh.spring.mvc.form.Subscriber;
import com.adarsh.spring.mvc.form.Subscriber.Frequency;

@Controller
public class FormController {
	
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}

	@RequestMapping(value="form", method=RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("subscriber", new Subscriber());
		return "formPage";
	}
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String submitForm(Subscriber subscriber, Model m) {
		m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
		return "formPage";
	}
}
