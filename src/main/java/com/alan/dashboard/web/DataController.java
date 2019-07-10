package com.alan.dashboard.web;

import com.alan.dashboard.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController {
    @Autowired
    private RecordService recordService;

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
