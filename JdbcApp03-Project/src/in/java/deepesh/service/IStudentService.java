package in.java.deepesh.service;

import java.sql.SQLException;

import in.java.deepesh.dto.Student;

public interface IStudentService {

	public int insertRecord(Student student) throws SQLException;

}
