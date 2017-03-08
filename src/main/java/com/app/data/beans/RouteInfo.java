package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class RouteInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="route_id")
	private Integer routeid;
	
	@Column(name="routenumber")
	private String routenumber;
	
	@Column(name="seatcapacity")
	private Integer seatcapacity;
	
	@Column(name="routearea")
	private String routearea;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="handler_id")
	private Integer handlerid;
	
	@Column(name="busplatenumber")
	private String busplatenumber;
	
	@Column(name="seatsleft")
	private Integer seatsleft;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private Integer schoolid;
	
	public RouteInfo() {
		super();
	}

	public RouteInfo(Integer routeid, String routenumber, Integer seatcapacity,
			String routearea, Integer handlerid, String busplatenumber,
			Integer seatsleft, Integer schoolid) {
		super();
		this.routeid = routeid;
		this.routenumber = routenumber;
		this.seatcapacity = seatcapacity;
		this.routearea = routearea;
		this.handlerid = handlerid;
		this.busplatenumber = busplatenumber;
		this.seatsleft = seatsleft;
		this.schoolid = schoolid;
	}

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}

	public String getRoutenumber() {
		return routenumber;
	}

	public void setRoutenumber(String routenumber) {
		this.routenumber = routenumber;
	}

	public Integer getSeatcapacity() {
		return seatcapacity;
	}

	public void setSeatcapacity(Integer seatcapacity) {
		this.seatcapacity = seatcapacity;
	}

	public String getRoutearea() {
		return routearea;
	}

	public void setRoutearea(String routearea) {
		this.routearea = routearea;
	}

	public Integer getHandlerid() {
		return handlerid;
	}

	public void setHandlerid(Integer handlerid) {
		this.handlerid = handlerid;
	}

	public String getBusplatenumber() {
		return busplatenumber;
	}

	public void setBusplatenumber(String busplatenumber) {
		this.busplatenumber = busplatenumber;
	}

	public Integer getSeatsleft() {
		return seatsleft;
	}

	public void setSeatsleft(Integer seatsleft) {
		this.seatsleft = seatsleft;
	}

	public Integer getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}
	
	@Override
	public String toString() {
		return "RouteInfo [routeid=" + routeid + ", routenumber=" + routenumber + ", seatcapacity=" + seatcapacity + ", routearea=" + routearea
				+ ", handlerid=" + handlerid + ", busplatenumber=" + busplatenumber + ", seatsleft=" + seatsleft + ", schoolid=" + schoolid + "]";
	}
	
	
}
