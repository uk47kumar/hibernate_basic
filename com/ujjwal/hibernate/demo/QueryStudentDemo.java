package com.ujjwal.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ujjwal.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
				
			// start a transaction
			session.beginTransaction();
			
			//query Student
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display Student
			displayStudents(theStudents);
			
			// query students: lastName='kumar'
			theStudents = session.createQuery("from Student s where s.lastName='kumar'").list();
			
			// display the student
			System.out.println("\nStudents who have last name of kumar");
			displayStudents(theStudents);
			
			// query students: lastName= 'sharma' OR firstName='rohit'
			theStudents = 
					session.createQuery("from Student s where"
			+ " s.lastName='kumar' OR firstName='rohit'").list();
			
			System.out.println("\nStudents who have last name of kumar OR first name rohit");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
