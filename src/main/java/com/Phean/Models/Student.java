package com.Phean.Models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "Age")
	private String Age;
	
	@Column(name = "Score")
	private String Score;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}
}
