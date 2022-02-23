package in.capgemini.trainingtracker.util;

import java.util.Scanner;

import in.capgemini.trainingtracker.exception.UserNotFoundException;
import in.capgemini.trainingtracker.modal.User;
import in.capgemini.trainingtracker.service.UserService;
import in.capgemini.trainingtracker.serviceimpl.UserServiceimpl;

public class UtilMenu {
	private UserService userService;
	public UtilMenu() {
		userService = new UserServiceimpl();
	}
	

	private void showMenu() {
		System.out.println("------ TRAINING TRACKER APP ------");
		System.out.println("1.  Register User");
		System.out.println("2.  show all users");
		System.out.println("3.  Update Profile");
		System.out.println("4.  Remove User");
		System.out.println("5.  Update password");
		System.out.println("0. Exit");
	}
	
	public void start() {
		String continueChoice;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			showMenu();
			System.out.println("Enter your Choice : (1,2,3,4,0) : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Register a new User");
				User user = new User();
				System.out.println("Enter User Name");
				user.setName(sc.nextLine());
				System.out.println("Enter Email-address");
				user.setEmail(sc.nextLine());
				System.out.println("Enter login id");
				user.setLoginid(sc.nextLine());
				System.out.println("Enter password");
				user.setPassword(sc.nextLine());
				System.out.println("Project Created Successfully");
				System.out.println();
				System.out.println(user);
				userService.createUser(user);
//				sc.nextLine();
				break;
				
			case 2:
				System.out.println("---View Your Profile---");
				System.out.println("Enter your id");
				int id = sc.nextInt();
				sc.nextLine();
				try {
					User userProfile = userService.showProfile(id);
					System.out.println("Hello ... " + userProfile.getName());
					System.out.println("ID: "+ userProfile.getId());
					System.out.println("EMAIL: " + userProfile.getEmail());
					System.out.println("PASSWORD: " + userProfile.getPassword());
					System.out.println("LOGINID: " + userProfile.getLoginid());
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				System.out.println("---Update Operation---");
				System.out.println("Enter the id of project you want to chnage the description");
				int idToUpdate = sc.nextInt();
				sc.nextLine();
				System.out.println("What you want to update in your profile");
				System.out.println("---email---");
				System.out.println("---password---");
				System.out.println("---loginid---");
				String input = sc.nextLine();
				System.out.println("You have choosen to update : " + input);
				System.out.println("Enter the updated value of : " + input);
				String updatedVallue = sc.nextLine();
				userService.updateProfile(idToUpdate, input, updatedVallue);
				System.out.println("Updated Successfully !!");
//				switch (input) {
//				case "email":
//					
//					break;
//				case "password":
//					
//					break;
//				case "loginid":
//					
//					break;
//				default:
//					break;
//				}
//				String description = sc.nextLine();
//				projectService.updateProject(idToUpdate, description);
//				System.out.println("Project Updated Successfully !!");
				break;
				
				/*
			case 4:
				System.out.println("---Delete Operation---");
				System.out.println("Enter id of project to delete");
				int id = sc.nextInt();
				try {
					projectService.removeProject(id);
					System.out.println("Project removed successfully !");
				} catch (ProductNotFoundException e) {
					System.out.println("Problem is " +  e.getMessage());
				}
				sc.nextLine();		
				break;
				*/
			case 0:
				System.out.println("******** Thanks for using the tool ********");
				System.exit(0);
				break;
				
			default :
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue");
			
			continueChoice = sc.nextLine();
			
		} while (continueChoice.equals("yes"));
		System.out.println("******** Thanks for using the tool ********");
		System.out.println("Have a good day !!!");
		
	
		
	}

	
}