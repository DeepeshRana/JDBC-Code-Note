package in.java.deepesh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.java.utility.DBUtil;

public class ResultSetScrollInsensitive {

	public static void main(String[] args) {
		try (Connection connection = DBUtil.getDBConection()) {

			try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY)) {

				try (ResultSet resultSet = statement.executeQuery("select eid,ename,esal,eaddress from employees")) {

					System.out.println("Records in forward Direction....");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while (resultSet.next()) {
						System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4));
					}

					System.out.println();

					System.out.println("Records in backward direction....");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while (resultSet.previous()) {
						System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4));
					}

					System.out.println();
					System.out.println("Exploring the methods for Navigation...");
					resultSet.first();
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					System.out.println();
					resultSet.last();
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					System.out.println();

					// Working with absolute
					resultSet.first(); // top -> 1

					resultSet.absolute(5);

					// 5 gambir 29000 KKR
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					resultSet.absolute(-3);

					// 9 savan 35000 CSK
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					resultSet.absolute(3);// top -> 3

					System.out.println();

					resultSet.relative(5);
					// 8 shahid 26000 RCB
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					resultSet.relative(-5);
					// 3 kohli 32000 RCB
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

					System.out.println();
					resultSet.beforeFirst();
					System.out.println("Cursor pointing to First row :: " + resultSet.isFirst());
					System.out.println("Cursor pointing to Last  row :: " + resultSet.isLast());
					System.out.println("Cursor pointing to BeforeFirst  row :: " + resultSet.isBeforeFirst());
					resultSet.afterLast();
					System.out.println("Cursor pointing to After Last   row :: " + resultSet.isAfterLast());

				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
