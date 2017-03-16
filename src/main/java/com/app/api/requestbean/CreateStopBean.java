package com.app.api.requestbean;

public class CreateStopBean {

	private String lattitude;
	private String longitude;
	private String address;
	
	public CreateStopBean() {
	}

	public CreateStopBean(String lattitude, String longitude, String address) {
		super();
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.address = address;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CreateStopBean [lattitude=" + lattitude + ", longitude="
				+ longitude + ", address=" + address + "]";
	}
	
	
	
}
