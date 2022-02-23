package in.capgemini.trainingtracker.service;

import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;

public interface UserService {

	void createUser(User user);
	void updateProfile(int id,String whatToBeUpdated,String updatedValue);
	User showProfile(int id) throws UserNotFoundException;
}
