package com.alan.dashboard.comtroller;

import com.alan.dashboard.mapper.SysStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class dataController {
    @Autowired
    SysStatusMapper mapper;
    @RequestMapping("/data")
    public String event(Model model){
        return "data";
    }

    @RequestMapping("/event")
    @ResponseBody
    public String test(){
        return ""+mapper.getOne(1);
    }
}
