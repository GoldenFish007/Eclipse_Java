package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;
import com.entities.Student;

public class StudentDao {
	
	public static Student insert(Student stud) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		if (stud.getFirstName() == null || stud.getLastName() == null)
			throw new IllegalArgumentException("invalid inputs");

		try {

			String sqlString = "INSERT INTO students(firstname, lastname, age) VALUES(?,?,?)";
			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement(sqlString, PreparedStatement.RETURN_GENERATED_KEYS);

			ptmt.setString(1, stud.getFirstName());
			ptmt.setString(2, stud.getLastName());
			ptmt.setInt(3, stud.getAge());

			ptmt.execute();
			rs = ptmt.getGeneratedKeys();

			if (rs.next())
				stud.setId(rs.getInt(1));

			System.out.println("Data Added Successfully");

		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stud;
	}

	public static int update(Student stud) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("UPDATE students SET firstname=?, lastname=?, Age=? WHERE id=?");

			ptmt.setString(1, stud.getFirstName());
			ptmt.setString(2, stud.getLastName());
			ptmt.setInt(3, stud.getAge());
			ptmt.setInt(4, stud.getId());

			result = ptmt.executeUpdate();

		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (result != 0)
			System.out.println("Table Updated Successfully");
		else
			System.out.println("There is no such student identified by the id " + stud.getId());

		return result;
	}

	public static int delete(int id) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("DELETE FROM students WHERE id=?");

			ptmt.setInt(1, id);

			result = ptmt.executeUpdate();

		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (result != 0)
			System.out.println("Data deleted Successfully");
		else
			System.out.println("There is no such student identified by the id " + id);

		return result;
	}

	public static List<Student> select(Student std) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		Student student = null;
		List<Student> rs = null;
		int current = 1;

		try {

			con = ConnectionManager.getConnection();
			String sqlString = "SELECT * FROM students WHERE 1=1";

			if (std.getFirstName() != null)
				sqlString += " AND firstname = ?";

			if (std.getLastName() != null)
				sqlString += " AND lastname = ?";

			if (std.getAge() != 0)
				sqlString += " AND Age = ?";

			ptmt = con.prepareStatement(sqlString);

			if (std.getFirstName() != null)
				ptmt.setString(current++, std.getFirstName());

			if (std.getLastName() != null)
				ptmt.setString(current++, std.getLastName());

			if (std.getAge() != 0)
				ptmt.setInt(current++, std.getAge());
			
			resultSet = ptmt.executeQuery();
			
			while (resultSet.next()) {
				
				student = new Student();
				
				student.setId(resultSet.getInt("id"));
				student.setFirstName(resultSet.getString("firstname"));
				student.setLastName(resultSet.getString("lastname"));
				student.setAge(resultSet.getInt("Age"));
				
				rs = new ArrayList<>();
				rs.add(student);
				
				System.out.print(student.toString());
			}
			
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}

}