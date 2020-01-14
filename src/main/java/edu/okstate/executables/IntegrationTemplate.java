package edu.okstate.executables;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.okstate.entities.*;


public class IntegrationTemplate {

	@SuppressWarnings("unchecked")
	public static ArrayList<String> returnTempalteHeaders(int choice) {

		ArrayList<String> list = new ArrayList<String>();

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

			switch(choice){

			case 1 :
				list = (ArrayList<String>) session.createQuery("select templateName from TemplateHeaderData").list();
				break;
			case 2 :
				list = (ArrayList<String>) session.createQuery("select description from ProjectHeaderData").list();
				break;
			}

			session.getTransaction().commit();

			System.out.println("Done!");

		}finally {
			session.close();
			factory.close();
		}
		return list;
	}
}