package in.capgemini.trainingtracker.dao;

import java.util.List;

import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;

/**
 * This UserDAO interface will work on the CRUD for user
 * @author hsraj
 *
 */
public interface UserDAO {

	/**
	 * this save method will save the data in the database
	 * @param user
	 */
	public void save(User user);
	/**
	 * this update method will update the user detail in the database.
	 * @param id of the user
	 * @param toBeUpdated field
	 * @param updatedValue of the field
	 */
	public void update(int id, String toBeUpdated,String updatedValue);
	/**
	 * this show method will show the user details
	 * @param id of the user to show details
	 * @return user details
	 * @throws UserNotFoundException
	 */
	public User show(int id) throws UserNotFoundException;
	/**
	 * this list method will show all the users detail
	 * @return list of users
	 */
	List<User> list();
	
	/**
	 * this delete method will delete the user detail from the database
	 * @param id of the user to delete
	 * @throws UserNotFoundException
	 */
	void delete(int id) throws UserNotFoundException;
}
