package com.BinaryLogic.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BinaryLogic.Exceptions.DuplicateStudentException;
import com.BinaryLogic.Exceptions.StudentNotFoundException;
import com.BinaryLogic.Model.Student;
import com.BinaryLogic.Util.HibernateUtil;

public class StudentDao {
	//save student
	public  void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			// Check for existing student with the same first and last name
		    String firstName = student.getfName();
		    String lastName = student.getlName();
		    Query query = session.createQuery("FROM Student WHERE first_name = :firstName AND last_name = :lastName");
		    query.setParameter("firstName", firstName);
		    query.setParameter("lastName", lastName);

		    if (query.getResultList().isEmpty()) {
		    	session.save(student);
		    } else {
		    	throw new DuplicateStudentException(String.format("Student with first name %s and last name %s already exists", firstName, lastName));
		    }
			session.save(student);
			transaction.commit();
		} catch (Exception e){
			System.out.println(e.getMessage());
			if (transaction!=null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}
	//getAllStudents
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		  transaction = session.beginTransaction();
		  // Create a criteria query
		  CriteriaQuery<Student> criteriaQuery = session.getCriteriaBuilder().createQuery(Student.class);
		  Root<Student> root = criteriaQuery.from(Student.class);
		  criteriaQuery.select(root);
		
		  // Get the query result
		  List<Student> students = session.createQuery(criteriaQuery).getResultList();
		
		  transaction.commit();
		  // Close the session
			return students;
		} catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();  
		} finally {
			session.close();
		}
		return new ArrayList<>();
	}
	//getStudentById
	public Student getStudentById(int id) {
		Transaction transaction = null;
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  Student student = null;

		  try {
			  transaction = session.beginTransaction();
		    student = session.get(Student.class, id);
		    transaction.commit();
		  } catch (Exception e) {
		    e.printStackTrace();
		    transaction.rollback();
		    // Handle exception appropriately (e.g., log error)
		  } finally {
		    if (session != null) {
		      session.close();
		    }
		  }

		  return student;
		}

	//UpdateStudent
	public void updateStudent(Student student) {
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  Transaction transaction = null;

	  try {
	    transaction = session.beginTransaction();
	    session.saveOrUpdate(student);
	    transaction.commit();
	  } catch (Exception e) {
	    if (transaction != null) {
	      transaction.rollback();
	    }
	    e.printStackTrace();
	  } finally {
	    if (session != null) {
	      session.close();
	    }
	  }
	}

	//DeleteStudent
	public void deleteStudent(Student student) {
		  Transaction transaction = null;
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try {
			  transaction = session.beginTransaction();
		    // Check if student exists
			  Student existingStudent = session.get(Student.class, student.getId());
			  if (existingStudent != null) {
			    	session.delete(existingStudent);
			  } else {
			    	throw new StudentNotFoundException(String.format("Student with ID %d not found", student.getId()));
			  }
			  transaction.commit();
		  } catch (Exception e) {
			    if (transaction != null) {
			      transaction.rollback();
			    }
			    System.out.println(e.getMessage());
		  } finally {
			    if (session != null) {
			      session.close();
			    }
		  }
		}

}
