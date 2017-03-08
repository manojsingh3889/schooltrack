package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class BusstopRouteMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="busstop_route_id")
	private Integer busstoprouteid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
	private Integer routeid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="stop_id")
	private Integer stopid;
	
	public BusstopRouteMapping() {
		super();
	}

	public BusstopRouteMapping(Integer busstoprouteid, Integer routeid,
			Integer stopid) {
		super();
		this.busstoprouteid = busstoprouteid;
		this.routeid = routeid;
		this.stopid = stopid;
	}

	public Integer getBusstoprouteid() {
		return busstoprouteid;
	}

	public void setBusstoprouteid(Integer busstoprouteid) {
		this.busstoprouteid = busstoprouteid;
	}

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}

	public Integer getStopid() {
		return stopid;
	}

	public void setStopid(Integer stopid) {
		this.stopid = stopid;
	}
	
	@Override
	public String toString() {
		return "BusstopRouteMapping [busstoprouteid=" + busstoprouteid + ", routeid=" + routeid + ", stopid=" + stopid + "]";
	}
	
}
