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

public class CalculteAgeApp {

	private static final String SQL_INSERT_QUERY = "SELECT " + "TIMESTAMPDIFF(YEAR, dateOfBirth, NOW()) AS years, "
			+ "TIMESTAMPDIFF(MONTH, dateOfBirth, NOW()) % 12 AS months, "
			+ "TIMESTAMPDIFF(DAY, dateOfBirth, NOW()) % 30 AS days, "
			+ "TIMESTAMPDIFF(HOUR, dateOfBirth, NOW()) % 24 AS hours, "
			+ "TIMESTAMPDIFF(MINUTE, dateOfBirth, NOW()) % 60 AS minutes, "
			+ "TIMESTAMPDIFF(SECOND, dateOfBirth, NOW()) % 60 AS seconds " + "FROM users WHERE id = ?";

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

				int years = resulteSet.getInt("years");
				int months = resulteSet.getInt("months");
				int days = resulteSet.getInt("days");
				int hours = resulteSet.getInt("hours");
				int minutes = resulteSet.getInt("minutes");
				int seconds = resulteSet.getInt("seconds");

				System.out.println("Age is: " + years + " years, " + months + " months, " + days + " days, " + hours
						+ " hours, " + minutes + " minutes, " + seconds + " seconds.");

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
