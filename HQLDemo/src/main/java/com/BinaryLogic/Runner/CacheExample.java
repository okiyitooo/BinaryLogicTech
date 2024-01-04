package com.BinaryLogic.Runner;

import org.hibernate.Session;
import com.BinaryLogic.Model.Student;
import com.BinaryLogic.Util.HibernateUtil;

public class CacheExample {

    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Session session2 = HibernateUtil.getSessionFactory().openSession();

        // Get the same student object using two different sessions
        Student student1 = getStudentById(session1, 1L);
        Student student2 = getStudentById(session2, 1L);

        // Check if the student objects are the same
        if (student1 == student2) {
            System.out.println("First-level cache hit! Objects are the same");
        } else {
            System.out.println("First-level cache miss! Objects are different");
        }

        // Close session1
        session1.close();

        // Get the same student object again using session2
        student2 = getStudentById(session2, 1L);

        // Check if the student object has changed
        if (student1 == student2) {
            System.out.println("Second-level cache hit! Object is the same");
        } else {
            System.out.println("Second-level cache miss! Object has changed");
        }
        
        session2.close();
    }

    private static Student getStudentById(Session session, Long id) {
        Student student = (Student) session.get(Student.class, id);
        System.out.println("Student with ID " + id + " fetched from the database");
        return student;
    }
}