package in.java.deepesh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class SQLInjectionUsingStatment {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try (Connection connection = DBUtil.getDBConection();) {

			try (Statement statement = connection.createStatement()) {

				System.out.println("Enter Name :");

				String name = scanner.next();

				System.out.println("Enter Age : ");

				int age = scanner.nextInt();

				final String SOL_SELECT_QUERY = "select count(*) from student where sname = '" + name + "' and sage="
						+ age + "";

				System.out.println(SOL_SELECT_QUERY);

				try (ResultSet resultSet = statement.executeQuery(SOL_SELECT_QUERY)) {

					int count = 0;

					if (resultSet.next()) {
						count = resultSet.getInt(1);
					}
					if (count == 1) {
						System.out.println("Valid Credentials !");
					} else {
						System.out.println("Envalid Credential !");
					}

				}

			} catch (Exception e) {

			}

		} catch (Exception e) {

		}

	}

}
