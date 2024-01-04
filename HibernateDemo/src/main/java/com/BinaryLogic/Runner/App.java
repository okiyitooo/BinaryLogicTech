package com.BinaryLogic.Runner;

import com.BinaryLogic.Dao.StudentDao;
import com.BinaryLogic.Model.Student;

public class App {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(new Student("Joe", "Rogan"));
		for (Student e : studentDao.getAllStudents())
			System.out.println(e);
		System.out.println(studentDao.getStudentById(5));
//		student.sa
	}
}
