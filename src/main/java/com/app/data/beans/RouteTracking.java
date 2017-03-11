package com.app.data.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="route_tracking")
public class RouteTracking implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="currentlattitude")
	private String currentlattitude;
	
	@Column(name="currentlongitude")
	private String currentlongitude;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
	private RouteInfo routeid;

	public RouteTracking() {
	}

	public RouteTracking(Integer id, String currentlattitude,
			String currentlongitude, RouteInfo routeid) {
		super();
		this.id = id;
		this.currentlattitude = currentlattitude;
		this.currentlongitude = currentlongitude;
		this.routeid = routeid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrentlattitude() {
		return currentlattitude;
	}

	public void setCurrentlattitude(String currentlattitude) {
		this.currentlattitude = currentlattitude;
	}

	public String getCurrentlongitude() {
		return currentlongitude;
	}

	public void setCurrentlongitude(String currentlongitude) {
		this.currentlongitude = currentlongitude;
	}

	public RouteInfo getRouteid() {
		return routeid;
	}

	public void setRouteid(RouteInfo routeid) {
		this.routeid = routeid;
	}

	@Override
	public String toString() {
		return "RouteTracking [id=" + id + ", currentlattitude="
				+ currentlattitude + ", currentlongitude=" + currentlongitude
				+ ", routeid=" + routeid + "]";
	}

	
	
}
