package test;

import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.concordia.dao.impl.UserDaoImpl;
import com.concordia.models.Admin;
import com.concordia.models.User;


public class UserDaoImplTest {
	@Mock
	UserDaoImpl userDAO;
	User A;
	 @Before
	    public void create() throws SQLException {
		  A = new Admin("8", "KUNLE", "AJAYI", 30, "MENG");
			A.setPassword("meeeeee");
			A.setUserId("deleeey");
		 MockitoAnnotations.initMocks(this);
		 Mockito.when(userDAO.isValidUser(Mockito.anyString(), Mockito.anyString())).thenReturn(A);
	    } 

	 @Test
	 public void test() throws SQLException{
		 assertSame(A, userDAO.isValidUser(A.getUserId(),A.getPassword()));
	 }

	
}

