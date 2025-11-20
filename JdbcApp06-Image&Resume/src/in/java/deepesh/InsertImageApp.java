package in.java.deepesh;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class InsertImageApp {

	private static final String SQL_INSERT_QUERY = "Insert into job(`name`,`image`) values(?,?)";

	public static void main(String[] args) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		int rowCount = 0;

		try {
			connection = DBUtil.getDBConection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			}

			Scanner scanner = new Scanner(System.in);

			if (preparedStatement != null && scanner != null) {

				System.out.println("Enther the name of student");

				String sName = scanner.next();

				preparedStatement.setString(1, sName);

				preparedStatement.setBinaryStream(2,
						new FileInputStream("C:\\Users\\Deepesh Rana\\Pictures\\20210123_210149.jpg"));

				rowCount = preparedStatement.executeUpdate();
			}

			if (rowCount == 0) {
				System.out.println("Error occur");
			} else {
				System.out.println("Done Operation :: " + rowCount);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, preparedStatement, connection);
		}

	}

}
