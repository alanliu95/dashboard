package com.alan.dashboard.web;

import com.alan.dashboard.DAO.Mybatis.SysStatusMapper;
import com.alan.dashboard.model.Record;
import com.alan.dashboard.model.SysStatus;
import com.alan.dashboard.service.RecordService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Controller
public class DataController {
    @Autowired
    private ObjectMapper objectMapper;
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
    //ArrayList
    @GetMapping("/data/devices")
    @ResponseBody
    public String devices ()throws Exception{
     String json=recordService.getSiteAndDev();
    return json;
}
    @GetMapping("/data/records")
    @ResponseBody
    public String records (@RequestParam(value="currDevName") String devName)throws Exception{
        //System.out.println(currDevName);
        return recordService.getRecords(devName);
    }
    //RestTemplate
//    @GetMapping("/devices/{currDevName}")
//    @ResponseBody
//    public String record(@PathVariable("currDevName") String currDevName) throws Exception{
//
//        RestTemplate restTemplate = new RestTemplate();
//        //System.out.println(currDevName);
//        Record record = restTemplate.getForObject("http://localhost:9090/devices/"+currDevName
//                , Record.class);
//        //System.out.println(record);
//        if(record==null)
//            return "no";
//        return this.objectMapper.writeValueAsString(record);
//    }
}
