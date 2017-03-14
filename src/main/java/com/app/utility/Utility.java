package com.app.utility;

import org.apache.commons.lang3.StringUtils;

public class Utility {
	
	private Utility(){
		
	}
	
	public static boolean isEmpty(Object target){
		if(target instanceof String){
			return StringUtils.isEmpty((String)target);
		}else{
			throw new RuntimeException("Type not supported yet.");
		}
	}
	
	//if original is null then return default
	public static <T>  T safeValue(T target, T defaultVal){
		if(target == null){
			return defaultVal;
		}else{
			return target;
		}
	}

}
