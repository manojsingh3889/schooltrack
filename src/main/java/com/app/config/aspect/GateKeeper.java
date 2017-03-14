package com.app.config.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.utility.Utility;


@Aspect
@Component
public class GateKeeper {
	protected static final Logger log = LoggerFactory.getLogger(GateKeeper.class);
	
	@Around("com.app.config.aspect.SystemArchitecture.inWebLayer()")
	public Object apiCallTrail(ProceedingJoinPoint point) throws Throwable{
		MethodSignature signature = (MethodSignature) point.getSignature();
		RequestMapping methodAnnotation =  signature.getMethod().getAnnotation(RequestMapping.class);
	    RequestMapping clazzAnnotation = signature.getMethod().getDeclaringClass().getAnnotation(RequestMapping.class);
	    String urlCalled = Utility.safeValue(clazzAnnotation.value()[0], "<unknown>")+Utility.safeValue(methodAnnotation.value()[0], "<unknown>");
	    
	    //auditing
		log.info("Called Url[ "+urlCalled+" ] :: accessing Entering mehtod "+point.getSignature().toShortString());
		long starttime = System.currentTimeMillis();
	    
		Object obj = point.proceed();
		log.info("Url[ "+urlCalled+" ] ::: Leaving mehtod "+point.getSignature().toShortString()+" [Time taken "+(System.currentTimeMillis()-starttime)+"ms]");
		return obj;
	}
}
