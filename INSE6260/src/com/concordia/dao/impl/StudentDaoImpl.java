package com.concordia.dao.impl;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.format.datetime.standard.DateTimeContext;

import com.concordia.dao.StudentDao;
import com.concordia.models.Admin;
import com.concordia.models.Course;
import com.concordia.models.Student;
import com.concordia.models.StudentCourse;
import com.concordia.models.User;


public class StudentDaoImpl implements StudentDao
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
		public List getAllStudent() throws SQLException {
			
			List<Student> list = new ArrayList<Student>();
			
			String query = "Select * from Student";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				list.add(new Student(resultSet.getString(14),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),
						resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9),
						resultSet.getDouble(10), resultSet.getInt(11), resultSet.getInt(12), resultSet.getString(13)));
			}
			
			return list;
		}

		@Override
		public boolean registerStudentCourse(String studentId, String courseCode, String courseName,String professor, String term, String year) throws SQLException {
		
			PreparedStatement pstmt = null;
			String query = null;
			boolean retData = false;
			int resultSet;
			
			query = "UPDATE Course SET maxstudents = maxstudents - 1, regstudents = regstudents + 1 WHERE id > 0 and maxstudents > 0 and code = ?";
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, courseCode);
			resultSet = pstmt.executeUpdate();
			retData = resultSet == 1 ? true : false;
			
			if(!retData)
				return retData;
			
			query = "INSERT INTO StudentCourses (studentid,coursecode,coursename,grade,term,year,status,credits,professor,gradeunit) VALUES(?,?,?,?,?,?,?,?,?,?)";
				
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, studentId);
			pstmt.setString(2, courseCode);
			pstmt.setString(3, courseName);
			pstmt.setString(4, "N/A");
			pstmt.setString(5, term);
			pstmt.setString(6, year);
			pstmt.setString(7, "Incomplete");
			pstmt.setInt(8, 4);
			pstmt.setString(9, professor);
			pstmt.setDouble(10, 0.0);
			
			resultSet = pstmt.executeUpdate();
		    retData = resultSet == 1 ? true : false;
			
			return retData;
		
		}

		@Override
		public boolean dropStudentCourse(String studentId, String courseCode, String status, String term, String year) throws SQLException {
			
			PreparedStatement pstmt = null;
			String query = null;
			boolean retData = false;
			if(status.toLowerCase().equals("disc"))
			{
				query = "UPDATE StudentCourses SET grade = ? where id> 0 and coursecode = ? and studentid = ? and term =  ? and year = ?";
				
				pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, "DISC");
				pstmt.setString(2, courseCode);
				pstmt.setString(3, studentId);
				pstmt.setString(4, term);
				pstmt.setString(5, year);
				int resultSet = pstmt.executeUpdate();
				retData = resultSet == 1 ? true : false;
			}
			else{
				query = "DELETE FROM StudentCourses where id> 0  and coursecode = ? and studentid = ? and term =  ? and year = ? ";
				
				pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, courseCode);
				pstmt.setString(2, studentId);
				pstmt.setString(3, term);
				pstmt.setString(4, year);
				boolean resultSet = pstmt.execute();
				retData = resultSet;
			}
			return retData;
		}

		@Override
		public List getStudentCourseByTerm(String studentId, String term, String year) throws SQLException {
			
			List<StudentCourse> list = new ArrayList<StudentCourse>();
			
			String query = "Select * from StudentCourses Where studentid=? and term=? and year=? and grade <> ? ";
			
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, studentId);
			pstmt.setString(2, term);
			pstmt.setString(3, year);
			pstmt.setString(4, "DISC");
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				list.add(new StudentCourse(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getDouble(11)));
			}
			
			return list; 
		}

		@Override
		public List getStudentGPAByTerm(String studentId, String term, String year) throws SQLException {
			
			if(!term.isEmpty() && !year.isEmpty())
				return getStudentCourseByTerm(studentId,term,year);
			else
			{
				List<StudentCourse> list = new ArrayList<StudentCourse>();
				
				String query = "Select * from StudentCourses Where studentid=? and grade <> ?";
				
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, studentId);
				pstmt.setString(2, "N/A");
				ResultSet resultSet = pstmt.executeQuery();
				
				while(resultSet.next()){
					list.add(new StudentCourse(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getDouble(11)));
				}
				
				return list; 
				
			}
		}

}