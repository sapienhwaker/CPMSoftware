package edu.okstate.executables;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import edu.okstate.entities.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.query.Query;

public class DeleteCompleteRecord {

    static int headerID;

    public static void deleteCompleteRecord(String choice) {
        int projectId;
        List<ProjectHeaderData> headerDetails;
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

            projectId = headerDetails.get(0).getId();

            @SuppressWarnings("rawtypes")
            Query query1 = session.createQuery("delete ProjectHeaderData p where p.id = :projectId");
            query1.setParameter("projectId", projectId);
            int result1 = query1.executeUpdate();
            System.out.println("DELETE QUERY EXECUTION RESULT " + result1);
            Query query = session.createQuery("delete ProjectDataFull p where p.compound.proHeaderDataId.id = :projectId");
            query.setParameter("projectId", projectId);
            int result = query.executeUpdate();
            System.out.println("DELETE PROJECTFULLDATA QUERY EXECUTION RESULT " + result);
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }

    public static int getHeaderID() {
        return headerID;
    }

    public static void setHeaderID(int headerID) {
        DeleteCompleteRecord.headerID = headerID;
    }
}
