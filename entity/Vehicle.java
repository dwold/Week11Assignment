package entity;

public class Vehicle {

	private int vehicleId;
	private String make;
	
	
	public Vehicle(int vehicleId, String make) {
		this.setVehicleId(vehicleId);
		this.setMake(make);
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

}
