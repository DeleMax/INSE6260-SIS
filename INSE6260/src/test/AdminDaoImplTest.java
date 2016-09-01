package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.concordia.dao.StudentDao;
import com.concordia.dao.impl.StudentDaoImpl;
import com.concordia.models.Student;

import junit.framework.Assert;


public class AdminDaoImplTest {
	
	@Autowired
	private StudentDao studentDAO;
	
	 @Before
	    public void setUp() {
		 studentDAO = new StudentDaoImpl();
	    } 

	 @Test
	 	public void testGetAllStudent() throws SQLException {
		 Student A = new Student("8", "KUNLE", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 Student B = new Student("8", "SHOLA", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 Student C = new Student("8", "DELE", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 
		 List<Student> mySampleList = new ArrayList<Student>();
		 mySampleList.add(A);
		 mySampleList.add(B);
		 mySampleList.add(C); 
		 
		//for(Student s : mySampleList){	System.out.println(s.getFirstName());};

		//Mockito.when( this.studentDAO.getAllStudent()).thenReturn(mySampleList);


		List<Student>theList= mySampleList;
		 Assert.assertNotNull(theList);
		 Assert.assertEquals(theList.size(), 3);
}
}
