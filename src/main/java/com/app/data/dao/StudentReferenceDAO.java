package com.app.data.dao;

import org.springframework.stereotype.Repository;

import com.app.data.beans.StudentReference;

@Repository
public class StudentReferenceDAO extends BaseHibernateDAO<StudentReference>{

	protected StudentReferenceDAO() {
		super(StudentReference.class);
	}
}
