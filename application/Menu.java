package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.VehicleDao;
import entity.Vehicle;

public class Menu {


	private VehicleDao vehicleDao = new VehicleDao();
	private Scanner scanner = new Scanner(System.in); 
	private List<String> options = Arrays.asList(
			"Add Vehicle",
			"Display Vehicles",
			"Update Vehicle",
			"Delete Vehicle"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					createVehicle();
				} else if (selection.equals("2")) {
					displayVehicles();
				} else if (selection.equals("3")) {
					updateVehicle();
				} else if (selection.equals("4")) {
					deleteVehicle();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------------");
		for (int i=0; i<options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayVehicles() throws SQLException {
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getVehicleId() + ": " + vehicle.getMake());
		}
	}
	
	private void updateVehicle() throws SQLException {
		System.out.println("Enter vehicle id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new vehicle make: ");
		String make = scanner.nextLine();
		vehicleDao.updateVehicleById(id, make);
	}
	
	private void createVehicle() throws SQLException {
		System.out.print("Enter new vehicle make:");
		String vehicleMake = scanner.nextLine();
		vehicleDao.createNewVehicle(vehicleMake);
	}
	
	private void deleteVehicle() throws SQLException {
		System.out.print("Enter vehicle id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		vehicleDao.deleteVehicleById(id);
	}
}
