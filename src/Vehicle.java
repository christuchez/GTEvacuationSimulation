/**
 * Agent in the agent based simulation.
 * It is the most atomic unit in our simulation, the humble vehicle.
 *
 */
public class Vehicle {
	private int vehicleID;
	private Road theRoad;
	private double timestamp;
	
	/**
	 * Constructor for the Vehicle
	 * @param vehicleID
	 * @param timestamp
	 */
	public Vehicle(int vehicleID, double timestamp) 
	{
		this.vehicleID = vehicleID;
		this.timestamp = timestamp; 
	}
	
	/**
	 * Gets the unique ID of the vehicle
	 * @return
	 */
	public int getID(){
		return vehicleID;
	}
	
	/**
	 * Sets the road the vehicle is on
	 * @param theRoad
	 */
	public void setRoad(Road theRoad){
		this.theRoad = theRoad;
	}
	
	/**
	 * Gets the road the vehicle is on
	 * @return
	 */
	public Road getRoad(){
		return theRoad;
	}
	
	/**
	 * Sets the timestamp of the vehicle entering a new road
	 * @param timestamp
	 */
	public void setTimeStamp(double timestamp) {
		this.timestamp = timestamp; 
	}
	
	/**
	 * Gets the time the vehicle entered a new road/intersection
	 * @return
	 */
	public double getTimeStamp() {
		return timestamp;
	}
}
	
	
	
