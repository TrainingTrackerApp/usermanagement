package in.capgemini.trainingtracker.dao;

import java.util.List;

import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;

public interface UserDAO {

	public void save(User user);
	public void update(int id, String toBeUpdated,String updatedValue);
	public User show(int id) throws UserNotFoundException;
	List<User> list();
	void delete(int id) throws UserNotFoundException;
}
