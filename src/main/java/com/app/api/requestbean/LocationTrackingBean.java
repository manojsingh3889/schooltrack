package com.app.api.requestbean;

public class LocationTrackingBean {
	
	private String lattitude;
	private String longitutde;
	private Integer routeId;
	
	public LocationTrackingBean() {
	}

	public LocationTrackingBean(String lattitude, String longitutde,
			Integer routeId) {
		super();
		this.lattitude = lattitude;
		this.longitutde = longitutde;
		this.routeId = routeId;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitutde() {
		return longitutde;
	}

	public void setLongitutde(String longitutde) {
		this.longitutde = longitutde;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "LocationTrackingBean [lattitude=" + lattitude + ", longitutde="
				+ longitutde + ", routeId=" + routeId + "]";
	}
	
	
	
}
