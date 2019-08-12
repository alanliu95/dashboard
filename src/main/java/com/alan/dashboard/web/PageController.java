package com.alan.dashboard.web;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.Device;
import com.alan.dashboard.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    SiteMapper siteMapper;
    @RequestMapping("/")
    public String home(Model model){
        //model.addAttribute("name","alan");
        return "main";
    }

    @RequestMapping("/deviceManagement")
    public String deviceManagement(@RequestParam(value = "SiteId", defaultValue = "0") String siteId, Model model) {
        int id = Integer.parseInt(siteId);
        List<Site> siteList = siteMapper.getAll();
        model.addAttribute("siteList", siteList);
        List<Device> devList = deviceMapper.getRowsBySiteId(siteList.get(id).getId());
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