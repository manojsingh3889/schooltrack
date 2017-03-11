package com.app.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GateKeeper {
	protected static final Logger log = LoggerFactory.getLogger(GateKeeper.class);
	
	@Around("com.app.config.aspect.SystemArchitecture.inWebLayer()")
	public Object apiCallTrail(ProceedingJoinPoint point) throws Throwable{
		log.info("Entering mehtod "+point.getSignature().toShortString());
		long starttime = System.currentTimeMillis();
		Object obj = point.proceed();
		log.info("Leaving mehtod "+point.getSignature().toShortString()+" [Time taken "+(System.currentTimeMillis()-starttime)+"ms]");
		return obj;
	}
}
