package com.alan.dashboard.utils.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class RecJson {
    public List<String> ts;
    public List<Float> cpu;
    public List<Float> mem;

    public List<String> getTs() {
        return ts;
    }

    public void setTs(List<String> ts) {
        this.ts = ts;
    }

    public List<Float> getCpu() {
        return cpu;
    }

    public void setCpu(List<Float> cpu) {
        this.cpu = cpu;
    }

    public List<Float> getMem() {
        return mem;
    }

    public void setMem(List<Float> mem) {
        this.mem = mem;
    }
}
