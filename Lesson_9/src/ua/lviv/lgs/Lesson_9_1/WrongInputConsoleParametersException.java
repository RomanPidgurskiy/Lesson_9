package ua.lviv.lgs.Lesson_9_1;

public class WrongInputConsoleParametersException extends Exception {
	private String message;
	
	public WrongInputConsoleParametersException(String message) {
		super(message);
		this.message = message;
	}
}
