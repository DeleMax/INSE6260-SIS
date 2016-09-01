package com.concordia.models;

public class Course {

	private String code;
	private String name;
	private String term;
	private int maxstudents;
	private int regstudents;
	private int maxwaitlist;
	private int waitlistcount;
	private int credits;
	private String department;
	private String professor;
	private String year;
	
	public Course(){
		
	}
	
	public Course(String code, String name, String term, int maxstudents, int regstudents, int maxwaitlist,
			int waitlistcount, int credits, String department, String professor, String year) {
		super();
		this.code = code;
		this.name = name;
		this.term = term;
		this.maxstudents = maxstudents;
		this.regstudents = regstudents;
		this.maxwaitlist = maxwaitlist;
		this.waitlistcount = waitlistcount;
		this.credits = credits;
		this.department = department;
		this.professor = professor;
		this.year = year;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getMaxstudents() {
		return maxstudents;
	}
	public void setMaxstudents(int maxstudents) {
		this.maxstudents = maxstudents;
	}
	public int getRegstudents() {
		return regstudents;
	}
	public void setRegstudents(int regstudents) {
		this.regstudents = regstudents;
	}
	public int getMaxwaitlist() {
		return maxwaitlist;
	}
	public void setMaxwaitlist(int maxwaitlist) {
		this.maxwaitlist = maxwaitlist;
	}
	public int getWaitlistcount() {
		return waitlistcount;
	}
	public void setWaitlistcount(int waitlistcount) {
		this.waitlistcount = waitlistcount;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}
