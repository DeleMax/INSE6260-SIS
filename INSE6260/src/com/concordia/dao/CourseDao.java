package com.concordia.dao;

import java.sql.SQLException;
import java.util.List;

import com.concordia.models.Course;
import com.concordia.models.User;

/**
 * This interface will be used to communicate with the
 * Database
 */
public interface CourseDao
{		
		public List getAllCourse() throws SQLException;
		public List getCourseByTerm(String studentId,String term, String year) throws SQLException;	
}
