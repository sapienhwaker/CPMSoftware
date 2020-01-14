package edu.okstate.executables;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.okstate.entities.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProjectSearch {

    @SuppressWarnings("unchecked")
    public static ArrayList<String> returnTempalteHeaders(String a, String b, String c, String d, String e, String f, String g, String h, String i) {

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

            list = (ArrayList<String>) session.createQuery("select p.description from ProjectHeaderData p where p.description = :a or p.county = :b or p.projNum = :c or p.jobNum = :d or p.hgNum = :e or p.Engineer = :f or p.date = :g or p.ref = :h or p.sta = :i")
                    .setParameter("a", a)
                    .setParameter("b", b)
                    .setParameter("c", c)
                    .setParameter("d", d)
                    .setParameter("e", e)
                    .setParameter("f", f)
                    .setParameter("g", g)
                    .setParameter("h", h)
                    .setParameter("i", i)
                    .list();

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception exc) {
            javax.swing.JFrame frame;
            frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, "Please give VALID Entries", "NO SEARCH RESULTS FOUND", JOptionPane.WARNING_MESSAGE);
        } finally {
            session.close();
            factory.close();
        }
        return list;
    }

}
