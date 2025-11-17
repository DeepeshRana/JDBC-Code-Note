package in.java.deepesh.service;

import java.sql.SQLException;

import in.java.deepesh.dto.Student;
import in.java.deepesh.factory.StudentRepoFactory;
import in.java.deepesh.repository.IStudentRepo;

public class StudentServiceImpl implements IStudentService {

	@Override
	public int insertRecord(Student student) throws SQLException {

		IStudentRepo repo = StudentRepoFactory.getStudentRepo();

		return repo.insertRecord(student);
	}

}
