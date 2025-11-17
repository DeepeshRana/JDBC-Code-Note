package in.java.deepesh.factory;

import in.java.deepesh.repository.IStudentRepo;
import in.java.deepesh.repository.StudentRepoImpl;

public class StudentRepoFactory {

	private static IStudentRepo studentRepo = null;

	private StudentRepoFactory() {

	}

	static {
		studentRepo = new StudentRepoImpl();
	}

	public static IStudentRepo getStudentRepo() {
		if (studentRepo == null) {
			studentRepo = new StudentRepoImpl();
		}

		return studentRepo;
	}

}