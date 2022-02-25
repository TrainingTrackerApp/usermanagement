package in.capgemini.trainingtracker.service;

import java.util.List;

import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;

/**
 * this UserService will perform all the business logic on User 
 * @author hsraj
 *
 */
public interface UserService {

	/**
	 * this createUser will create the user in the system
	 * @param user to be added
	 */
	void createUser(User user);
	/**
	 * this update method will update the user detail in the database.
	 * @param id of the user to be updated
	 * @param whatToBeUpdated field to be updated
	 * @param updatedValue updated value of the field
	 */
	void updateProfile(int id,String whatToBeUpdated,String updatedValue);
	/**
	 *  this showProfile method will show all the user detail.
	 * @param id of the user who want to show the profile
	 * @return user
	 * @throws UserNotFoundException if user is not found with provided id
	 */
	User showProfile(int id) throws UserNotFoundException;
	/**
	 * this delete method will delete the user from database
	 * @param id of the user to delete
	 * @throws UserNotFoundException
	 */
	void delete(int id) throws UserNotFoundException;
	/**
	 * this showAllUsers will show all the user details
	 * @return list of all available users
	 */
	List<User> showAllUsers();
}
