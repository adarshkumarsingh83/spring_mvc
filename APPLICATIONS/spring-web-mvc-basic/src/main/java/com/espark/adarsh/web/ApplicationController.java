package com.espark.adarsh.web;

import com.espark.adarsh.bean.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ApplicationController {

    @RequestMapping("/welcome")
    public String welcomePage(Model model) {
        Message message = new Message();
        message.setData("welcome to the espark ");
        message.setDateTime(LocalDateTime.now().toString());
        model.addAttribute("message", message);
        return "welcome";
    }

}
