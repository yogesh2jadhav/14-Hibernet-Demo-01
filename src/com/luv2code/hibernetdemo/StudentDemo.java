package com.luv2code.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 
public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory mySessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session mySession = mySessionFactory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object for Yogesh");
			Student myStudent = new Student("Yogesh", "Jadhav", "yogesh.2jadhav@gmail.com");
			
			System.out.println("Started Transaction...");
			mySession.beginTransaction();
			System.out.println("Saving Student Object....");
			mySession.save(myStudent);
			System.out.println("Closing Transaction....");
			mySession.getTransaction().commit();
			
		} finally {
			
			System.out.println("Finally closing Session.....");
			mySession.close();
		}

	}

}
