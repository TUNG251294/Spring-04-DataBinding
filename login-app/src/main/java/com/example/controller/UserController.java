package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;
    @GetMapping("/login")
    public ModelAndView loginForm(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){
        User user = userDAO.checkLogin(login);
        if(user == null){
            return "redirect:login-denied";
        } else {
            model.addAttribute("user",user);
            return "success";
        }
    }
    @GetMapping("/login-success")
    public ModelAndView loginSuccessForm(){
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }
    @GetMapping("/login-denied")
    public ModelAndView loginDenied(){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}