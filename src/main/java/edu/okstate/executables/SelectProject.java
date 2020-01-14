package edu.okstate.executables;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.okstate.entities.*;
import java.util.ArrayList;
import org.hibernate.query.Query;


public class SelectProject {

	@SuppressWarnings("unchecked")
	public static ArrayList<String> returnHeaderDetails(String choice) {

		ArrayList<Object[]> list = new ArrayList<Object[]>();
		ArrayList<String> headerDetails = new ArrayList<String>();

		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(ProjectHeaderData.class).
				addAnnotatedClass(CompoundKeyProData.class).
				addAnnotatedClass(ProjectDataFull.class).
				addAnnotatedClass(TemplateHeaderData.class).
				addAnnotatedClass(TemplateData.class).
				addAnnotatedClass(CompoundKeyTempData.class).
				buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery("select p.description, p.county, p.projNum, p.jobNum, p.hgNum, p.Engineer, p.date, p.ref, p.sta from ProjectHeaderData p where p.description = :choice").setParameter("choice", choice);
			list = (ArrayList<Object[]>)q.list();
			session.getTransaction().commit();

			for(Object[] employee: list){

				for(int i = 0; i < 9; i++){
					headerDetails.add((String)employee[i]);
				}
			}
			System.out.println(headerDetails);
			System.out.println("Done!");

		}finally {
			session.close();
			factory.close();
		}

		return headerDetails;
	}
}