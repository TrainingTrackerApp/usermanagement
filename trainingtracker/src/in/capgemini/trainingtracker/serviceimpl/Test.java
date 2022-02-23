package in.capgemini.trainingtracker.serviceimpl;

import in.capgemini.trainingtracker.modal.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserServiceimpl im = new UserServiceimpl();
		User user = new User();
		user.setName("Shiva");
		user.setPassword("passd");
		user.setEmail("shivam@gmail.com");
		im.createUser(user);
	}

}
