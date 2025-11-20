package in.java.deepesh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import in.java.utility.DBUtil;

public class CachedRowSetApp {

	public static void main(String[] args) {

		CachedRowSet cachedRowSet = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getDBConection();

			statement = connection.createStatement();
			resultSet = statement.executeQuery("select eid,ename,esal,eaddress from employees");

			RowSetFactory factory = RowSetProvider.newFactory();

			// DisConnected based rowSet
			cachedRowSet = factory.createCachedRowSet();

			// Copy ResultSet object to CachedRowSet
			cachedRowSet.populate(resultSet);

			connection.close();

			System.out.println("Employee Details in Forward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (resultSet.next()) {// RE: SQLException
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
						+ "\t" + resultSet.getString(4));
			}

			System.out.println("Employee Details in Forward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (cachedRowSet.next()) {
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t"
						+ cachedRowSet.getInt(3) + "\t" + cachedRowSet.getString(4));
			}

			System.out.println();

			System.out.println("Employee Details in Backward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (cachedRowSet.previous()) {
				System.out.println(cachedRowSet.getInt(1) + "\t" + cachedRowSet.getString(2) + "\t"
						+ cachedRowSet.getInt(3) + "\t" + cachedRowSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cachedRowSet != null) {
				try {
					cachedRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
