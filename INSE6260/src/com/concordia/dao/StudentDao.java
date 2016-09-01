package com.concordia.dao;

import java.sql.SQLException;
import java.util.List;

import com.concordia.models.Course;
import com.concordia.models.Student;
import com.concordia.models.User;

/**
 * This interface will be used to communicate with the
 * Database
 */
public interface StudentDao
{		
		public List<Student> getAllStudent() throws SQLException;
		public List getStudentCourseByTerm(String studentId, String term, String year) throws SQLException;
		public boolean registerStudentCourse(String studentId, String courseCode, String courseName, String professor, String term, String year) throws SQLException;
		public boolean dropStudentCourse(String studentId, String courseCode, String status, String term, String year) throws SQLException;
		public List getStudentGPAByTerm(String studentId, String term, String year) throws SQLException;
}
