package in.java.deepesh.factory;

import in.java.deepesh.controller.IStudentController;
import in.java.deepesh.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private StudentControllerFactory() {
	}

	private static IStudentController controller = null;

	public static IStudentController getStudentController() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}

		return controller;
	}
}
