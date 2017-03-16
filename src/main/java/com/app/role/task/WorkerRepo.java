package com.app.role.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.app.config.AppConfig;
import com.app.module.um.LoginManager;
import com.app.role.task.worker.ParentBuilder;

@Component
public class WorkerRepo {
	
	@Autowired
    private ApplicationContext context;
	
	public static final String WORKER_PACKAGE = "com.app.role.task.worker";
	
	@SuppressWarnings("unchecked")
	public <T extends RoleBasedTask> T getWorker(String concreteType) throws ClassNotFoundException{
		T t;
		try {
			t = (T) context.getBean(concreteType);
			return t;
		} catch (NullPointerException e) {
			throw new ClassNotFoundException("Class is not present in application context, either missing or not a spring component", e);
		}
	} 
}
