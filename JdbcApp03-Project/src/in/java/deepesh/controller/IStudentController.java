package in.java.deepesh.controller;

import java.sql.SQLException;

import in.java.deepesh.dto.Student;

public interface IStudentController {

	public int insertRecord(Student student) throws SQLException;

}
