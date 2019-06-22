package com.alan.dashboard.model;

public class Record {
    private int id;
    private int DevId;
    private String ts;
    private float cpu;
    private float mem;

    public Record(int id, int devId, String ts, float cpu, float mem) {
        this.id = id;
        DevId = devId;
        this.ts = ts;
        this.cpu = cpu;
        this.mem = mem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDevId() {
        return DevId;
    }

    public void setDevId(int devId) {
        DevId = devId;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public float getMem() {
        return mem;
    }

    public void setMem(float mem) {
        this.mem = mem;
    }
}
