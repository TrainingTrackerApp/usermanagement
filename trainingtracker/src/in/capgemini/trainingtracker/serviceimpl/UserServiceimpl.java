package in.capgemini.trainingtracker.serviceimpl;

import java.util.Date;

import in.capgemini.trainingtracker.dao.UserDAO;
import in.capgemini.trainingtracker.daoimpl.UserDAOJDBCImpl;
import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;
import in.capgemini.trainingtracker.service.UserService;

//import in.capgemini.trainingtracker.service.UserService;

public class UserServiceimpl implements UserService {
	private UserDAO userDAO;
	public UserServiceimpl() {
		userDAO = new UserDAOJDBCImpl();
	}
	@Override
	public void createUser(User user) {
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		userDAO.save(user);
	}
	@Override
	public void updateProfile(int id, String whatToBeUpdated, String updatedValue) {
		userDAO.update(id, whatToBeUpdated, updatedValue);
		
	}
	@Override
	public User showProfile(int id) throws UserNotFoundException{
		User user =  userDAO.show(id);
		return user;
	}
	
	

	
	

}
