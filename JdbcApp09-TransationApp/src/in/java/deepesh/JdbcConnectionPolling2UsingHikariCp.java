package in.java.deepesh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionPolling2UsingHikariCp {

	private static final String SQL_SELECT_QUERY = "select eid,ename,esal,eaddress from employees";

	public static void main(String[] args) {
		String fileInfo = "D:\\pwskillsOctbatch\\JdbcConnectionPooling-13\\src\\com\\pwskills\\properties\\hikaricp.properties";
		//HikariConfig config = new HikariConfig(fileInfo);

		try (HikariDataSource dataSource = new HikariDataSource(config)) {

			try (Connection connection = dataSource.getConnection()) {
				try (Statement statement = connection.createStatement()) {
					try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_QUERY)) {
						System.out.println("EID\tENAME\tESAL\tEADDR");
						while (resultSet.next()) {
							System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
									+ resultSet.getInt(3) + "\t" + resultSet.getString(4));
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
