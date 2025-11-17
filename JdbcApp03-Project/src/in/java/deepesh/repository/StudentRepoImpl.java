package in.java.deepesh.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.java.deepesh.dto.Student;
import in.java.deepesh.utility.DBUtil;

public class StudentRepoImpl implements IStudentRepo {

	private static Connection connection = null;

	static {

		try {
			connection = DBUtil.getDBConection();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertRecord(Student student) throws SQLException {

		Statement statement = null;

		if (connection != null) {
			statement = connection.createStatement();
		}

		String sqlInsertQuery = null;

		Integer sId = student.getSid();

		String sName = student.getSname();

		Integer sAge = student.getSage();

		sqlInsertQuery = "Insert into student values(" + sId + ",'" + sName + "'," + sAge + ")";

		if (statement != null && sqlInsertQuery != null) {
			return statement.executeUpdate(sqlInsertQuery);
		}
		return 0;

	}

}
