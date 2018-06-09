package com.luv2code.hibernetdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentX")
public class Student {

	@Id
	@Column(name="id")
	public int student_id;
	
	@Column(name="first_name")
	public String student_firstName;

	@Column(name = "last_name")
	public String student_lastName;

	@Column(name = "email")
	public String student_email;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String student_firstName, String student_lastName, String student_email) {
		this.student_firstName = student_firstName;
		this.student_lastName = student_lastName;
		this.student_email = student_email;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_firstName() {
		return student_firstName;
	}

	public void setStudent_firstName(String student_firstName) {
		this.student_firstName = student_firstName;
	}

	public String getStudent_lastName() {
		return student_lastName;
	}

	public void setStudent_lastName(String student_lastName) {
		this.student_lastName = student_lastName;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_firstName=" + student_firstName + ", student_lastName="
				+ student_lastName + ", student_email=" + student_email + "]";
	}	
	
	
	
}
