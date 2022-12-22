package com.test;
import java.sql.SQLException;
import java.util.List;

import com.dao.StudentDao;
import com.entities.Student;

public class Test {

	public static void main(String[] args) {

		try {

		//	insertStudent();
		//	updateStudent();
		//	deleteStudent();
			selectStudent();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Student insertStudent() throws SQLException {

		Student student = new Student();

		student.setFirstName("will");
		student.setLastName("smith");
		student.setAge(30);

		return StudentDao.insert(student);
	}

	private static int updateStudent() throws SQLException {

		Student student = new Student();

		student.setId(27);
		student.setFirstName("UPDATED");
		student.setLastName("WELL");
		student.setAge(18);

		return StudentDao.update(student);

	}

	private static int deleteStudent() throws SQLException {

		return StudentDao.delete(27);

	}

	private static List<Student> selectStudent() throws SQLException {

		Student student = new Student();

		student.setFirstName(null);
		student.setLastName(null);
		student.setAge(0);

		return StudentDao.select(student);
	}
}
