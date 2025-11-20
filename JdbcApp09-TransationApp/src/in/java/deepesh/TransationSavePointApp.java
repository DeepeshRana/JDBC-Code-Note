package in.java.deepesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import in.java.utility.DBUtil;

public class TransationSavePointApp {

	// Driver code
	public static void main(String[] args) {
		try (Connection connection = DBUtil.getDBConection()) {

			try (Statement statement = connection.createStatement()) {

				connection.setAutoCommit(false);

				statement.executeUpdate("insert into savepoint(`name`,`party`) values('rahul','congress')");
				statement.executeUpdate("insert into savepoint(`name`,`party`) values('modi','bjp')");

				Savepoint sp = connection.setSavepoint();

				statement.executeUpdate("insert into savepoint(`name`,`party`) values('siddu','bjp')");

				System.out.println("Opps something went wrong ! opertation are roolleback !");

				connection.rollback(sp);

				connection.commit();

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}