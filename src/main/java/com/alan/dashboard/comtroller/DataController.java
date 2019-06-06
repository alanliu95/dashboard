package com.alan.dashboard.comtroller;

import com.alan.dashboard.mapper.SysStatusMapper;
import com.alan.dashboard.model.SysStatus;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

@Controller
public class DataController {
    @Autowired
    SysStatusMapper mapper;
    @Autowired
    ObjectMapper jsonMapper;
    @RequestMapping("/data")
    public String event(Model model){
        return "data";
    }

    @RequestMapping("/event")
    @ResponseBody
    public String test(@RequestParam(value = "id",defaultValue = "1") int id) throws IOException {
        SysStatus sysStatus=mapper.getOne(id);
        String str=jsonMapper.writeValueAsString(sysStatus);
        return str;
    }
}