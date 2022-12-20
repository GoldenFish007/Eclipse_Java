import java.sql.SQLException;

import com.dao.StudentDao;
import com.entities.Student;

public class test {

	public static void main(String[] args) throws SQLException {

		Student student = new Student();
		StudentDao dao = new StudentDao();

		int result = 0;

		student.setFirstName("Real");
		student.setLastName("Updated");
		student.setAge(24);

	//	result = dao.insert(student);
	//	result = dao.delete(12);
	//	result = dao.update(student, 30);
	//	dao.select(student);
	//	dao.selectAll();

	}
}
