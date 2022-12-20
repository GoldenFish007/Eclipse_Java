import java.sql.SQLException;

import com.dao.StudentDao;
import com.entities.Student;

public class test {

	public static void main(String[] args) throws SQLException {

		Student student = new Student();
		StudentDao dao = new StudentDao();

		int result = 10;

		student =dao.createStudent("Luis", "johnson", 30);

	//	result = dao.insert(student);
	//	result = dao.delete(13);
	//	result = dao.update(student, 30);
	//	dao.select(student);
	//	dao.selectAll();

	}
}
