package com.BinaryLogic.Runner;

import com.BinaryLogic.Dao.StudentDao;
import com.BinaryLogic.Model.Student;

public class App {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student("Jotaro", "JoeStar", "DIOisGay@Gmail.com");
//		studentDao.saveStudent(student);
		studentDao.updateStudent(student);
	}
}