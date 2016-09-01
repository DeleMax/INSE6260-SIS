package com.concordia.dao;

import java.sql.SQLException;

import com.concordia.models.User;

/**
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public User isValidUser(String username, String password) throws SQLException;
}
