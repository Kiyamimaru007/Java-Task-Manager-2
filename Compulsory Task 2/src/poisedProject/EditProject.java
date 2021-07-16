package poisedProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//This class will handle the editing of existing projects and updating of the database
public class EditProject {
	
	public static void editProject() {

		try {
			
			Scanner userInput = new Scanner(System.in);
			System.out.println("\nPlease enter the corresponding number of your choice.\nMenu:" +
								"\nProject Number - 1" +
								"\nProject Name - 2");
			String option = userInput.nextLine();
			System.out.println("\nPlease Enter the Project Number or Name of the project you will be editing: ");
			String searchItem = userInput.nextLine();
			System.out.println("\nPlease Enter the corresponding number of your choice in the menu.\nMenu:" +
								"\nProject Information (Project Number) - 1" +
								"\nPeople Information (Customer Telephone Number) - 2");
			String choice = userInput.nextLine();
			
			//Project Number
			if (option == "1") {
				
				if (choice == "1") {
					
					System.out.println("\nPlease enter one of the following items exactly to select that item for editing:" +
										"\nProject_Number\nProject_Name\nProject_Type\nProject_Address\nProject_Erf_Number" +
										"\nTotal_Fee\nTotal_Paid\nProject_Deadline");
					String item = userInput.nextLine();
					System.out.println("\nPlease Enter The New Data: ");
					String newData = userInput.nextLine();
					
					if (item == "Project_Number" && item == "Project_Erf_Number" && item == "Total_Fee" && item == "Total_Paid") {
						
						//Edit database
						try {
							
							Connection connection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/poisepms_db",
									"root",
									"Lenovo@14"
									);
							
							Statement statement = connection.createStatement();
							ResultSet results = statement.executeQuery("select * from projects");
							int rowsAffected;
							
							String tableString = "UPDATE projects SET " + item + " = " + newData + " WHERE Project_Number = " + searchItem + ";";
							
							//Add to database
							rowsAffected = statement.executeUpdate(tableString);
						}
						
						catch (SQLException e) {
							e.printStackTrace();
							Menu.main(null);
						}
					}
					
					else {
						
						try {
							
							Connection connection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/poisepms_db",
									"root",
									"Lenovo@14"
									);
							
							Statement statement = connection.createStatement();
							ResultSet results = statement.executeQuery("select * from projects");
							int rowsAffected;
							
							String tableString = "UPDATE projects SET " + item + " = '" + newData + "' WHERE Project_Number = " + searchItem + ";";
							
							//Add to database
							rowsAffected = statement.executeUpdate(tableString);
						}
						
						catch (SQLException e) {
							e.printStackTrace();
							Menu.main(null);
						}
						
					}
					
					System.out.println("\nThe Table Has Been Updated.");
					EditProject.editProject();
					
				}
				
				else if (choice == "2") {
					
					System.out.println("\nPlease enter one of the following items exactly to select that item for editing:" +
							"\nProject_Manager_Number\nProject_Manager_Telephone_Number\nProject_Manager_Email\nProject_Manager_Address" +
							"\nArchitect_Name\nArchitect_Telephone_Number\nArchitect_Email\nArchitect_Address" +
							"\nContractor_Name\nContractor_Telephone_Number\nContractor_Email\nContractor_Address" +
							"\nCustomer_Name\nCustomer_Telephone_Number\nCustomer_Email\nCustomer_Address" +
							"\nStructural_Engineer_Name\nStructural_Engineer_Telephone_Number\nStructural_Engineer_Email\nStructural_Engineer_Address");
					String item = userInput.nextLine();
					System.out.println("\nPlease Enter The New Data: ");
					String newData = userInput.nextLine();
					
					try {
						
						Connection connection = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/poisepms_db",
								"root",
								"Lenovo@14"
								);
		
						Statement statement = connection.createStatement();
						ResultSet results = statement.executeQuery("select * from people");
						int rowsAffected;
		
						String tableString = "UPDATE people SET " + item + " = '" + newData + "' WHERE Project_Number = " + searchItem + ";";
		
						//Add to database
						rowsAffected = statement.executeUpdate(tableString);
					}
	
					catch (SQLException e) {
						e.printStackTrace();
						Menu.main(null);
					}
		
					System.out.println("\nThe Table Has Been Updated.");
					EditProject.editProject();
				}
				
