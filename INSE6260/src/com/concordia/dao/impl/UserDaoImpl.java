package com.concordia.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.concordia.dao.UserDao;
import com.concordia.models.Admin;
import com.concordia.models.Student;
import com.concordia.models.User;


public class UserDaoImpl implements UserDao
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
		public User isValidUser(String username, String password) throws SQLException
		{
				String query = "Select * from Users where userid = ? and password = ? and enabled = 1";
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet resultSet = pstmt.executeQuery();
				if (resultSet.next())
					return getUser(resultSet.getString(2), resultSet.getString(5));
				else
					return null;
		}
		
		private User getUser(String userId, String role) throws SQLException{
			
			String query = "";
			PreparedStatement pstmt;
			ResultSet resultSet;
			
			if(role.equals("student")){
				query = "Select * from Student where studentid = ?";
				pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, userId);
				resultSet = pstmt.executeQuery();
				if (resultSet.next()){
					return new Student(resultSet.getString(14),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),
								resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9),
								resultSet.getDouble(10), resultSet.getInt(11), resultSet.getInt(12), resultSet.getString(13));
				}
			}else{
				query = "Select * from Admin where adminid = ?";
				pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, userId);
				resultSet = pstmt.executeQuery();
				if (resultSet.next()){
					return new Admin(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getInt(5),
								resultSet.getString(6));
				}
			}
			
			return null;
			
		}

}