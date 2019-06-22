package com.alan.dashboard.web;

import com.alan.dashboard.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class Login {
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        //model.addAttribute("hello","haha");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginForm(User user,Model model){
        System.out.println(""+user);  //表单验证
        if(user.getId().equals("123")){
            return "home";
        }
        model.addAttribute("hello","账号或者密码错误！");
        return "login";  //重定向？
    }
}
