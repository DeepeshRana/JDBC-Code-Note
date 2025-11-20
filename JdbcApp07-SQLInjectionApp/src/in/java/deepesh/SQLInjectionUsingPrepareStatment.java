package in.java.deepesh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import in.java.utility.DBUtil;

public class SQLInjectionUsingPrepareStatment {

	private static final String SOL_SELECT_QUERY = "select count(*) from student where sname = ? and sage = ? ";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try (Connection connection = DBUtil.getDBConection();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement(SOL_SELECT_QUERY)) {

				System.out.println("Enter Name :");

				String name = scanner.next();

				System.out.println("Age : ");

				int age = scanner.nextInt();

				preparedStatement.setString(1, name);

				preparedStatement.setInt(2, age);

				System.out.println(SOL_SELECT_QUERY);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

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
