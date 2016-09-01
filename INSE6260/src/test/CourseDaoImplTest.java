package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.concordia.dao.impl.CourseDaoImpl;
import com.concordia.models.Course;
import com.concordia.models.StudentCourse;

import junit.framework.Assert;


public class CourseDaoImplTest {
	
	@Mock
	CourseDaoImpl courseDAO;
	Course A, B, C;
	StudentCourse course1, course2, course3;
	
	@Before
	    public void create() throws SQLException {
		 A= new Course("inse6260", "quality asurance", "winter", 20, 20, 5,
					3, 4, "inse", "rachida", "2016" );
		 B = new Course("inse6260", "quality asurance", "summer", 20, 20, 5,
					3, 4, "inse", "rachida", "2016");
		 C = new Course("inse6260", "quality asurance", "fall", 20, 20, 5,
					3, 4, "inse", "rachida", "2016");
		 
		 course1 = new StudentCourse("8", "inse6260", "quality asurance", "A", "Summer", "2016",
					" ", 4, "rachida", 4.0);
		 course2 = new StudentCourse("6", "soen6441", "advance programming", "B+", "Winter", "2016",
					" ", 4, "joey", 3.6);
		 course3 = new StudentCourse("10", "soen6771", "advance architecture", "A+", "Winter", "2016",
					" ", 4, "joey", 4.3);
		 
		 List<Course> mySampleList = new ArrayList<Course>();
		 mySampleList.add(A);
		 mySampleList.add(B);
		 mySampleList.add(C);
		 
		 List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		 courseList.add(course1);
		 courseList.add(course2);
		 courseList.add(course3);
		 
		 Iterator itr = courseList.iterator();
		    while(itr.hasNext()){
		        if(itr.next().equals(course3))
		            itr.remove();
		    }
		    
		MockitoAnnotations.initMocks(this);
		Mockito.when( courseDAO.getAllCourse()).thenReturn(mySampleList);
		Mockito.when( courseDAO.getCourseByTerm( Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(courseList);

		 
	}
		

		
		 @Test
		 	public void testGetAllCourse() throws SQLException {
			 List<Course> returnedCourse = courseDAO.getAllCourse();

			 Assert.assertNotNull(returnedCourse);
			 Assert.assertEquals(returnedCourse.size(), 3);
	}

	 @Test
	 	public void testGetCourseByTerm() throws SQLException {
		 List<StudentCourse> newCourseList = courseDAO.getCourseByTerm("6","Winter","2016");

		 Assert.assertNotNull(newCourseList);
		 Assert.assertEquals(newCourseList.size(), 2);
}
}