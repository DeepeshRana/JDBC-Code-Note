package in.java.deepesh.factory;

import in.java.deepesh.service.IStudentService;
import in.java.deepesh.service.StudentServiceImpl;

public class StudentServiceFactory {

	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getIStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
