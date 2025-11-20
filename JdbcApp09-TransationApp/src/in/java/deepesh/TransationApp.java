package in.java.deepesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class TransationApp {

	// Driver code
	public static void main(String[] args) {
		try (Connection connection = DBUtil.getDBConection()) {

			try (Statement statement = connection.createStatement()) {

				try (ResultSet resultSet = statement.executeQuery("select * from fund")) {
					System.out.println("Data Before the transation !");

					while (resultSet.next()) {
						System.out.println(resultSet.getString(2) + "  " + resultSet.getInt(3));
					}
				}
				System.in.read();
				System.out.println("Transation begins..............");

				connection.setAutoCommit(false);

				statement.executeUpdate("update fund set fund = fund + 90000 where name = 'sachin'");

				statement.executeUpdate("update fund set fund = fund - 90000 where name = 'dhoni'");

				Scanner scanner = new Scanner(System.in);

				String option = scanner.next();

				if (option.equalsIgnoreCase("yes")) {
					connection.commit();
					System.out.println("Transation commited");
				} else {
					connection.rollback();
					System.out.println("Transation Rollback !");
				}

				try (ResultSet resultSet = statement.executeQuery("select * from fund")) {
					System.out.println("Data Before the transation !");

					while (resultSet.next()) {
						System.out.println(resultSet.getString(2) + "  " + resultSet.getInt(3));
					}
				}

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
