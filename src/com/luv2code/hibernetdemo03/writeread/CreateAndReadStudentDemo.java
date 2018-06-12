package com.luv2code.hibernetdemo03.writeread;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateAndReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session mySession = myFactory.getCurrentSession();
		
		
		try {
			
			System.out.println("Creating two student object");
			
			Student myStudent = new Student ("Sushil", "Pandy", "Sushil@gmail.com");
			Student myStudent2 = new Student ("Amar", "Sawant", "amar@gmail.com");
			
			System.out.println("Transaction Begin....");
			mySession.beginTransaction();
			
			System.out.println("Saving Student 1");
			mySession.save(myStudent);
			System.out.println("Saving Student 2");
			mySession.save(myStudent2);
			System.out.println("Transaction Commit");
			mySession.getTransaction().commit();
			
			int index = myStudent2.getStdId();
			System.out.println("Student Id = "+index);
			
			mySession=myFactory.getCurrentSession();
			mySession.beginTransaction();
			System.out.println("Getting Student based on id = " + index);
			Student currentStudent= mySession.get(Student.class, index);
			mySession.getTransaction().commit();
			System.out.println("See what I got when I qureied Student= "+ currentStudent);
			
		} finally {
			// TODO: handle finally clause
			myFactory.close();
		}

	}

}
