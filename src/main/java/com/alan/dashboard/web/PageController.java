package com.alan.dashboard.web;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.Device;
import com.alan.dashboard.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String deviceManagement(@RequestParam(value = "siteId", defaultValue = "") String siteId, Model model) {

        List<Site> siteList = siteMapper.getAll();
        model.addAttribute("siteList", siteList);

        int id;
        if (siteId.length() != 0) id = Integer.parseInt(siteId);
        else id = siteList.get(0).getId();
        //System.out.println(id);
        List<Device> devList = deviceMapper.getRowsBySiteId(id);
        model.addAttribute("devList", devList);
        model.addAttribute("siteId", id);
        return "deviceManagement";
    }

    @PostMapping("/deviceManagement/addDevice")
    @ResponseBody
    public String addDevice(Device device, Model model) {
        System.out.println(device);
        deviceMapper.addDevice(device);
        return "inserted successfully";
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