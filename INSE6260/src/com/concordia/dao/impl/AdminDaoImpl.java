package com.concordia.dao.impl;


import com.concordia.dao.AdminDao;
import com.concordia.dao.CourseDao;
import com.concordia.dao.StudentDao;


public class AdminDaoImpl implements AdminDao
{

		private StudentDao studentDao;
		private CourseDao courseDao;
		
		
		public StudentDao getStudentDao() {
			return studentDao;
		}
		public void setStudentDao(StudentDao studentDao) {
			this.studentDao = studentDao;
		}
		public CourseDao getCourseDao() {
			return courseDao;
		}
		public void setCourseDao(CourseDao courseDao) {
			this.courseDao = courseDao;
		}
		
}