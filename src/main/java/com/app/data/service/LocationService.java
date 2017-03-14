package com.app.data.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.maven.artifact.transform.LatestArtifactTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.beans.RouteInfo;
import com.app.data.beans.RouteTracking;
import com.app.data.beans.SchoolInfo;
import com.app.data.beans.StopInfo;
import com.app.data.beans.StopInfoPriorityBean;
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
	
	@Autowired
	StopInfoPriorityBean stopInfoPriorityBean;
	
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
		RouteTracking routeTracking = routeTrackingDAO.findById(routeId);
		if(routeTracking!=null){
			return routeTracking;
		}else
			return null;
	}
	
	//get time between list of stops
	/*public TreeMap<Integer,StopInfoPriorityBean> getTimeBetweenStops(TreeMap<Integer, StopInfo> stopPriorityMap){
		Iterator<Entry<Integer, StopInfo>> it = stopPriorityMap.entrySet().iterator();
		TreeMap<Integer,StopInfoPriorityBean> stopDistanceMap = new TreeMap<Integer, StopInfoPriorityBean>();
		Integer key1=null,key2=null;
		StopInfo value1 = null,value2 = null;
		Entry<Integer, StopInfo> entry = null;
		if(it.hasNext()){
			entry = it.next();
			key1 = entry.getKey();
			value1 = entry.getValue();
		}
		while(it.hasNext()){
			entry = it.next();
			key2 = entry.getKey();
			value2 = entry.getValue();
			Integer x= getTimeBetweenStop(value1.getStoplattitude(),value1.getStoplongitude(),value2.getStoplattitude(),value2.getStoplongitude());
			stopDistanceMap.put(key1, new StopInfoPriorityBean(key1, value1, x, x));
			key1 = key2;
			value1 = value2;
		}
		stopDistanceMap.put(key1, new StopInfoPriorityBean(key1, value1, 0, 0));
		return stopDistanceMap;
	}
	
	//compute time and distance between two stops
	public Integer getTimeBetweenStop(String stop1lat,String stop1long,String stop2lat,String stop2long){
		return 20;
	}
	
	//to send message or delay the thread
	public Integer computeTime(String bus,String currentStopPriority,Integer nextcallTime,TreeMap<Integer, StopInfoPriorityBean> stopPriorityMap){
		Integer notificationTime = 5;
		Integer overheadTime = 2;
		Integer x=null;
		String stop=null;
		for(Integer key :stopPriorityMap.keySet()){
			if(currentStopPriority.equals(stopPriorityMap)){
				stop = stopPriorityMap.get(key).toString();
				break;
			}
		}
		if(nextcallTime==null){
			x = getTimeBetweenStop(bus, stop);
			nextcallTime = x-notificationTime-overheadTime;
		}
		//send nextcallTime,abc,currentStopPriorityToo
		return x;
	}*/

}
