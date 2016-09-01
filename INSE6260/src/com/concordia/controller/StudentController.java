package com.concordia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concordia.dao.CourseDao;
import com.concordia.dao.StudentDao;
import com.concordia.dao.impl.CourseDaoImpl;
import com.concordia.dao.impl.StudentDaoImpl;
 
@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
    private StudentDao studentdao = new StudentDaoImpl();
	
	@Autowired
    private CourseDao coursedao = new CourseDaoImpl();
     
    @RequestMapping(value="/coursesbyterm", method=RequestMethod.POST)
    public @ResponseBody List studentCourse(@RequestParam("studentId") String studentId, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {
		
        return studentdao.getStudentCourseByTerm(studentId, term, year);
    }
    
    @RequestMapping(value="/gpabyterm", method=RequestMethod.POST)
    public @ResponseBody List studentGPA(@RequestParam("studentId") String studentId, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {
		
        return studentdao.getStudentGPAByTerm(studentId, term, year);
    }
    
    @RequestMapping(value="/dropcourse", method=RequestMethod.POST)
    public @ResponseBody boolean dropCourseByTerm(@RequestParam("studentId") String studentId,@RequestParam("courseCode") String courseCode, @RequestParam("status") String status, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {
		
        return studentdao.dropStudentCourse(studentId, courseCode, status, term, year);
    }
    
    @RequestMapping(value="/addcourse", method=RequestMethod.POST)
    public @ResponseBody boolean addCourseByTerm(@RequestParam("studentId") String studentId,@RequestParam("courseCode") String courseCode, @RequestParam("courseName") String courseName, @RequestParam("professor") String professor, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {
		
        return studentdao.registerStudentCourse(studentId, courseCode, courseName,professor, term, year);
    }
    
    @RequestMapping(value="/courseslist", method=RequestMethod.POST)
    public @ResponseBody List courseListByTerm(@RequestParam("studentId") String studentId, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {
		
        return coursedao.getCourseByTerm(studentId, term, year);
    }
    
}