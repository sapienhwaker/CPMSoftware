package edu.okstate.executables;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.okstate.entities.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.query.Query;

public class UpdateProjectHeader {

    @SuppressWarnings("unchecked")
    public static void updateProjectHeader(String selected, String a, String b, String c, String d, String e, String f, String g, String h, String i) {
        List<ProjectHeaderData> projectHeaders;
        boolean flag = true;

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

            projectHeaders = session.createQuery("from ProjectHeaderData p where p.description = :selected").setParameter("selected", selected).list();
            int targetId = projectHeaders.get(0).getId();

            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("update ProjectHeaderData set description = :a, county = :b, projNum = :c, jobNum = :d, hgNum = :e, Engineer = :f, date = :g, ref = :h, sta = :i"
                    + " where id = :targetId");
            query.setParameter("a", a);
            query.setParameter("b", b);
            query.setParameter("c", c);
            query.setParameter("d", d);
            query.setParameter("e", e);
            query.setParameter("f", f);
            query.setParameter("g", g);
            query.setParameter("h", h);
            query.setParameter("i", i);
            query.setParameter("targetId", targetId);

            int result = query.executeUpdate();

            System.out.println("query execution return value: " + result);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (java.lang.IndexOutOfBoundsException ex) {
            javax.swing.JFrame frame;
            frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, "Please select the project", "NO SELECTION", JOptionPane.WARNING_MESSAGE);
            flag = false;
        }catch(org.hibernate.exception.DataException exc){
            javax.swing.JFrame frame;
            frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, "Please enter the VALID DATE value", "INVALID DATE VALUE", JOptionPane.WARNING_MESSAGE);
            flag = false;
        }
        catch (Exception exe) {
            exe.printStackTrace();
            javax.swing.JFrame frame;
            frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, "Please change the Project Description entry", "PROJECT ALREADY EXISTS", JOptionPane.WARNING_MESSAGE);
            flag = false;
        } finally {
            session.close();
            factory.close();
        }

        if (flag == true) {
            javax.swing.JFrame frame;
            frame = new JFrame("Information");
            JOptionPane.showMessageDialog(frame, "Record saved!", "Success!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
