package com.discoveri.heartihealth.dto;

public class IntervalReportWeeklyDTO   {
	
	private String interval; 
	private int predicted;
	private int cured;
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public int getPredicted() {
		return predicted;
	}
	public void setPredicted(int predicted) {
		this.predicted = predicted;
	}
	public int getCured() {
		return cured;
	}
	public void setCured(int cured) {
		this.cured = cured;
	}
	
	
	
	
}
