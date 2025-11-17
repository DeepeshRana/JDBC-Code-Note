package in.java.deepesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class FatchDateApp {

	private static final String SQL_INSERT_QUERY = "select id , username , dateofbirth from users where id = ?";

	public static void main(String[] args) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resulteSet = null;

		int rowCount = 0;

		try {
			connection = DBUtil.getDBConection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			}

			Scanner scanner = new Scanner(System.in);

			if (preparedStatement != null && scanner != null) {
				System.out.println("Enter the Student Id");

				int sId = scanner.nextInt();

				preparedStatement.setInt(1, sId);

				resulteSet = preparedStatement.executeQuery();
			}

			if (resulteSet.next()) {

				System.out.println(resulteSet.getInt(1) + "\t" + resulteSet.getString(2) + "\t"
						+ convertTOString(resulteSet.getDate(3)));

			} else {
				System.out.println("Record Not Found !");
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, preparedStatement, connection);
		}

	}

	private static String convertTOString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return simpleDateFormat.format(date);
	}

}
