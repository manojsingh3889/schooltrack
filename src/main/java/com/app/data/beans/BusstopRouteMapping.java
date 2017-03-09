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
	private RouteInfo route;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="stop_id")
	private BusstopInfo stop;
	
	public BusstopRouteMapping() {
	}

	public BusstopRouteMapping(Integer busstoprouteid, RouteInfo route,
			BusstopInfo stop) {
		super();
		this.busstoprouteid = busstoprouteid;
		this.route = route;
		this.stop = stop;
	}

	public Integer getBusstoprouteid() {
		return busstoprouteid;
	}

	public void setBusstoprouteid(Integer busstoprouteid) {
		this.busstoprouteid = busstoprouteid;
	}

	public RouteInfo getRoute() {
		return route;
	}

	public void setRoute(RouteInfo route) {
		this.route = route;
	}

	public BusstopInfo getStop() {
		return stop;
	}

	public void setStop(BusstopInfo stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "BusstopRouteMapping [busstoprouteid=" + busstoprouteid
				+ ", route=" + route + ", stop=" + stop + "]";
	}

	
}
