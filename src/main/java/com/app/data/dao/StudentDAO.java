package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.StudentInfo;

@Repository
public class StudentDAO extends BaseHibernateDAO<StudentInfo> {

	protected StudentDAO() {
		super(StudentInfo.class);
	}

}
