package com.app.data.beans;

import org.springframework.stereotype.Component;

@Component
public class StopInfoPriorityBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer stopPriority;
	private StopInfo stop;
	private double timeBetweenStop;
	private double distanceBetweenStop; 
	
	public StopInfoPriorityBean() {
		
	}

	public StopInfoPriorityBean(Integer stopPriority, StopInfo stop,
			double timeBetweenStop, double distanceBetweenStop) {
		super();
		this.stopPriority = stopPriority;
		this.stop = stop;
		this.timeBetweenStop = timeBetweenStop;
		this.distanceBetweenStop = distanceBetweenStop;
	}

	public Integer getStopPriority() {
		return stopPriority;
	}

	public void setStopPriority(Integer stopPriority) {
		this.stopPriority = stopPriority;
	}

	public StopInfo getStop() {
		return stop;
	}

	public void setStop(StopInfo stop) {
		this.stop = stop;
	}

	public double getTimeBetweenStop() {
		return timeBetweenStop;
	}

	public void setTimeBetweenStop(double timeBetweenStop) {
		this.timeBetweenStop = timeBetweenStop;
	}

	public double getDistanceBetweenStop() {
		return distanceBetweenStop;
	}

	public void setDistanceBetweenStop(double distanceBetweenStop) {
		this.distanceBetweenStop = distanceBetweenStop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StopInfoPriorityBean [stopPriority=" + stopPriority + ", stop="
				+ stop + ", timeBetweenStop=" + timeBetweenStop
				+ ", distanceBetweenStop=" + distanceBetweenStop + "]";
	}

	
}
