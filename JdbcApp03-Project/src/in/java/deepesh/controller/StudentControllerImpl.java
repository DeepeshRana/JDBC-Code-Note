package in.java.deepesh.controller;

import java.sql.SQLException;

import in.java.deepesh.dto.Student;
import in.java.deepesh.factory.StudentServiceFactory;
import in.java.deepesh.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public int insertRecord(Student student) throws SQLException {
		IStudentService service = StudentServiceFactory.getIStudentService();

		return service.insertRecord(student);
	}

}
