package com.concordia.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.concordia.dao.CourseDao;
import com.concordia.dao.StudentDao;
import com.concordia.dao.impl.CourseDaoImpl;
import com.concordia.dao.impl.StudentDaoImpl;
import com.concordia.models.Student;
 
@Controller
@RequestMapping(value="/admin")
public class AdminController {
 
	@Autowired
    private StudentDao studentdao = new StudentDaoImpl();

	@Autowired
    private CourseDao  coursedao = new CourseDaoImpl();
    
    @RequestMapping(value="/student", method=RequestMethod.GET,headers="Accept=application/json")
    public @ResponseBody List getStudent() throws SQLException {
        return studentdao.getAllStudent();
    }
    
    @RequestMapping(value="/studentcourses", method=RequestMethod.POST,headers="Accept=application/json")
    public @ResponseBody List getStudentCourse(@RequestParam("studentId") String studentId, @RequestParam("term") int term, @RequestParam("year") String year) throws SQLException {	
    	String _term = "";
    	if(term==1)_term = "1";
    	else if(term==2)_term = "2";
    	else if(term==3)_term = "3";
    	return studentdao.getStudentCourseByTerm(studentId, _term, year);
    }
    
    @RequestMapping(value="/coursebyparams", method=RequestMethod.POST,headers="Accept=application/json")
    public @ResponseBody List getCourseByParams(@RequestParam("studentId") String studentId, @RequestParam("term") String term, @RequestParam("year") String year) throws SQLException {	
    	
    	return coursedao.getCourseByTerm(studentId, term, year);
    }
    
    @RequestMapping(value="/course", method=RequestMethod.GET,headers="Accept=application/json")
    public @ResponseBody List getCourse() throws SQLException {	
        return coursedao.getAllCourse();
    }
    
    
}