package poisedProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

//This class will be used to view projects from the database
public class ViewProject {
	
	public static void viewProject() {
		
		try {
			
			System.out.println("\nPlease enter the number corresponding to your choice.\nMenu:" +
								"\nView Project Using Project Number - 1" +
								"\nView Project Using Project Name - 2" +
								"\nView All Projects - 3" +
								"\nView All Completed Projects - 4" +
								"\nBack To Menu - 5" +
								"\nEnd Program - 0");
			
			Scanner userChoice = new Scanner(System.in);
			System.out.println("\nSelection:");
			int choice = userChoice.nextInt();
			
			//Project Number
			if(choice == 1) {
				
				String projManName = "";
				
				Scanner userInput = new Scanner(System.in);
				System.out.println("\nPlease Enter The Project Number");
				String projNum = userInput.nextLine();
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					
					String tableString = "SELECT * FROM projects WHERE Project_Number = " + projNum + ";";
					
					ResultSet results = statement.executeQuery(tableString);
					
					while(results.next()){
						
						System.out.println("\nProject Info:\nProject Number: " + results.getInt("Project_Number") + "\nProject Name: " +
								results.getString("Project_Name") + "\nProject Type: " + results.getString("Project_Type") + "\nProject Address: " +
								results.getString("Project_Address") + "\nProject Erf Number: " + results.getInt("Project_Erf_Number") +
								"\nTotal Fee: " + results.getInt("Total_Fee") + "\nTotal Paid: " + results.getInt("Total_Paid") +
								"\nProject Deadline: " + results.getString("Project_Deadline")
								);
						projManName = results.getString("Project_Manager");
					}
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					
					//Format
					String tableString = "SELECT * FROM people WHERE Project_Manager_Name = '" + projManName + "';";
					
					//Get the correct row from the database
			        ResultSet results = statement.executeQuery(tableString);
			        
			        while (results.next()) {
			        	
			        	System.out.println("\nProject Manager Name: " + results.getString("Project_Manager_Name") + "\nProject Manager Telephone Number: "
			        			+ results.getString("Project_Manager_Telephone_Number") + "\nProject Manager Email: " +
			        			results.getString("Project_Manager_Email") + "\nProject Manager Address: " + results.getString("Project_Manager_Address")
			        			+ "\nArchitect Name: " + results.getString("Architect_Name") + "\nArchitect Telephone Number: " +
			        			results.getString("Architect_Telephone_Number") + "\nArchitect Email" + results.getString("Architect_Email") +
			        			"\nArchitect Address: " + results.getString("Architect_Address") + "\nContractor Name: " + 
			        			results.getString("Contractor_Name") + "\nContractor Telephone Number: " + results.getString("Contractor_Telephone_Number")
			        			+ "\nContractor Email: " + results.getString("Contractor_Email") + "\nContractor Address: " +
			        			results.getString("Contractor_Address") + "\nCustomer Name: " + results.getString("Customer_Name") +
			        			"\nCustomer Telephone Number: " + results.getString("Customer_Telephone_Number") + "\nCustomer Email: " +
			        			results.getString("Customer_Email") + "\nCustomer Address: " + results.getString("Customer_Address") +
			        			"\nStructural Engineer Name: " + results.getString("Structural_Engineer_Name") + 
			        			"\nStructural Engineer Telephone Number: " + results.getString("Structural_Engineer_Telephone_Number") +
			        			"\nStructural Engineer Email: " + results.getString("Structural_Engineer_Email") + 
			        			"\nStructural Engineer Address: " + results.getString("Structural_Engineer_Address")
			        			);
			        }
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
				ViewProject.viewProject();
				
			}
			
			//Project Name
			else if(choice == 2) {
				
				String projManName = "";
				
				Scanner userInput = new Scanner(System.in);
				System.out.println("\nPlease Enter The Project Name: ");
				String projName = userInput.nextLine();
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					
					String tableString = "SELECT * FROM projects WHERE Project_Name = '" + projName + "';";
					
					ResultSet results = statement.executeQuery(tableString);
					
					while(results.next()){
						
						System.out.println("\nProject Info:\nProject Number: " + results.getInt("Project_Number") + "\nProject Name: " +
								results.getString("Project_Name") + "\nProject Type: " + results.getString("Project_Type") + "\nProject Address: " +
								results.getString("Project_Address") + "\nProject Erf Number: " + results.getInt("Project_Erf_Number") +
								"\nTotal Fee: " + results.getInt("Total_Fee") + "\nTotal Paid: " + results.getInt("Total_Paid") +
								"\nProject Deadline: " + results.getString("Project_Deadline")
								);
						projManName = results.getString("Project_Manager");
					}
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					
					//Format
					String tableString = "SELECT * FROM people WHERE Project_Manager_Name = '" + projManName + "';";
					
					//Get the correct row from the database
			        ResultSet results = statement.executeQuery(tableString);
			        
			        while (results.next()) {
			        	
			        	System.out.println("\nProject Manager Name: " + results.getString("Project_Manager_Name") + "\nProject Manager Telephone Number: "
			        			+ results.getString("Project_Manager_Telephone_Number") + "\nProject Manager Email: " +
			        			results.getString("Project_Manager_Email") + "\nProject Manager Address: " + results.getString("Project_Manager_Address")
			        			+ "\nArchitect Name: " + results.getString("Architect_Name") + "\nArchitect Telephone Number: " +
			        			results.getString("Architect_Telephone_Number") + "\nArchitect Email" + results.getString("Architect_Email") +
			        			"\nArchitect Address: " + results.getString("Architect_Address") + "\nContractor Name: " + 
			        			results.getString("Contractor_Name") + "\nContractor Telephone Number: " + results.getString("Contractor_Telephone_Number")
			        			+ "\nContractor Email: " + results.getString("Contractor_Email") + "\nContractor Address: " +
			        			results.getString("Contractor_Address") + "\nCustomer Name: " + results.getString("Customer_Name") +
			        			"\nCustomer Telephone Number: " + results.getString("Customer_Telephone_Number") + "\nCustomer Email: " +
			        			results.getString("Customer_Email") + "\nCustomer Address: " + results.getString("Customer_Address") +
			        			"\nStructural Engineer Name: " + results.getString("Structural_Engineer_Name") + 
			        			"\nStructural Engineer Telephone Number: " + results.getString("Structural_Engineer_Telephone_Number") +
			        			"\nStructural Engineer Email: " + results.getString("Structural_Engineer_Email") + 
			        			"\nStructural Engineer Address: " + results.getString("Structural_Engineer_Address")
			        			);
			        }
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
				ViewProject.viewProject();
				
			}
			
			//All Projects
			else if(choice == 3) {
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
			        
					//Get the correct row from the database
			        ResultSet results = statement.executeQuery("SELECT * FROM projects;");
			      
			        while (results.next()) {
			        	
						System.out.println("\nProject Info:\nProject Number: " + results.getInt("Project_Number") + "\nProject Name: " +
								results.getString("Project_Name") + "\nProject Type: " + results.getString("Project_Type") + "\nProject Address: " +
								results.getString("Project_Address") + "\nProject Erf Number: " + results.getInt("Project_Erf_Number") +
								"\nTotal Fee: " + results.getInt("Total_Fee") + "\nTotal Paid: " + results.getInt("Total_Paid") +
								"\nProject Deadline: " + results.getString("Project_Deadline") + "\nArchitect Name: " +
								results.getString("Architect_Name") + "\nContractor Name: " + results.getString("Contractor_Name") +
								"\nCustomer Name: " + results.getString("Customer_Name") + "\nStructural Engineer Name: " +
								results.getString("Structural_Engineer_Name") + "\nProject Manager: " + results.getString("Project_Manager")
								);
						
			        }
			       
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					
			        ResultSet results2 = statement.executeQuery("SELECT * FROM people;");
			        
			        while(results2.next()) {
			        	
			        	System.out.println("\nPeople Info:\nProject Manager Name: " + results2.getString("Project_Manager_Name") + "\nProject Manager Telephone Number: "
			        			+ results2.getString("Project_Manager_Telephone_Number") + "\nProject Manager Email: " +
			        			results2.getString("Project_Manager_Email") + "\nProject Manager Address: " + results2.getString("Project_Manager_Address")
			        			+ "\nArchitect Name: " + results2.getString("Architect_Name") + "\nArchitect Telephone Number: " +
			        			results2.getString("Architect_Telephone_Number") + "\nArchitect Email" + results2.getString("Architect_Email") +
			        			"\nArchitect Address: " + results2.getString("Architect_Address") + "\nContractor Name: " + 
			        			results2.getString("Contractor_Name") + "\nContractor Telephone Number: " + results2.getString("Contractor_Telephone_Number")
			        			+ "\nContractor Email: " + results2.getString("Contractor_Email") + "\nContractor Address: " +
			        			results2.getString("Contractor_Address") + "\nCustomer Name: " + results2.getString("Customer_Name") +
			        			"\nCustomer Telephone Number: " + results2.getString("Customer_Telephone_Number") + "\nCustomer Email: " +
			        			results2.getString("Customer_Email") + "\nCustomer Address: " + results2.getString("Customer_Address") +
			        			"\nStructural Engineer Name: " + results2.getString("Structural_Engineer_Name") + 
			        			"\nStructural Engineer Telephone Number: " + results2.getString("Structural_Engineer_Telephone_Number") +
			        			"\nStructural Engineer Email: " + results2.getString("Structural_Engineer_Email") + 
			        			"\nStructural Engineer Address: " + results2.getString("Structural_Engineer_Address")
			        			);
			        }
				}   
			        
				catch (SQLException e) {
						e.printStackTrace();
						Menu.main(null);
				}
				
				ViewProject.viewProject();
				
			}
			
			//All Completed Projects
			else if(choice == 4) {
				
				try {
					
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/poisepms_db",
							"root",
							"Lenovo@14"
							);
					
					Statement statement = connection.createStatement();
					ResultSet results = statement.executeQuery("SELECT * FROM completedprojects");
					
					System.out.println("\nCompleted Projects:");
					
					while (results.next()) {
						
						System.out.println("\nProject Number: " + results.getInt("Project_Number") +
											"\nProject Name: " + results.getString("Project_Name") +
											"\nProject Type: " + results.getString("Project_Type") +
											"\nProject Address: " + results.getString("Project_Address") +
											"\nProject ERF Number: " + results.getInt("Project_Erf_Number") +
											"\nTotal Fee: " + results.getInt("Total_Fee") +
											"\nTotal Paid: " + results.getInt("Total_Paid") +
											"\nProject Deadline: " + results.getString("Project_Deadline") +
											"\nArchitect Name: " + results.getString("Architect_Name") +
											"\nContractor Name: " + results.getString("Contractor_Name") +
											"\nStructural Engineer Name: " + results.getString("Structural_Engineer_Name") +
											"\nProject Manager Name: " + results.getString("Project_Manager") +
											"\nStatus: " + results.getString("Status") +
											"\nDate Finalised: " + results.getString("Date_Finalised")
											);
					}
					
				}
				
				catch (SQLException e) {
					e.printStackTrace();
					Menu.main(null);
				}
				
			}
			
			//Back To Menu
			else if(choice == 5) {
				Menu.main(null);
			}
			
			//End Program
			else if(choice == 0) {
				System.out.println("\nProgram Ended.");
			}
			
			else {
				System.out.println("Invalid Input Please Try Again");
				Menu.main(null);
			}
			
		}
		
		catch (InputMismatchException e) {
			System.out.println("\nInvalid Input Please Try Again.");
			ViewProject.viewProject();
		}
		
	}
	
}
