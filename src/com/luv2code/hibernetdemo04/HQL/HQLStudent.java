package com.luv2code.hibernetdemo04.HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 
public class HQLStudent {

	public static void main(String[] args) {
		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addPackage("com.luv2code.hibernetdemo04.HQL")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session mySession = myFactory.getCurrentSession();
		
		
		try {
			
			System.out.println("From Student===>\n");
			mySession.beginTransaction();
  		 	List<Student> stdList = mySession.createQuery("from Student").list();
			DisplayStudent(stdList);	
  			mySession.getTransaction().commit();

  			mySession = myFactory.getCurrentSession();
			System.out.println("From Student where last_name like %jav%===>\n");
			mySession.beginTransaction();
  		 	stdList = mySession.createQuery("from Student where last_name like 'Jad%'").list();
			DisplayStudent(stdList);	
  			mySession.getTransaction().commit();
  			
  			
  			mySession = myFactory.getCurrentSession();
  			mySession.beginTransaction();
  			System.out.println("From Student s where s.stdFirstName like '%ogesh% or s.stdLastName like '%shin%' ==>\n");
  			stdList = mySession.createQuery("from Student s where s.stdFirstName like '%ogesh%' or s.stdLastName like '%shin%'").getResultList();
  			DisplayStudent(stdList);
  			mySession.getTransaction().commit();
  			
  			
  			mySession=myFactory.getCurrentSession();
  			mySession.beginTransaction();
  			System.out.println("Updateing Data...");
  			
  			Student myStudent = mySession.get(Student.class, 1);
  			Random myRandom = new Random();
  			int num = myRandom.nextInt(10);
  			myStudent.setStdEmail(myStudent.getStdFirstName()+num+"@gmail.com");
  			mySession.getTransaction().commit();
  			
  			mySession=myFactory.getCurrentSession();
  			mySession.beginTransaction();
  			System.out.println("Updateing Data...");
  			
  			myStudent = mySession.get(Student.class, 2);
  			//mySession.delete(myStudent);
  			mySession.getTransaction().commit();
  			

		} finally {
			mySession.close();
			// TODO: handle finally clause
		}
		
		
	}

	private static void DisplayStudent(List<Student> stdList) {
		for(Student myStudent : stdList) {
			System.out.println( myStudent);
		}
	}

}
