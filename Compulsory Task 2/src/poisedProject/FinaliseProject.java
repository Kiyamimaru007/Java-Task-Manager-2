package poisedProject;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinaliseProject {

	//This will be used to finalize projects and print out an invoice, if necessary, from the database
	public static void finaliseProject() {
		
		try {
			
			//Ask the user to choose which search item they which to search with.
			//Menu
			System.out.println("\nYou have chosen to finalise a project.");
			System.out.println("\nPlease select corresponding number of which item you will be searching with: \n" +
					"Project Number - 1\n" +
					"Project Name - 2\n" +
					"Back to menu - 3\n" +
					"End program - 0\n");
			
			//Get the users selection
			Scanner userChoice = new Scanner(System.in);
			System.out.println("\nSelection: ");
			int choice = userChoice.nextInt();
			
			//Using the project number
			if (choice == 1) {
				
				try {
					
					String projRowString = "";
					int totalFee = 0;
					int totalPaid = 0;
					int amountDue = 0;
					String custDetails = ""; 
					String projManName = "";
					
					Scanner userInput = new Scanner(System.in);
					System.out.println("\nPlease enter the Project Number of the project you wish to finalise: ");
					String projectNum = userInput.nextLine();
					System.out.println("\nPlease enter the date the project was finalised: ");
					String finalisedDate = userInput.nextLine();
					
					try {
						
						Connection connection = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/poisepms_db",
								"root",
								"Lenovo@14"
								);
						
						Statement statement = connection.createStatement();
						ResultSet results = statement.executeQuery("select * from projects where Project_Number = " + projectNum + "");
						
						while (results.next()) {
							
							totalFee = results.getInt("Total_Fee");
							totalPaid = results.getInt("Total_Paid");
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
						ResultSet results = statement.executeQuery("select * from people where Project_Manager_Name = '" + projManName + "'");
						
						while (results.next()) {
							
							custDetails = "\nCustomer Name: " + results.getString("Customer_Name") +
											"\nCustomer Telephone Number: " + results.getString("Customer_Telephone_Number") +
											"\nCustomer Email: " + results.getString("Customer_Email") +
											"\nCustomer Address: " + results.getString("Customer_Address");
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
						ResultSet results = statement.executeQuery("select * from projects where Project_Number = " + projectNum + "");
						int rowsAffected;
						
						while (results.next()) {
							
							projRowString = "INSERT INTO completedprojects VALUES (" + results.getInt("Project_Number") + ", '" +
									results.getString("Project_Name") + "', '" + results.getString("Project_Type") + "', '" +
									results.getString("Project_Address") + "', " + results.getInt("Project_Erf_Number") + ", '" +
									results.getInt("Total_Fee") + "', '" + results.getInt("Total_Paid") + "', '" +
									results.getString("Project_Deadline") + "', '" + results.getString("Architect_Name") + "', '" +
									results.getString("Contractor_Name") + "', '" + results.getString("Structural_Engineer_Name") + "', '" +
									results.getString("Customer_Name") + "', '" + results.getString("Project_Manager") + "', 'Finalised', '" +
									finalisedDate + "')";
							
						}
						
						String tableString = "DELETE FROM projects WHERE Project_Number = " + projectNum + ";";
						
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
						ResultSet results = statement.executeQuery("SELECT * FROM completedprojects");
						int rowsAffected;
						
						rowsAffected = statement.executeUpdate(projRowString); 
						
					}
					
					catch (SQLException e) {
						e.printStackTrace();
						Menu.main(null);
					}
					
					System.out.println("\nProject has been finalised.");
				
					if (totalFee == totalPaid) {
						
						amountDue = totalFee - totalPaid;
						
						System.out.println("\nInvoice:\n "  + custDetails + "\nTotal Fee: " + Integer.toString(totalFee) + "\nTotal Paid: " +
											Integer.toString(totalPaid) + "\nAmount Due: "  + Integer.toString(amountDue));
						
					}
					
					else{
						Menu.main(null);
					}
					
					
				}
				
				catch (InputMismatchException e) {
					System.out.println("Invalid Input Please Try Again.");
					FinaliseProject.finaliseProject();
				}
			}
			
			//Project Name
			else if (choice == 2) {
				
				try {
					
					String projRowString = "";
					int totalFee = 0;
					int totalPaid = 0;
					int amountDue = 0;
					String custDetails = ""; 
					String projManName = "";
					
					Scanner userInput = new Scanner(System.in);
					System.out.println("\nPlease enter the Project Name of the project you wish to finalise: ");
					String projectName = userInput.nextLine();
					System.out.println("\nPlease enter the date the project was finalised: ");
					String finalisedDate = userInput.nextLine();
					
					try {
						
						Connection connection = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/poisepms_db",
								"root",
								"Lenovo@14"
								);
						
						Statement statement = connection.createStatement();
						ResultSet results = statement.executeQuery("select * from projects where Project_Name = '" + projectName + "'");
						
						while (results.next()) {
							
							totalFee = results.getInt("Total_Fee");
							totalPaid = results.getInt("Total_Paid");
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
						ResultSet results = statement.executeQuery("select * from people where Project_Manager_Name = '" + projManName + "'");
						
						while (results.next()) {
							
							custDetails = "\nCustomer Name: " + results.getString("Customer_Name") +
											"\nCustomer Telephone Number: " + results.getString("Customer_Telephone_Number") +
											"\nCustomer Email: " + results.getString("Customer_Email") +
											"\nCustomer Address: " + results.getString("Customer_Address");
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
						ResultSet results = statement.executeQuery("select * from projects where Project_Name = '" + projectName + "'");
						int rowsAffected;
						
						while (results.next()) {
							
							projRowString = "INSERT INTO completedprojects VALUES (" + results.getInt("Project_Number") + ", '" +
									results.getString("Project_Name") + "', '" + results.getString("Project_Type") + "', '" +
									results.getString("Project_Address") + "', " + results.getInt("Project_Erf_Number") + ", '" +
									results.getInt("Total_Fee") + "', '" + results.getInt("Total_Paid") + "', '" +
									results.getString("Project_Deadline") + "', '" + results.getString("Architect_Name") + "', '" +
									results.getString("Contractor_Name") + "', '" + results.getString("Structural_Engineer_Name") + "', '" +
									results.getString("Customer_Name") + "', '" + results.getString("Project_Manager") + "', 'Finalised', '" +
									finalisedDate + "')";
							
						}
						
						String tableString = "DELETE FROM projects WHERE Project_Number = '" + projectName + "';";
						
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
						ResultSet results = statement.executeQuery("SELECT * FROM completedprojects");
						int rowsAffected;
						
						rowsAffected = statement.executeUpdate(projRowString); 
						
					}
					
					catch (SQLException e) {
						e.printStackTrace();
						Menu.main(null);
					}
					
					System.out.println("\nProject has been finalised.");
					
					if (totalFee != totalPaid) {
						
						amountDue = totalFee - totalPaid;
						
						System.out.println("\nInvoice:\n "  + custDetails + "\nTotal Fee: " + Integer.toString(totalFee) + "\nTotal Paid: " +
											Integer.toString(totalPaid) + "\nAmount Due: "  + Integer.toString(amountDue));
						
					}
					
					else{
						Menu.main(null);
					}

				}
					
				catch (InputMismatchException e) {
					System.out.println("Input Invalid Please Try Again.");
					Menu.main(null);
				}
			}
			
			else if (choice == 3) {
				Menu.main(null);
			}
			
			else if (choice == 0) {
				
				System.out.println("\nProgram has ended!");
				System.out.println("Goodbye :)");
				
			}
			
			else {
				
				System.out.println("\nInvalid input recieved! Please make sure you input the number of the corresponding choice.");
				FinaliseProject.finaliseProject();
				
			}
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("You have given an invalid input.");
			FinaliseProject.finaliseProject();
		}
		
	}
}
