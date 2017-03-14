package com.app.role.task.worker;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.app.data.beans.UserInfo;
import com.app.role.task.RoleBeanBuilder;
import com.app.utility.GenericLogger;

@Component
@Lazy
public class ParentBuilder implements RoleBeanBuilder {

	@Override
	public void build(UserInfo userInfo) {
		GenericLogger.log.info("inside parent builder");
		
	}

}
