package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Vehicle;

public class VehicleDao {

	private Connection connection;
	//private VehicleDao vehicleDao;
	private final String GET_VEHICLES_QUERY = "SELECT * FROM vehicles";
	private final String UPDATE_VEHICLE_BY_ID_QUERY = "UPDATE vehicles SET make = ? WHERE id = ?";
	private final String CREATE_NEW_VEHICLE_QUERY = "INSERT INTO vehicles (make) VALUES(?)";
	private final String DELETE_VEHICLE_BY_ID_QUERY = "DELETE FROM vehicles WHERE id = ?";
	
	public VehicleDao() {
		 connection = DBConnection.getConnection();
		 //new VehicleDao();
	}
	
	public List<Vehicle> getVehicles() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_VEHICLES_QUERY).executeQuery();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while (rs.next()) {
			vehicles.add(new Vehicle(rs.getInt(1), rs.getString(2)));
		}
		return vehicles;
	}
	
	public void updateVehicleById(int id, String make) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.setString(2, make);
		ps.executeUpdate();
	}
	
	public void createNewVehicle(String make) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_VEHICLE_QUERY);
		ps.setString(1, make);
		ps.executeUpdate();
	}
	
	public void deleteVehicleById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
