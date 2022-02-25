package in.capgemini.trainingtracker.util;

import java.util.List;
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
		System.out.println("1. Register a new User");
		System.out.println("2. View your profile");
		System.out.println("3. Update Profile");
		System.out.println("4. Change password");
		System.out.println("5. Delete Profile");
		System.out.println("6. Show All Registered User");
		System.out.println("0. Exit");
	}
	
	public void start() {
		String continueChoice;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			showMenu();
			System.out.println("Enter your Choice : (1,2,3,4,5,0) : ");
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
				System.out.println("User Added Successfully");
//				System.out.println();
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
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 3:
				System.out.println("---Update Your Profile---");
				System.out.println("What you want to update in your profile");
				System.out.println("---name---");
				System.out.println("---email---");
				System.out.println("---loginid---");
				String input = sc.nextLine();
				System.out.println(" Enter your ID ");
				int idToUpdate = sc.nextInt();
				sc.nextLine();
//				System.out.println("You have choosen to update : " + input);
				System.out.println("Enter the new : " + input);
				String updatedVallue = sc.nextLine();
				userService.updateProfile(idToUpdate, input, updatedVallue);
				System.out.println("Your "+input + " has been updated successfully !!");
				break;
				
				
			case 4:
				System.out.println("---Change your Password---");
				System.out.println(" Enter your ID ");
				int idToChangePassword = sc.nextInt();
				sc.nextLine();
				try {
					userService.showProfile(idToChangePassword);
					System.out.println("Enter the new password...");
					String newPassword = sc.nextLine();
					userService.updateProfile(idToChangePassword, "password", newPassword);
//					sc.nextLine();
					System.out.println("Your password is changed successfully!!");
				} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
//				sc.nextLine();		
				break;
				
			case 5:
				System.out.println("Delete your prpfile");
				System.out.println("Enter your ID ");
				int idTodelete = sc.nextInt();
				
				try {
					userService.delete(idTodelete);
					System.out.println("You have choosen to delete user with id : " + idTodelete);
				} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Successfully deleted");
				sc.nextLine();
				
				break;
			case 6:
				System.out.println("Here are all profiles...");
				List<User> allProfiles = userService.showAllUsers();
				if(allProfiles.size() > 0) {
					for(User profile : allProfiles) {
						System.out.println("User name: "+profile.getName()+" | "+"User id: "+profile.getId());
					}
				}
				else {
					System.out.println("No User registered");
				}
				
				break;
			case 0:
				System.out.println("******** Thanks for using the App ********");
				System.exit(0);
				break;
				
			default :
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue");
			
			continueChoice = sc.nextLine();
			
		} while (continueChoice.equals("yes"));
		System.out.println("******** Thanks for using Trainig Traker App ********");
		System.out.println("Have a good day !!!");
		
	
		
	}

	
}