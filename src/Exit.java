import java.util.LinkedList;

/**
 * Removes vehicles from the simulation
 */
public class Exit 
{
	private Road road;
	private int count;
	private int x;
	private int y;
	private boolean shouldFlash;
	private LinkedList<Vehicle> carsExited;

	/**
	 * Constructor for the Exit
	 * @param road
	 */
	public Exit(Road road, int x, int y) {
		this.x 	   = x;
		this.y 	   = y;
		this.road  = road;
		carsExited = new LinkedList<Vehicle>();
	}
	
	/**
	 * Removes a vehicle from the simulation if it reaches the highway
	 */
	public void removeVehicle() {
		if(road.isCarAtFront()) {
			carsExited.add(road.getFirstCar());
			road.deleteFirstCar();
			count++;
			shouldFlash = true;
		}
	}
	
	/**
	 * Sets the exit sign to not flash
	 */
	public void setShouldNotFlash(){
		shouldFlash = false;
	}
	
	/**
	 * Returns whether the sign should flash
	 * @return
	 */
	public boolean shouldFlash() {
		return shouldFlash;
	}
	
	/**
	 * Returns the number of vehicles that have exited the simulation
	 * @return
	 */
	public int getNumberExited() {
		return count;
	}
	
	/**
	 * Prints out the exited vehicles
	 */
	public void getExitedVehicles(){
		for(Vehicle aCar : carsExited){
			System.out.println("car exited: " + aCar.getID() + " ");
		}
	}
	
	/**
	 * Gets the x coordinate of the intersection
	 * @return
	 */
	public int getXPosition() {
		return x;
	}
	
	/**
	 * Gets the y coordinate of the intersection
	 * @return
	 */
	public int getYPosition() {
		return y;
	}
}
