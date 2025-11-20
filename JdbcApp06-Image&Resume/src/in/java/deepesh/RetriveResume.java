package in.java.deepesh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import in.java.utility.DBUtil;

public class RetriveResume {

	private static final String SQL_INSERT_QUERY = "select id , name , resume from jobpdf where id = ?";

	public static void main(String[] args) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resulteSet = null;

		int rowCount = 0;

		try {
			connection = DBUtil.getDBConection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			}

			Scanner scanner = new Scanner(System.in);

			if (preparedStatement != null && scanner != null) {
				System.out.println("Enter the Student Id");

				int sId = scanner.nextInt();

				preparedStatement.setInt(1, sId);

				resulteSet = preparedStatement.executeQuery();
			}

			if (resulteSet.next()) {

				System.out.println("ID\t Name \t pdf");

				String resumeLocation = "dowload_resume.txt";

				System.out.println(resulteSet.getInt(1) + "\t" + resulteSet.getString(2) + "\t" + resumeLocation);

				IOUtils.copy(resulteSet.getCharacterStream(3), new FileWriter(new File(resumeLocation)));

				// System.out.println(displayImageInfo(resulteSet.getBinaryStream(3)));

			} else {
				System.out.println("Record Not Found !");
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, preparedStatement, connection);
		}

	}

//	private static String displayImageInfo(InputStream binaryStream) throws IOException {
//
//		String location = "download.jpg";
//
//		FileOutputStream fileOutputStream = new FileOutputStream(location);
//
//		int date = binaryStream.read();
//
//		while (date != -1) {
//			fileOutputStream.write(date);
//
//			binaryStream.read();
//		}
//
//		return "Successfully Download in the location " + location;
//
//	}

}
