package com.alan.dashboard.model;

public class SysStatus {
	private String deviceId;
	private String ts;
	private Float cpuUsage;
	private Float memUsage;
	private Integer id;

	public SysStatus(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "SysStatus{" +
				"deviceId='" + deviceId + '\'' +
				", ts='" + ts + '\'' +
				", cpuUsage=" + cpuUsage +
				", memUsage=" + memUsage +
				", id=" + id +
				'}';
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Float getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(Float cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public Float getMemUsage() {
		return memUsage;
	}

	public void setMemUsage(Float memUsage) {
		this.memUsage = memUsage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void readStatus() {} //有问题

}
