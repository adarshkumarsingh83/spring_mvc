package com.adarsh.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.adarsh.spring.mvc.model.Fruit;

@Controller
@RequestMapping("/fruit")
public class FruitController {

/*
    http://localhost:8080/SpringMvcContentNegotiatingViewResolver/fruit/banana.xml   , returned as XML file.
    http://localhost:8080/SpringMvcContentNegotiatingViewResolver/fruit/banana.json  , returned as JSON file.
    http://localhost:8080/SpringMvcContentNegotiatingViewResolver/fruit/banana       , returned to your default view resolver.
*/

    @RequestMapping(value = "{fruitName}", method = RequestMethod.GET)
    public String getFruit(@PathVariable String fruitName, ModelMap model) {
        Fruit fruit = new Fruit(fruitName, 1000);
        model.addAttribute("model", fruit);
        return "list";
    }

}