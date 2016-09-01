package com.concordia.models;

public class StudentCourse {

	private String studentid;
	private String coursecode;
	private String coursename;
	private String grade;
	private String term;
	private String year;
	private String status;
	private int credits;
	private String professor;
	private double gradeunit;
	
	public StudentCourse(){
		
	}
			
	public StudentCourse(String studentId, String coursecode, String coursename, String grade, String term, String year,
			String status, int credits, String professor, double gradeunit) {
		super();
		this.studentid = studentId;
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.grade = grade;
		this.term = term;
		this.year = year;
		this.status = status;
		this.credits = credits;
		this.professor = professor;
		this.gradeunit = gradeunit;
	}
	
	public String getStudentId() {
		return studentid;
	}
	public void setStudentId(String studentId) {
		this.studentid = studentId;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public double getGradeunit() {
		return gradeunit;
	}
	public void setGradeunit(double gradeunit) {
		this.gradeunit = gradeunit;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
}
