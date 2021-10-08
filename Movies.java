package com.example.demo.Model;

public class Movies {
	private String movie;
	private String name;
	private String year;
	
	public Movies(String movie, String name, String year) {
		this.movie = movie;
		this.year = year;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getMovie() {
		return movie;
	}
	public String getYear() {
		return year;
	}
}
