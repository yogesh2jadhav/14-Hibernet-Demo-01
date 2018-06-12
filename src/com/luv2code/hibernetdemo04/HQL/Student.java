package com.luv2code.hibernetdemo04.HQL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int stdId;
	
	@Column(name="first_name")
	public String stdFirstName;
	
	@Column(name="last_name")
	public String stdLastName;
	
	@Column(name="email")
	public String stdEmail;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stdFirstName, String stdLastName, String stdEmail) {
		super();
		this.stdFirstName = stdFirstName;
		this.stdLastName = stdLastName;
		this.stdEmail = stdEmail;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdFirstName() {
		return stdFirstName;
	}

	public void setStdFirstName(String stdFirstName) {
		this.stdFirstName = stdFirstName;
	}

	public String getStdLastName() {
		return stdLastName;
	}

	public void setStdLastName(String stdLastName) {
		this.stdLastName = stdLastName;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdFirstName=" + stdFirstName + ", stdLastName=" + stdLastName
				+ ", stdEmail=" + stdEmail + "]";
	}

	
	
}
