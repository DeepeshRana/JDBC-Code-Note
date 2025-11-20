package in.java.deepesh;

import java.io.FileWriter;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetApp {

	public static void main(String[] args) {

		WebRowSet webRowSet = null;

		try {

			RowSetFactory factory = RowSetProvider.newFactory();

			// DisConnected based webSet
			webRowSet = factory.createWebRowSet();
			webRowSet.setUrl("");
			webRowSet.setUsername("");
			webRowSet.setPassword("");

			webRowSet.setCommand("");
			webRowSet.execute();

			FileWriter fileWriter = new FileWriter("student.xml");
			webRowSet.writeXml(fileWriter);

			System.out.println("Student data transfer to student.xml file");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (webRowSet != null) {
				try {
					webRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
