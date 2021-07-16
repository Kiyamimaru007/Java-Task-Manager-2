package poisedProject;

import java.util.InputMismatchException;
//Import the Scanner package because I will be getting using input in this program.
import java.util.Scanner;

//This is the main menu class that the program begins at.
public class Menu {

	/*This program will work with multiple menus starting with this one.
	The user will be asked what they would like to do. They make their selection and the code will take them to that option
	By calling the methods.*/
	public static void main(String[] args) {
		
		//try-catch
		try {
			
			//Menu
			System.out.println("Select any of the following menu options by typing the corresponding number." +
					"\nMenu: " +
					"\nAdd project - 1 " +
					"\nEdit project - 2 " +
					"\nView projects - 3 " +
					"\nFinalise project - 4 " +
					"\nClose menu - 0");
			
			//User Selection
			Scanner userSel = new Scanner(System.in);
			System.out.print("\nSelection: ");
			int selection = userSel.nextInt();
			
			
			//Options
			
			//Add Project
			if (selection == 1) {
				AddProject.addProject();
			}
			
			//Edit Project
			else if(selection == 2) {
				EditProject.editProject();
			}
			
			//View Project
			else if(selection == 3) {
				ViewProject.viewProject();
			}
			
			//Finalize Project
			else if(selection == 4) {
				FinaliseProject.finaliseProject();
			}
			
			//End Program
			else if(selection == 0) {
				
				System.out.println("Program has ended!");
				System.out.println("Goodbye :) ");
			}

			//If the user has not entered any of the above choices then it is not valid and this message will be displayed and they will be
			//take back to the menu.
			else {
				
				System.out.println("You have made an invalid entry please try again.");
				Menu.main(args);
			}
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("You have given an invalid input. Please make sure to enter the NUMBER of the corresponding menu option");
			Menu.main(args);
		}
		
	}
	
}
