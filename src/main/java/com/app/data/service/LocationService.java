package com.app.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StopRouteMapping;
import com.app.data.dao.RouteDAO;
import com.app.data.dao.RouteTrackingDAO;
import com.app.data.dao.SchoolDAO;
import com.app.data.dao.StopDAO;
import com.app.data.dao.StopRouteDAO;

@Component
public class LocationService {
	
	@Autowired
	RouteDAO routeDAO;
	
	@Autowired
	SchoolDAO schoolDAO;
	
	@Autowired
	StopDAO stopDAO;
	
	@Autowired
	StopRouteDAO stopRouteDAO;
	
	@Autowired
	RouteTrackingDAO routeTrackingDAO;
	
	public RouteInfo getRoute(Integer routeId){
		RouteInfo routeInfo = routeDAO.findById(routeId);
		if(routeInfo!=null){
			return routeInfo;
		}else
			return null;
	}

	public SchoolInfo getSchool(Integer schoolId){
		SchoolInfo schoolInfo = schoolDAO.findById(schoolId);
		if(schoolInfo!=null){
			return schoolInfo;
		}else
			return null;
	}

	public StopInfo getStop(Integer stopId){
		StopInfo busstopInfo = stopDAO.findById(stopId);
		if(busstopInfo!=null){
			return busstopInfo;
		}else
			return null;
	}

	public List<StopInfo> getStops(Integer routeId){
		List<StopRouteMapping> BusstopRouteMappingList = stopRouteDAO.findByProperty("routeId", routeId);
		if(BusstopRouteMappingList!=null){
			List<StopInfo> busstopInfoList = new ArrayList<StopInfo>();
			for(StopRouteMapping routeMapping : BusstopRouteMappingList){
				busstopInfoList.add(routeMapping.getStop());
			}
			return busstopInfoList;
		}else
			return null;
	}

	public RouteTracking getCurrentLocation(Integer routeId){
		RouteTracking routeTracking = routeTrackingDAO.findById(routeId);
		if(routeTracking!=null){
			return routeTracking;
		}else
			return null;
	}

}
