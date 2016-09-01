package com.concordia.models;

public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String adminId, String firstName, String lastName, int age, String phone) {
		super();
		this.userId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
	}

		
}
