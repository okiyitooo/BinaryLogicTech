package com.BinaryLogic.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="table_of_students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="first_name")
	String fName;
	@Column(name="last_name")
	String lName;
	@Column(name="email")
	String email;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String fName, String lName, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fName+" "+this.lName+" email: "+this.email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
