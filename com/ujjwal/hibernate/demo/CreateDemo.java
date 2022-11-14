package com.ujjwal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ujjwal.hibernate.demo.entity.Instructor;
import com.ujjwal.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			
			/*Instructor tempInstructor =
					new Instructor("ujjwal","kumar","uk47kumar@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.emperorgaming.com/youtube","coding");
					*/
			
			Instructor tempInstructor =
					new Instructor("raj","malhotra","raj@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.raj.com/youtube","gaming");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will Also save the instructor details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
