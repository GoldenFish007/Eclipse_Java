package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.entities.Student;
import com.mybatis.Sessionfactory;
import com.mybatis.Studentmapper;

public class Test {

	public static void main(String[] args) {

		// insertMapper();
		// deleteMapper();
		// updateMapper();
		// selectAllMapper();
		// selectByIdMapper();
		// selectByFirstNameMapper();
		// selectByLastNameMapper();
		selectByAgeMapper();

	}

	private static void insertMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);
			Student student = new Student();

			student.setFirstName("First");
			student.setLastName("InsertAnnotation");
			student.setAge(30);

			stdmapper.insert(student);
			session.commit();

		} finally {
			session.close();
		}

	}

	private static void deleteMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			stdmapper.delete(40);
			session.commit();

		} finally {
			session.close();
		}
	}

	private static void updateMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			Student student = new Student();

			student.setId(41);
			student.setFirstName("Updated");
			student.setLastName("Well");
			student.setAge(30);

			stdmapper.update(student);
			session.commit();

		} finally {
			session.close();
		}
	}

	private static void selectAllMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			List<Student> allStudents = new ArrayList<Student>();

			allStudents = stdmapper.selectStudents();
			session.commit();

			for (Student student : allStudents) {
				System.out.print(student.toString());
			}

		} finally {
			session.close();
		}

	}

	private static void selectByIdMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			System.out.print(stdmapper.selectById(42).toString());
			session.commit();

		} finally {
			session.close();
		}

	}

	private static void selectByFirstNameMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			System.out.print(stdmapper.selectByName("Updated").toString());
			session.commit();

		} finally {
			session.close();
		}
	}

	private static void selectByLastNameMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			System.out.print(stdmapper.selectByLasName("well").toString());
			session.commit();

		} finally {
			session.close();
		}
	}

	private static void selectByAgeMapper() {

		SqlSession session = null;

		try {

			session = Sessionfactory.buildSqlSessionFactory().openSession();
			Studentmapper stdmapper = session.getMapper(Studentmapper.class);

			List<Student> allStudents = new ArrayList<Student>();

			allStudents = stdmapper.selectByAge(30);
			session.commit();

			for (Student s : allStudents) {
				System.out.print(s.toString());
			}

		} finally {
			session.close();
		}
	}

}
