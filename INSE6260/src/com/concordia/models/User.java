package com.concordia.models;

public class User
{
		protected String userId;
		protected String firstName;
		protected String lastName;
		protected int age;
		protected String phone;
		protected String password;
		protected String role;
		protected String enabled;

		public User(){
			
		}
		
		public User(String userId, String firstName, String lastName, int age, String phone, String password, String role, String enabled) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.phone = phone;
			this.password = password;
			this.role = role;
			this.enabled = enabled;
		}

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getEnabled() {
			return enabled;
		}
		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}
		
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}


}
