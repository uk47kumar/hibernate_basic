package com.ujjwal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ujjwal.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("virat","kholi","virat7kuamr@gmail.com");
				
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// my new code
			
			// find out the student's : primary key
			System.out.println("The student Generated id is : "+ tempStudent.getId());
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
