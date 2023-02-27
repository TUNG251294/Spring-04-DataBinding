package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/showInfo")
    public ModelAndView saveForm(User user){
        ModelAndView modelAndView = new ModelAndView("user/info");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
