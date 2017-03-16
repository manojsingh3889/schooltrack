package com.app.role.task;

import com.app.data.beans.UserInfo;

public abstract class RoleBeanBuilder implements RoleBasedTask {
	public abstract UserInfo build(UserInfo userInfo);
}
