package com.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entities.Student;

public interface Studentmapper {

	@Insert("INSERT INTO students (firstname, lastname, age) VALUES (#{firstName}, #{lastName}, #{age})")
	public void insert(Student stud);

	@Delete("DELETE FROM students WHERE id = #{param1}")
	public boolean delete(int id);
	
	@Update("UPDATE students SET firstname = #{firstName}, lastname = #{lastName}, age = #{age} WHERE id = #{id}")
	public boolean update(Student stud);
	
	@Select("SELECT * FROM students")
	public List<Student> selectStudents ();
	
	@Select("SELECT * FROM students WHERE id = #{param1}")
	public Student selectById (int id);

	@Select("SELECT * FROM students WHERE firstname = #{firstName}")
	public Student selectByName(String string);

	@Select("SELECT * FROM students WHERE lastname = #{lastName}")
	public Student selectByLasName(String string);
	
	@Select("SELECT * FROM students WHERE age = #{param1}")
	public  List<Student> selectByAge(int age);
	
}
