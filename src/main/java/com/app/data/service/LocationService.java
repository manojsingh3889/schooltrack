package com.app.data.service;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.requestbean.LocationTrackingBean;
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
import com.app.utility.Utility;

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

	public TreeMap<Integer, StopInfo> getStops(Integer routeId){
		List<StopRouteMapping> BusstopRouteMappingList = stopRouteDAO.findByProperty("routeId", routeId);
		if(BusstopRouteMappingList!=null){
			TreeMap<Integer, StopInfo> busstopInfoMap = new TreeMap<Integer, StopInfo>();
			for(StopRouteMapping routeMapping : BusstopRouteMappingList){
				busstopInfoMap.put(routeMapping.getPriority(),routeMapping.getStop());
			}
			return busstopInfoMap;
		}else
			return null;
	}

	public RouteTracking getCurrentLocation(Integer routeId){
		RouteInfo routeInfo = routeDAO.findById(routeId);
		if(routeInfo.getTripstatus()!="Stopped"){
			RouteTracking routeTracking = routeTrackingDAO.findUniqueByProperty("routeid", routeInfo);
			if(routeTracking!=null){
				return routeTracking;
			}else
				return null;
		}else 
			return null;
	}

	public RouteTracking setCurrentLocation(LocationTrackingBean bean){
		RouteTracking routeTracking = routeTrackingDAO.findById(bean.getRouteId());
		if(routeTracking!=null){
			routeTracking.setCurrentlattitude(bean.getLattitude());
			routeTracking.setCurrentlongitude(bean.getLongitutde());
			routeTrackingDAO.save(routeTracking);
			return routeTracking;
		}else
			return null;
	}

	public RouteInfo updateTripStatus(Integer routeId,String tripStatus){
		RouteInfo routeInfo = getRoute(routeId);
		if(routeInfo!=null){
			routeInfo.setTripstatus(tripStatus);
			routeDAO.save(routeInfo);
			return routeInfo;
		}else
			return null;
	}
	
}