				else {
					System.out.println("\nInvalid Input Please Try Again.");
					EditProject.editProject();
				}
				
			}
			
			//Project Name
			else if (option == "2") {
				
				if (choice == "1") {
					
					System.out.println("\nPlease enter one of the following items exactly to select that item for editing:" +
										"\nProject_Number\nProject_Name\nProject_Type\nProject_Address\nProject_Erf_Number" +
										"\nTotal_Fee\nTotal_Paid\nProject_Deadline");
					String item = userInput.nextLine();
					System.out.println("\nPlease Enter The New Data: ");
					String newData = userInput.nextLine();
					
					if (item == "Project_Number" && item == "Project_Erf_Number" && item == "Total_Fee" && item == "Total_Paid") {
						
						try {
							
							Connection connection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/poisepms_db",
									"root",
									"Lenovo@14"
									);
							
							Statement statement = connection.createStatement();
							ResultSet results = statement.executeQuery("select * from projects");
							int rowsAffected;
							
							String tableString = "UPDATE projects SET " + item + " = " + newData + " WHERE Project_Number = '" + searchItem + "';";
							
							//Add to database
							rowsAffected = statement.executeUpdate(tableString);
						}
						
						catch (SQLException e) {
							e.printStackTrace();
							Menu.main(null);
						}
					}
					
					else {
						
						try {
							
							Connection connection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/poisepms_db",
									"root",
									"Lenovo@14"
									);
							
							Statement statement = connection.createStatement();
							ResultSet results = statement.executeQuery("select * from projects");
							int rowsAffected;
							
							String tableString = "UPDATE projects SET " + item + " = '" + newData + "' WHERE Project_Number = " + searchItem + ";";
							
							//Add to database
							rowsAffected = statement.executeUpdate(tableString);
						}
						
						catch (SQLException e) {
							e.printStackTrace();
							Menu.main(null);
						}
						
					}
					
					System.out.println("\nThe Table Has Been Updated.");
					EditProject.editProject();
					
				}
				
				else if (choice == "2") {
					
					System.out.println("\nPlease enter one of the following items exactly to select that item for editing:" +
							"\nProject_Manager_Number\nProject_Manager_Telephone_Number\nProject_Manager_Email\nProject_Manager_Address" +
							"\nArchitect_Name\nArchitect_Telephone_Number\nArchitect_Email\nArchitect_Address" +
							"\nContractor_Name\nContractor_Telephone_Number\nContractor_Email\nContractor_Address" +
							"\nCustomer_Name\nCustomer_Telephone_Number\nCustomer_Email\nCustomer_Address" +
							"\nStructural_Engineer_Name\nStructural_Engineer_Telephone_Number\nStructural_Engineer_Email\nStructural_Engineer_Address");
					String item = userInput.nextLine();
					System.out.println("\nPlease Enter The New Data: ");
					String newData = userInput.nextLine();
					
					try {
						
						Connection connection = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/poisepms_db",
								"root",
								"Lenovo@14"
								);
		
						Statement statement = connection.createStatement();
						ResultSet results = statement.executeQuery("select * from people");
						int rowsAffected;
		
						String tableString = "UPDATE people SET " + item + " = '" + newData + "' WHERE Project_Name = '" + searchItem + "';";
		
						//Add to database
						rowsAffected = statement.executeUpdate(tableString);
					}
	
					catch (SQLException e) {
						e.printStackTrace();
						Menu.main(null);
					}
		
					System.out.println("\nThe Table Has Been Updated.");
					EditProject.editProject();
				}
				
				else {
					System.out.println("\nInvalid Input Please Try Again.");
					EditProject.editProject();
				}
				
			}
			
			else {
				System.out.println("\nInvalid Input Please Try Again.");
				EditProject.editProject();
			}
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("You have given an invalid input.");
			EditProject.editProject();
		}
		
	}	

}
