package com.app.role.task;

import com.app.data.beans.UserInfo;

public interface RoleBeanBuilder extends RoleBasedTask {
	public void build(UserInfo userInfo);
}
