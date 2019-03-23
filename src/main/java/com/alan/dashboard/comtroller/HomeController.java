package com.alan.dashboard.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    @RequestMapping("/data")
    @ResponseBody
    public String test(){
        return ""+new Date();
    }
}
 //@RequestMapping(method= RequstMethod.GET)
//查询参数 @RequestParam(value="",defaultValue=  )
//路径变量 占位符 @RequestMapping(value="/{spittleId}",method= RequstMethod.GET)
//  @PathVariable("spittleId")