package in.java.deepesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import in.java.utility.DBUtil;

public class TransationIsolationLevelsApp {

	// Driver code
	public static void main(String[] args) {
		try (Connection connection = DBUtil.getDBConection()) {

			System.out.println(connection.getTransactionIsolation());
			connection.setTransactionIsolation(8);
			System.out.println(connection.getTransactionIsolation());

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
