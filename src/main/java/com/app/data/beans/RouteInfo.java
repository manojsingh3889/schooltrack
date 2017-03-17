package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name="route_info")
public class RouteInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer routeid;
	
	@Column(name="routenumber")
	private String routenumber;
	
	@Column(name="seatcapacity")
	private Integer seatcapacity;
	
	@Column(name="routearea")
	private String routearea;
	
	@Column(name="busplatenumber")
	private String busplatenumber;
	
	@Column(name="seatsleft")
	private Integer seatsleft;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private SchoolInfo school;
	
	@Column(name="tripstatus")
	private String tripstatus;
	
	public RouteInfo() {
	}

	public RouteInfo(Integer routeid, String routenumber, Integer seatcapacity,
			String routearea, String busplatenumber, Integer seatsleft,
			SchoolInfo school, String tripstatus) {
		super();
		this.routeid = routeid;
		this.routenumber = routenumber;
		this.seatcapacity = seatcapacity;
		this.routearea = routearea;
		this.busplatenumber = busplatenumber;
		this.seatsleft = seatsleft;
		this.school = school;
		this.tripstatus = tripstatus;
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

	public SchoolInfo getSchool() {
		return school;
	}

	public void setSchool(SchoolInfo school) {
		this.school = school;
	}

	public String getTripstatus() {
		return tripstatus;
	}

	public void setTripstatus(String tripstatus) {
		this.tripstatus = tripstatus;
	}

	@Override
	public String toString() {
		return "RouteInfo [routeid=" + routeid + ", routenumber=" + routenumber
				+ ", seatcapacity=" + seatcapacity + ", routearea=" + routearea
				+ ", busplatenumber=" + busplatenumber + ", seatsleft="
				+ seatsleft + ", school=" + school + ", tripstatus="
				+ tripstatus + "]";
	}
	
	
}
