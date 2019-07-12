package com.alan.dashboard.web;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    DeviceMapper deviceMapper;
    @RequestMapping("/")
    public String home(Model model){
        //model.addAttribute("name","alan");
        return "main";
    }

    @RequestMapping("/deviceManagement")
    public String deviceManagement(Model model) {
        List<Device> devList = deviceMapper.getAll();
        model.addAttribute("devList", devList);
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