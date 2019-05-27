package com.alan.dashboard.comtroller;

import com.alan.dashboard.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class Login {
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginForm(User user,Model model){
        System.out.println(""+user);  //表单验证
        if(true){
            model.addAttribute("hello","error");
            return "login";
        }
        return "home";  //重定向？
    }
}
