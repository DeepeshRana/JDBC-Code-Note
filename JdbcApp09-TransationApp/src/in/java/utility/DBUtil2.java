package in.java.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class DBUtil2 {
	private static Properties properties = null;

	private DBUtil2() {
	}

	static {
		FileInputStream fis = null;

		String fileInfo = "src//com//jee//property//databases.properties";
		try {
			fis = new FileInputStream(fileInfo);
			if (fis != null) {
				properties = new Properties();
				properties.load(fis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Connection getDBConection() throws IOException, SQLException {
		// 1. Establishing the Connection

		// Here tight copling apply :

		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();

		dataSource.setUrl(properties.getProperty("url"));
		dataSource.setUser(properties.getProperty("user"));
		dataSource.setPassword(properties.getProperty("password"));

		return dataSource.getConnection();
	}

}
