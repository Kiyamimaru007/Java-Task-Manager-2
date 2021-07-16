package poisedProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

//This class will collect the full information of the project and add it to the database.
public class AddProject {

	public static void addProject() {
		
		try {
			
			//Messages to explain to the user exactly what's happening and what,s expected of them.
			System.out.println("\nYou have selected to Add a Project!");
			System.out.println("\nPlease correctly input the following information and once complete it will be added to the Projects text file.");
			
			//Scanner object
			Scanner proInput = new Scanner(System.in);
			
			//Getting the project information from user
			System.out.println("\nPlease input the project number:");
			String projectNum = proInput.nextLine();
			System.out.println("\nPlease input the project name:");
			String projectName = proInput.nextLine();
			System.out.println("\nPlease input the building type:");
			String type = proInput.nextLine();
			System.out.println("\nPlease input the ERF number:");
			String erfNum = proInput.nextLine();
			System.out.println("\nPlease input the Address of the project:");
			String projectAddress = proInput.nextLine();
			System.out.println("\nPlease input the total fee due:");
			String totalFee = proInput.nextLine();
			System.out.println("\nPlease input the total paid by client:");
			String totalPaid = proInput.nextLine();
			System.out.println("\nPlease input the project deadline in dd/mm/yyyy format:");
			String projectDeadline = proInput.nextLine();
			
			//Getting Architects details
			System.out.println("\nPlease input the Architects Name:");
			String architectName = proInput.nextLine();
			System.out.println("\nPlease input the Architects Telephone number:");
			String architectTelNum = proInput.nextLine();
			System.out.println("\nPlease input the Architects Email:");
			String architectEmail = proInput.nextLine();
			System.out.println("\nPlease input the Architects Address:");
			String architectAddress = proInput.nextLine();
			
			//Getting Contractors details
			System.out.println("\nPlease input the Contractors Name:");
			String contractorName = proInput.nextLine();
			System.out.println("\nPlease input the Contractors Telephone number:");
			String contractorTelNum = proInput.nextLine();
			System.out.println("\nPlease input the Contractors Email:");
			String contractorEmail = proInput.nextLine();
			System.out.println("\nPlease input the Contractors Address:");
			String contractorAddress = proInput.nextLine();
			
			//Getting Customers details
			System.out.println("\nPlease input the Customers Name:");
			String customerName = proInput.nextLine();
			System.out.println("\nPlease input the Customers Telephone number:");
			String customerTelNum = proInput.nextLine();
			System.out.println("\nPlease input the Customers Email:");
			String customerEmail = proInput.nextLine();
			System.out.println("\nPlease input the Customers Address:");
			String customerAddress = proInput.nextLine();
			
			//Getting Structural Engineers details
			System.out.println("\nPlease input the Structural Engineers Name:");
			String engineName = proInput.nextLine();
			System.out.println("\nPlease input the Structural Engineers Telephone Number: ");
			String engineTelNum = proInput.nextLine();
			System.out.println("\nPlease input the Structural Engineers Email:");
			String engineEmail = proInput.nextLine();
			System.out.println("\nPlease input the Structural Engineers Address:");
			String engineAddress = proInput.nextLine();
			
			//Getting Project Managers details
			System.out.println("\nPlease input the Project Managers Name:");
			String projManName = proInput.nextLine();
			System.out.println("\nPlease input the Project Managers Telephone Number:");
			String projManTelNum = proInput.nextLine();
			System.out.println("\nPlease input the Project Managers Email:");
			String projManEmail = proInput.nextLine();
			System.out.println("\nPlease input the Project Managers Address:");
			String projManAddress = proInput.nextLine();
			
			proInput.close();
			
			//If the user has not input a project name the program must take the surname of the customer and the building type to make a name
			if (projectName.length() == 0 ){
				String[] tempName = customerName.split(" ");
				projectName = type + " " + tempName[1];
			}
			
			else {
			}
			
			//Project Info Objects
			ProjectInfo details = new ProjectInfo(projectNum, projectName, type, projectAddress, erfNum, 
									totalFee, totalPaid, projectDeadline, architectName, contractorName, customerName, engineName, projManName);
			
			//Person Objects
			Person people = new Person(architectName, architectTelNum, architectEmail, architectAddress, contractorName, 
							contractorTelNum, contractorEmail, contractorAddress, customerName, 
							customerTelNum, customerEmail, customerAddress, projManName, projManTelNum, projManEmail, projManAddress, engineName,
							engineTelNum, engineEmail, engineAddress);
					
			//Add to database
			try {
				
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/poisepms_db",
						"root",
						"Lenovo@14"
						);
				
				Statement statement = connection.createStatement();
				ResultSet results = statement.executeQuery("select * from projects");
				int rowsAffected;
				
				String tableString = details.toString();
				
				//Add to database
				rowsAffected = statement.executeUpdate(tableString);
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
				ResultSet results = statement.executeQuery("select * from people");
				int rowsAffected;
				
				String tableString = people.toString();
				
				//Add to database
				rowsAffected = statement.executeUpdate(tableString);
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				Menu.main(null);
			}
			
			System.out.println("\nProject Added To Database.");
			Menu.main(null);
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("You have given an invalid input.");
			AddProject.addProject();
		}
		
	}
	
}
