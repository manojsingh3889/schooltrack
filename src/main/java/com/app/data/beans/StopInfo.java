package com.app.data.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stop_info")
public class StopInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer stopid;
	
	@Column(name="lattitude")
	private String stoplattitude;
	
	@Column(name="longitude")
	private String stoplongitude;
	
	@Column(name="address")
	private String address;
	
	public StopInfo() {
		super();
	}

	public StopInfo(Integer stopid, String stoplattitude,
			String stoplongitude, String address) {
		super();
		this.stopid = stopid;
		this.stoplattitude = stoplattitude;
		this.stoplongitude = stoplongitude;
		this.address = address;
	}

	public Integer getStopid() {
		return stopid;
	}

	public void setStopid(Integer stopid) {
		this.stopid = stopid;
	}

	public String getStoplattitude() {
		return stoplattitude;
	}

	public void setStoplattitude(String stoplattitude) {
		this.stoplattitude = stoplattitude;
	}

	public String getStoplongitude() {
		return stoplongitude;
	}

	public void setStoplongitude(String stoplongitude) {
		this.stoplongitude = stoplongitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StopInfo [stopid=" + stopid + ", stoplattitude="
				+ stoplattitude + ", stoplongitude=" + stoplongitude
				+ ", address=" + address + "]";
	}
	
	
	
}
