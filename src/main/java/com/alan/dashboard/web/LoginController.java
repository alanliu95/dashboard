package com.alan.dashboard.web;

import com.alan.dashboard.model.User;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String login(Model model) {
        System.out.println("收到login get请求");
        //model.addAttribute("hello","haha");
        return "login";
    }

    /**
     * 该方法用于处理登陆请求，表单的字段需要和类User字段一一对应
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String loginForm(HttpServletRequest request, HttpServletResponse response, Model model) {

        System.out.println("收到login post请求");

        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        model.addAttribute("msg", "信息错误");

        return "/login";


//        model.addAttribute("msg", "账号或者密码错误！");
//        return "login";
    }

}
