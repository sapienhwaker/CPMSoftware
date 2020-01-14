package edu.okstate.executables;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import edu.okstate.entities.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaveFullRecord {

    static int headerID;

    public static List<ProjectDataFull> saveFullRecord(List<ProjectDataFull> list) {
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

            System.out.println("Details arrived in SaveFullRecord\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

            session.beginTransaction();
            for (ProjectDataFull proData : list) {
                //System.out.println(proData);
                session.save(proData);

            }

            System.out.println("SaveFullRecord FOR LOOP OVER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }
        javax.swing.JFrame frame;
        frame = new JFrame("Information");
        JOptionPane.showMessageDialog(frame, "The record has been saved successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
        return list;
    }

    public static int getHeaderID() {
        return headerID;
    }

    public static void setHeaderID(int headerID) {
        SaveFullRecord.headerID = headerID;
    }
}
