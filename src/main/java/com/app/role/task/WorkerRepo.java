package com.app.role.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class WorkerRepo {
	@Autowired
    private static AnnotationConfigApplicationContext appContext;
	
	public static final String WORKER_PACKAGE = "com.app.role.task.worker";
	
	
	public static <T extends RoleBasedTask> T getWorker(String concreteType) throws ClassNotFoundException{
		T t;
		try {
			t = (T) appContext.getBean(concreteType);
			return t;
		} catch (NullPointerException e) {
			throw new ClassNotFoundException("Class is not present in application context, either missing or not a spring component", e);
		}
	} 
}
