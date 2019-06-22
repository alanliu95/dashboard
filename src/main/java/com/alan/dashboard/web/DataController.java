package com.alan.dashboard.web;

import com.alan.dashboard.DAO.Mybatis.SysStatusMapper;
import com.alan.dashboard.model.SysStatus;
import com.alan.dashboard.service.RecordService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

@Controller
public class DataController {
    @Autowired
    private RecordService recordService;
    @GetMapping("/data")
    public String event(Model model){
        return "data";
    }

//    @RequestMapping("/event")
//    @ResponseBody
//    public String test(@RequestParam(value = "id",defaultValue = "1") int id) throws IOException {
//        List<SysStatus> sysStatus=mapper.getRecords(2,id);
//        String str=jsonMapper.writeValueAsString(sysStatus);
//        //System.out.println(str);
//        return str;
//    }
    @GetMapping("/data/devices")
    public String devices ()throws Exception{
     String json=recordService.getSiteAndDev();
    return json;
}
    @GetMapping("/data/records")
    public String records (@RequestParam(value="devId",defaultValue = "1") int devID)throws Exception{
        recordService.setCurr(devID);
        return recordService.getRecords();
    }

}
