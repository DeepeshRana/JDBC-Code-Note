package in.java.deepesh;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

import in.java.utility.DBUtil;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_STUDENT_DETAILS_BY_ID`(IN id INT, 
		OUT sname varchar(20),
		OUT sage int)
BEGIN
SELECT student.sname, student.sage
INTO sname, sage 
FROM student
WHERE sid = id;

SELECT sname, sage;
END*/

public class StoredProcedureApp {

	private static final String CALL_SOL_SELECT_QUERY = "{call GET_STUDENT_DETAILS_BY_ID (?,?,?)} ";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try (Connection connection = DBUtil.getDBConection();) {

			try (CallableStatement callableStatement = connection.prepareCall(CALL_SOL_SELECT_QUERY)) {

				System.out.println("Enter Id :");

				Integer id = scanner.nextInt();

				// Setting in parameter
				callableStatement.setInt(1, id);

				// Register out parameter
				callableStatement.registerOutParameter(2, Types.VARCHAR);
				callableStatement.registerOutParameter(2, Types.INTEGER);

				System.out.println(CALL_SOL_SELECT_QUERY);

				callableStatement.execute();

				// Getting the result from out params
				String name = callableStatement.getString(2);
				int age = callableStatement.getInt(3);

				System.out.println("Student name is " + name + " -- " + " and age is " + age);

			} catch (Exception e) {

			}

		} catch (Exception e) {

		}

	}

}
