package com.alan.dashboard.web;

import com.alan.dashboard.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        //model.addAttribute("hello","haha");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginForm(User user, HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
//        System.out.println(""+user);  //表单验证
//        if(user.getId().equals("123")){
//            return "home";
//        }
//        model.addAttribute("hello","账号或者密码错误！");
//        return "login";  //重定向？
        System.out.println("" + user);
        if (user.getId().equals("123") && user.getPw().equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", "123");
            //System.out.println("新建session,添加username属性");
            return "redirect:/";
        }
        return "login";
    }
}
