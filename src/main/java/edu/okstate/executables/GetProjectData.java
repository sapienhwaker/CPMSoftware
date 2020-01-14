package edu.okstate.executables;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.okstate.entities.*;
import java.util.List;


public class GetProjectData {

	@SuppressWarnings("unchecked")
	public static List<ProjectDataFull> getProjectData(String choice) {
		System.out.println("recieved choice is::::::::::::::::::::::::::::::::::::::::::::::::::::::::: "+choice);
		List<ProjectHeaderData> headerDetails;
		List<ProjectDataFull> projectDetails;

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
			headerDetails = session.createQuery("from ProjectHeaderData p where p.description = :choice").setParameter("choice", choice).list();
			int projectID = headerDetails.get(0).getId();
			System.out.println("ID from get Project Data.................................................."+projectID);
			int templateID = headerDetails.get(0).getTemplateId().getId();
			System.out.println("ID from get Template Header.................................................."+templateID);


			projectDetails = session.createQuery("from ProjectDataFull p where p.compound.proHeaderDataId.id = :projectID").setParameter("projectID", projectID).list();

			if(projectDetails.isEmpty())
				System.out.println("ProjectDetails List came from ProjectDataAll is empty+++++++++++++++++++++++++++++++++++++++++++");

			session.getTransaction().commit();
			System.out.println("Done!");

		}finally {
			session.close();
			factory.close();
		}

		return projectDetails;
	}
}