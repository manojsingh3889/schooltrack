package com.app.data.dao;

import com.app.data.beans.StudentReference;

public class StudentReferenceDAO extends BaseHibernateDAO<StudentReference>{

	protected StudentReferenceDAO() {
		super(StudentReference.class);
	}
}
