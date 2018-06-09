package com.luv2code.hibernetdemo.AutoIn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentAIDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session mySession = myFactory.getCurrentSession();
		
		try {
			System.out.println("Createing new Student....");
			Student newStudent = new Student("Shreeansh", "Jadhav", "shreeansh.2jadhav@gmail.com");
			Student newStudent2 = new Student("Sujit", "Shinde", "sujit@gmail.com");

			System.out.println("Begin Transaction");
			mySession.beginTransaction();
			System.out.println("Saving.. Student object. Studnet =" + newStudent);
			mySession.save(newStudent);
			mySession.save(newStudent2);
			System.out.println("Commiting Transaction..");
			mySession.getTransaction().commit();
			
		} finally {
			
			mySession.close();
			// TODO: handle finally clause
		}
	}

}
