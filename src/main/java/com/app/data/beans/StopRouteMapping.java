package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class StopRouteMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stop_route_id")
	private Integer stoprouteid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
	private RouteInfo route;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="stop_id")
	private StopInfo stop;
	
	public StopRouteMapping() {
	}

	public StopRouteMapping(Integer stoprouteid, RouteInfo route, StopInfo stop) {
		super();
		this.stoprouteid = stoprouteid;
		this.route = route;
		this.stop = stop;
	}

	public Integer getStoprouteid() {
		return stoprouteid;
	}

	public void setStoprouteid(Integer stoprouteid) {
		this.stoprouteid = stoprouteid;
	}

	public RouteInfo getRoute() {
		return route;
	}

	public void setRoute(RouteInfo route) {
		this.route = route;
	}

	public StopInfo getStop() {
		return stop;
	}

	public void setStop(StopInfo stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "StopRouteMapping [stoprouteid=" + stoprouteid + ", route="
				+ route + ", stop=" + stop + "]";
	}

	
	
}
