package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.concordia.dao.impl.CourseDaoImpl;
import com.concordia.dao.impl.StudentDaoImpl;
import com.concordia.models.Course;
import com.concordia.models.Student;

import junit.framework.Assert;


public class StudentDaoImplTest {
	
	@Mock
	StudentDaoImpl studentDAO;
	 Student A, B, C;
	 CourseDaoImpl courseDAO;
		 Course D, E, F;
	boolean y = true;
	 @Before
	    public void create() throws SQLException {
		 A= new Student("8", "KUNLE", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 B = new Student("8", "SHOLA", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 C = new Student("8", "DELE", "AJAYI", "3.7", "MENG", 30, 45,
					"5145717721", "SOEN", 1200.00, 2, 1, "SINGLE" );
		 
		 D= new Course("inse6260", "quality asurance", "winter", 20, 20, 5,
					3, 4, "inse", "rachida", "2016" );
		 E = new Course("inse6260", "quality asurance", "summer", 20, 20, 5,
					3, 4, "inse", "rachida", "2016");
		 F = new Course("inse6260", "quality asurance", "fall", 20, 20, 5,
					3, 4, "inse", "rachida", "2016");
		 
		 List<Student> mySampleList = new ArrayList<Student>();
		 mySampleList.add(A);
		 mySampleList.add(B);
		 mySampleList.add(C); 
		 
		 MockitoAnnotations.initMocks(this);

		Mockito.when( studentDAO.getAllStudent()).thenReturn(mySampleList);
		
		Mockito.when( studentDAO.registerStudentCourse(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		Mockito.when( studentDAO.dropStudentCourse( Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(true);
   
	 } 

	 @Test
	 	public void testGetAllStudent() throws SQLException {
		 List<Student> returnedStudent = studentDAO.getAllStudent();

		 Assert.assertNotNull(returnedStudent);
		 Assert.assertEquals(returnedStudent.size(), 3);
}
	 @Test
	 	public void RegisterStudentCourse() throws SQLException {
		boolean w = studentDAO.registerStudentCourse("8","inse6260","quality asurance", "rachida","summer","2016");

		 Assert.assertEquals(y, w);
}
	 @Test
	 	public void DropStudentCourse() throws SQLException {
		boolean X = studentDAO.dropStudentCourse("8","inse6260","DISC","summer","2016");

		 Assert.assertEquals(y, X);
}
}
