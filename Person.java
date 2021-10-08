package com.example.demo.Model;

public class Person {
	private String name;
	private String lastName;
	private String birthDay;
	private String email;

	public Person(String name, String lastName, String localDate, String email) {
		this.name = name;
		this.lastName = lastName;
		this.birthDay = localDate;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}