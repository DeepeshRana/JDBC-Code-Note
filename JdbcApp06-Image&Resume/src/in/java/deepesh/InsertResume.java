package in.java.deepesh;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class InsertResume {

	private static final String SQL_INSERT_QUERY = "Insert into jobpdf(`name`,`resume`) values(?,?)";

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

				preparedStatement.setCharacterStream(2, new FileReader(
						new File("C:\\Users\\Deepesh Rana\\Pictures\\2024\\1. Language Fundamentals.pdf")));

				rowCount = preparedStatement.executeUpdate();
			}

			if (rowCount == 0) {
				System.out.println("Error occur");
			} else {
				System.out.println("Done Operation :: " + rowCount);
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, preparedStatement, connection);
		}

	}

}
