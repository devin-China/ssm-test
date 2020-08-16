package com.devin.controller;


import com.devin.domain.User;
import com.devin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @RequestMapping("/one")
    public ModelAndView findUser(Long id){
        System.out.println("-------------------------------------------------");
        User user = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
