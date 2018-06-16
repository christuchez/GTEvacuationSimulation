/**
 * Representation of the Queue in our conceptual model
 *
 */
public class Road 
{
	private int numVehiclesAllowed;    //this is also the length of the road
	private Vehicle[] roadQueue;
	private int roadName;
	
	/**	Allows one to create specialized road
	 * @param numVehiclesAllowed
	 * @param direction
	 * @param roadName
	 */
	public Road(int numVehiclesAllowed, String direction, int roadName) {
		roadQueue = new Vehicle[numVehiclesAllowed];
		this.roadName = roadName;
		this.numVehiclesAllowed = numVehiclesAllowed;
	}
	
	
	
	/**
	 * Gets the name of the road
	 * @return
	 */
	public int getRoadName(){
		return roadName;
	}
	
	
	/**
	 * Adds a vehicle to the queue
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		if((isLastSpotEmpty()) && (vehicle != null)){
			roadQueue[0] = vehicle;
			vehicle.setTimeStamp(System.currentTimeMillis());
		}
	}
	
	public void specialAddForThree(Vehicle car1, Vehicle car2, Vehicle car3){
		roadQueue[0] = car3;
		roadQueue[1] = car2;
		roadQueue[2] = car1;
	}
	
	public void specialDeleteForThree(){
		roadQueue[roadQueue.length - 1] = null; 
		roadQueue[roadQueue.length - 2] = null;
		roadQueue[roadQueue.length - 3] = null;
	}
	
	
	/**
	 * Checks if there are up to three spots free at the end of the queue
	 * @return
	 */
	public boolean lastThreeSpotsEmpty() {
		boolean toReturn = false;
		if((roadQueue[0] == null) && (roadQueue[1] == null) &&
		  (roadQueue[2] == null)){
			toReturn = true;
		}
		return toReturn;
	}
	
	
	public boolean threeCarsAtFront() {
		boolean toReturn = false;
		if((roadQueue[roadQueue.length - 1] != null) && (roadQueue[roadQueue.length - 2] != null) &&
		  (roadQueue[roadQueue.length - 3] != null)){
			toReturn = true;
		}
		return toReturn;
	}
	
	
	
	/**
	 * Checks if the last spot in the queue is empty
	 * @return
	 */
	public boolean isLastSpotEmpty(){
		boolean toReturn = false;
		if(roadQueue[0] == null){
			toReturn = true;
		}
		return toReturn;
	}
	
	
	public boolean isCarAtFront(){
		boolean toReturn = false;
		if(roadQueue[roadQueue.length - 1] != null){
			toReturn = true;
		}
		return toReturn;
	}
	/**
	 * Gets the first car from the end of the queue
	 * @return
	 */
	public Vehicle getFirstCar() {
		Vehicle vehicle = null;
		if((numVehiclesAllowed != 0) && (roadQueue[numVehiclesAllowed - 1] != null)) {
			vehicle = roadQueue[numVehiclesAllowed - 1];
		}
		return vehicle;
	}
	
	public Vehicle getSecondCar() {
		Vehicle vehicle = null;
		if((numVehiclesAllowed != 0) && (roadQueue[numVehiclesAllowed - 2] != null)) {
			vehicle = roadQueue[numVehiclesAllowed - 2];
		}
		return vehicle;
	}
	
	
	public Vehicle getThirdCar() {
		Vehicle vehicle = null;
		if((numVehiclesAllowed != 0) && (roadQueue[numVehiclesAllowed - 3] != null)) {
			vehicle = roadQueue[numVehiclesAllowed - 3];
		}
		return vehicle;
	}
	
	
	/**
	 * Gets the most recent car added to the queue
	 * @return
	 */
	public Vehicle getLastCar() {
		return roadQueue[0];
	}

	
	/**
	 * Deletes the car from the end of the queue and moves the cars up
	 */
	public void deleteFirstCar(){
		roadQueue[roadQueue.length - 1] = null;
	}
	
	/**
	 * Moves the cars forward
	 */
	public void moveCarsForward() {
		for(int i = roadQueue.length - 1; i > 0 ; i--){ 
			if((roadQueue[i] == null) && (roadQueue[i - 1] != null)) {
				roadQueue[i] = roadQueue[i - 1];
				roadQueue[i - 1] = null;
				//System.out.println(roadName + ": " + roadQueue[i].getID());
			}
			if((roadQueue[i] != null) && (roadQueue[i-1] != null)){      //janky fix for doubling bug
				if(roadQueue[i].getID() == roadQueue[i-1].getID()){
					roadQueue[i - 1] = null;
				}
			}
		}
	}
	
	/**
	 * Constructs the backbone for the command line GUI
	 */
	@Override
	public String toString() {
		String string = "Road: " + roadName;
		for(int i = 0; i < roadQueue.length; i++) {
			if(roadQueue[i] != null){
				string = string + " [" + roadQueue[i].getID() + "] ";
			}
			else{
				string = string + " [noCar] ";
			}
		}
		return string;
	}
}
