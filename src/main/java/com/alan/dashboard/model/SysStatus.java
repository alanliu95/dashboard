package com.alan.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SysStatus {
	@JsonIgnore
	private String devId;
	private String ts;
	private Float cpu;
	private Float mem;
	private Integer id;

	public SysStatus(String deviceId) {
		this.devId = deviceId;
	}

	@Override
	public String toString() {
		return "SysStatus{" +
				"devId='" + devId + '\'' +
				", ts='" + ts + '\'' +
				", cpu=" + cpu +
				", mem=" + mem +
				", id=" + id +
				'}';
	}

	public String getDevId() {
		return devId;
	}
	@JsonIgnore
	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Float getCpu() {
		return cpu;
	}

	public void setCpu(Float cpu) {
		this.cpu = cpu;
	}

	public Float getMem() {
		return mem;
	}

	public void setMem(Float mem) {
		this.mem = mem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void readStatus() {} //有问题

}
