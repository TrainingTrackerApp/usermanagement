package in.capgemini.trainingtracker.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
//		user.setCreatedAt(new Date());
//		createdAt
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		user.setCreatedAt(strDate);
		user.setUpdatedAt(new Date());
		userDAO.save(user);
		System.out.println("User saved !!");
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
	@Override
	public void delete(int id) throws UserNotFoundException {
		userDAO.delete(id);
		
	}
	@Override
	public List<User> showAllUsers(){
		return userDAO.list();
	}
	
	
	

	
	

}
