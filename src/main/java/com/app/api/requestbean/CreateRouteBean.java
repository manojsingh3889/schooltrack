package com.app.api.requestbean;

public class CreateRouteBean {
	
	private String routenumber;
	private Integer seatcapacity;
	private String routearea;
	private String busplatenumber;
	private Integer seatsleft;
	private Integer	schoolId;
	
	public CreateRouteBean() {
	}

	public CreateRouteBean(String routenumber, Integer seatcapacity,
			String routearea, String busplatenumber, Integer seatsleft,
			Integer schoolId) {
		super();
		this.routenumber = routenumber;
		this.seatcapacity = seatcapacity;
		this.routearea = routearea;
		this.busplatenumber = busplatenumber;
		this.seatsleft = seatsleft;
		this.schoolId = schoolId;
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

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "CreateRouteBean [routenumber=" + routenumber
				+ ", seatcapacity=" + seatcapacity + ", routearea=" + routearea
				+ ", busplatenumber=" + busplatenumber + ", seatsleft="
				+ seatsleft + ", schoolId=" + schoolId + "]";
	}
	
	
}
