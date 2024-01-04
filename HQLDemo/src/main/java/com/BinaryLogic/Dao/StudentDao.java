package com.BinaryLogic.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BinaryLogic.Model.Student;
import com.BinaryLogic.Util.HibernateUtil;

import jakarta.persistence.Query;

public class StudentDao {
	public void saveStudent(Student student) {
		
		Transaction transaction = null;
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(student);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		} finally {
			if (session!=null)
				session.close();
		}
		
	}
	public void insertStudent() {
		Transaction transaction = null;
		Session session= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "insert into student (firstName,lastName,email)"+"SELECT firstName, lastName, email from student";
			Query query = session.createNativeQuery(hql);

			int result = query.executeUpdate();
			System.out.println(result+" row(s) affected.");
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	public void updateStudent(Student student) {
		Transaction transaction = null;
		Session session= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "update table_of_students set first_name = :firstName "+"where id = :id";
			Query query = session.createNativeQuery(hql);
			query.setParameter("firstName", student.getfName());
			query.setParameter("id", student.getId());

			int result = query.executeUpdate();
			System.out.println(result+" row(s) affected.");
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public Student getStudent(int id){
		Transaction transaction= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Student student;
			String hql = "From table_of_students S where S.id = :id";
			Query query= session.createQuery(hql);
			query.setParameter("id", id);
			List<Student> result = query.getResultList();
			if (result!=null) {
				student = result.get(0);
			} else {
				throw new Exception("Student not found");
			}
			System.out.println(result.size()+" rows affected");
			transaction.commit();
			return student;
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally { 
			session.close();
		}
		return null;
	}
	public void deleteStudent(int id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try { 
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student!=null) {
				String hql = "Delete from table_of_students where id = :id";
				Query query = session.createNativeQuery(hql);
				query.setParameter("id", id);
				int result = query.executeUpdate();
				System.out.println(result+" row(s) affected.");
				
			} else {
				throw new Exception("Student not found");
			}			
			transaction.commit();
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			session.close();
		}
	}
}
