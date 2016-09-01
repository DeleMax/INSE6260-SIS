package com.concordia.models;

public class Student extends User {
	
	private String cgpa;
	private String degree;
	private int creditsearned;
	private int totalcredits;
	private String department;
	private double tutionfee;	
	private int gender;
	private String status;

	
	public Student(){
		
	}
	
	public Student(String studentId, String firstName, String lastName, String cgpa, String degree, int creditsearned, int totalcredits,
			String phone, String department, double tutionfee, int age, int gender, String status ) {
		super();
		this.userId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.degree = degree;
		this.creditsearned = creditsearned;
		this.totalcredits = totalcredits;
		this.phone = phone;
		this.department = department;
		this.tutionfee = tutionfee;		
		this.age = age;
		this.gender = gender;
		this.status = status;
		
	}
	
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCreditsearned() {
		return creditsearned;
	}
	public void setCreditsearned(int creditsearned) {
		this.creditsearned = creditsearned;
	}
	public int getTotalcredits() {
		return totalcredits;
	}
	public void setTotalcredits(int totalcredits) {
		this.totalcredits = totalcredits;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public double getTutionfee() {
		return tutionfee;
	}
	public void setTutionfee(double tutionfee) {
		this.tutionfee = tutionfee;
	}	
}

