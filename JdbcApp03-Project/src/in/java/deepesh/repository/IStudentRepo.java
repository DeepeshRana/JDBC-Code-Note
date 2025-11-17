package in.java.deepesh.repository;

import java.sql.SQLException;

import in.java.deepesh.dto.Student;

public interface IStudentRepo {

	public int insertRecord(Student student) throws SQLException;

}
