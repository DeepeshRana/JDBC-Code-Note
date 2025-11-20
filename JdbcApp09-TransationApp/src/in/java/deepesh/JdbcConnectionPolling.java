package in.java.deepesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.java.utility.DBUtil2;

public class JdbcConnectionPolling {

	/*
	 * 
	 * Connectino Polling code
	 */

	public static void main(String[] args) {
		try (Connection connection = DBUtil2.getDBConection()) {

			try (Statement statement = connection.createStatement()) {

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
