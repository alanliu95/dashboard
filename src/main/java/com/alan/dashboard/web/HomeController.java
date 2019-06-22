package com.alan.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("name","alan");
        return "home";
    }

    @RequestMapping("/test")
    public String test(Model model){
        return "test";
    }
}
//@RequestMapping(method= RequestMethod.GET)
//查询参数 @RequestParam(value="",defaultValue=  )
//路径变量 占位符 @RequestMapping(value="/{spittleId}",method= RequestMethod.GET)
//  @PathVariable("spittleId")