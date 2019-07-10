package com.alan.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home(Model model){
        //model.addAttribute("name","alan");
        return "main";
    }

    @RequestMapping("/deviceManagement")
    public String deviceManagement(Model model) {
        return "deviceManagement";
    }

    @RequestMapping("/deviceStatus")
    public String deviceStatus(Model model) {
        return "deviceStatus";
    }

    @RequestMapping("/current")
    public String current(Model model) {
        return "current";
    }

    @RequestMapping("/history")
    public String history(Model model) {
        return "history";
    }

}

//@RequestMapping(method= RequestMethod.GET)
//查询参数 @RequestParam(value="",defaultValue=  )
//路径变量 占位符 @RequestMapping(value="/{spittleId}",method= RequestMethod.GET)
//  @PathVariable("spittleId")