package in.java.deepesh;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainApp {
	public static void main(String[] args) throws Exception {

		String userInput = "12-1-2024";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
		java.util.Date utilDate = simpleDateFormat.parse(userInput);

		long time = utilDate.getTime();
		java.sql.Date sqlDate = new Date(time);
		System.out.println("SQLDate information is ::" + sqlDate);

		// Convert java.sql.Date format directly

		String userInput2 = "2025-10-11";
		java.sql.Date sqlDate2 = java.sql.Date.valueOf(userInput2);
		System.out.println("SQLDate2 information is ::" + sqlDate2);
	}
}
