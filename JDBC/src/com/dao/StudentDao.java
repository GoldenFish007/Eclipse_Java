package com.dao;

import com.connection.ConnectionManager;
import com.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	
	

	public int insert(Student stud) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("INSERT INTO students(firstname, lastname, age) VALUES(?,?,?)");

			ptmt.setString(1, stud.getFirstName());
			ptmt.setString(2, stud.getLastName());
			ptmt.setInt(3, stud.getAge());

			result = ptmt.executeUpdate();

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
		return result;
	}

	public int update(Student stud, int id) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("UPDATE students SET firstname=?, lastname=?, Age=? WHERE id=?");

			ptmt.setString(1, stud.getFirstName());
			ptmt.setString(2, stud.getLastName());
			ptmt.setInt(3, stud.getAge());
			ptmt.setInt(4, id);

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
			System.out.println("There is no such student identified by the id " + id);

		return result;
	}

	public int delete(int id) throws SQLException {

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

	public void select(Student std) throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("SELECT * FROM students WHERE firstname=? AND lastname=? AND Age=?");

			ptmt.setString(1, std.getFirstName());
			ptmt.setString(2, std.getLastName());
			ptmt.setInt(3, std.getAge());

			resultSet = ptmt.executeQuery();

			int count = 0;
			while (resultSet.next()) {

				System.out.println("ID = " + resultSet.getInt("id") + "  " + " FirstName = "
						+ resultSet.getString("firstname") + "  " + " LastName = " + resultSet.getString("lastname")
						+ "  " + " Age = " + resultSet.getInt("age"));
				count++;

			}

			if (count == 0)
				System.out.print("There is no such student in the data base ");

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
	}

	public void selectAll() throws SQLException {

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;

		try {

			con = ConnectionManager.getConnection();
			ptmt = con.prepareStatement("SELECT * FROM students");

			resultSet = ptmt.executeQuery();

			int count = 0;
			while (resultSet.next()) {

				System.out.println("ID = " + resultSet.getInt("id") + "  " + " FirstName = "
						+ resultSet.getString("firstname") + "  " + " LastName = " + resultSet.getString("lastname")
						+ "  " + " Age = " + resultSet.getInt("age"));
			}
			if (count == 0)
				System.out.print("The data base is empty");
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
	}

}