package in.capgemini.trainingtracker.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will create the UserNotFoundException without error message
	 */
	public UserNotFoundException() {
		super();
	}
	/**
	 * This will create the UserNotFoundException with error message
	 * @param error
	 */
	public UserNotFoundException(String error) {
		super(error);
	}
	
}
