package com.concordia.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.concordia.dao.CourseDao;
import com.concordia.dao.StudentDao;
import com.concordia.models.Admin;
import com.concordia.models.Course;
import com.concordia.models.Student;
import com.concordia.models.StudentCourse;
import com.concordia.models.User;


public class CourseDaoImpl implements CourseDao
{

		DataSource dataSource;

		public DataSource getDataSource()
		{
				return this.dataSource;
		}

		public void setDataSource(DataSource dataSource)
		{
				this.dataSource = dataSource;
		}

		@Override
		public List getAllCourse() throws SQLException {
			
			List<Course> list = new ArrayList<Course>();
			
			String query = "Select * from Course";
			
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				list.add(new Course(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
			}
						
			return list; 
		}

		@Override
		public List getCourseByTerm(String studentId, String term, String year) throws SQLException {
			
			List<Course> list = new ArrayList<Course>();
			
			String query ="SELECT * FROM Course where code  not in (SELECT coursecode from StudentCourses where studentid = ? and year = ? and term = ?) and year = ? and term= ? ";
			
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, studentId);
			pstmt.setString(2, year);
			pstmt.setString(3, term);
			pstmt.setString(4, year);
			pstmt.setString(5, term);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				list.add(new Course(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
			}
						
			return list; 
		}
		
}