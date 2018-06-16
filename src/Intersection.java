import java.util.Arrays;
import java.util.LinkedList;

/**
 * Server for vehicles. Queues will be mediated at this location. 
 * Cars will either move on their own or be directed by police officers here.
 *
 */
public class Intersection {
	private boolean hasPoliceOfficer;
	private boolean shouldFlash;

	private Road[] travelable;
	private LinkedList<Road> source;
	private LinkedList<Road> totalRoads; 
  
	private int x;
	private int y;

	/**
	 * Constructor for the roads. Separates the destination roads from the source roads
	 * @param hasPoliceOfficer
	 * @param road1
	 * @param road2
	 * @param road3
	 */
	public Intersection(boolean hasPoliceOfficer, Road road1, Road road2, Road road3, Road[] travelable, int x, int y) {
		this.x = x;
		this.y = y;
		
		this.travelable = travelable;
		this.hasPoliceOfficer = hasPoliceOfficer;
		
		totalRoads = new LinkedList<Road>();
		source = new LinkedList<Road>();
		
		if(road1.getRoadName() != 500) {
			totalRoads.add(road1);
		}
		if(road2.getRoadName() != 500) {
			totalRoads.add(road2);
		}
		if(road3.getRoadName() != 500) {
			totalRoads.add(road3);
		}
		
		for(Road aRoad : totalRoads) {
			if(!Arrays.asList(travelable).contains(aRoad)) {
				source.add(aRoad);
			}
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
	
	/**
	 * Checks if a police officer is at intersection
	 * @return
	 */
	public boolean hasPoliceOfficer() {
		return hasPoliceOfficer;
	}
	
	/**
	 * Allows one to set if a police officer is at an intersection
	 * @param hasPoliceOfficer
	 */
	public void setPoliceOfficer(boolean hasPoliceOfficer) {
		this.hasPoliceOfficer = hasPoliceOfficer;
	}
	
	/**
	 * Moves vehicles between the current road and the destination road
	 * @param currentRoad
	 * @param destinationRoad
	 */
	public void moveVehicleBetweenRoads(Road sourceRoad, Road destinationRoad) {
		Vehicle vehicle = sourceRoad.getFirstCar();
		if(vehicle != null) {
			shouldFlash = true;
			//System.out.println("car "+vehicle.getID() + " from " + sourceRoad.getRoadName()+"to "+ destinationRoad.getRoadName());
			destinationRoad.addVehicle(vehicle);
			sourceRoad.deleteFirstCar();
		}
	}
	
	/**
	 * Sets the intersection to not flash
	 */
	public void setShouldNotFlash(){
		shouldFlash = false;
	}
	
	/**
	 * Returns if the intersection should flash
	 * @return
	 */
	public boolean shouldFlash() {
		return shouldFlash;
	}
	
	/**
	 * Moves three vehicles between roads, used when the officer is present
	 * @param sourceRoad
	 * @param destinationRoad
	 */
	public void moveThreeVehiclesBetweenRoads(Road sourceRoad, Road destinationRoad){
		Vehicle car1 = sourceRoad.getFirstCar();
		Vehicle car2 = sourceRoad.getSecondCar();
		Vehicle car3 = sourceRoad.getThirdCar();
		if((car1 != null) && (car2 != null) && (car3 != null)) {
			shouldFlash = true;
			destinationRoad.specialAddForThree(car1, car2, car3);
			sourceRoad.specialDeleteForThree();
			//System.out.println("three moved "+car1.getID()+" "+car2.getID()+" "+car3.getID() +" from "+sourceRoad.getRoadName()+
			//		" to "+ destinationRoad.getRoadName());
		}
	}
	
	/**
	 * Handles movement of cars once they reach an intersection. 
	 * Without Police Officer: FIFO
	 * With Police Officer: First three move if space available, else FIFO
	 */
	public void updateQueues() {
		if(hasPoliceOfficer) {
			if(travelable.length == 2) { //Starting from the travelable locations, we consider if we have spaces free. If we do then allow the source to cross. 
				Road sourceRoad = source.getLast();
				for(Road destinationRoad : travelable) {
					if(sourceRoad.threeCarsAtFront()) {
						if(destinationRoad.lastThreeSpotsEmpty()) {
							moveThreeVehiclesBetweenRoads(sourceRoad, destinationRoad);
						}
					}
					else if(destinationRoad.isLastSpotEmpty()){	
							if(sourceRoad.isCarAtFront()) {
								moveVehicleBetweenRoads(sourceRoad, destinationRoad);
							}
					}
				}
			}
			else { 
				for(Road sourceRoad : source) {
					Road destinationRoad = travelable[0]; //only one possible destination here
					if(sourceRoad.threeCarsAtFront()) {
						if(destinationRoad.lastThreeSpotsEmpty()) {
							moveThreeVehiclesBetweenRoads(sourceRoad, destinationRoad);
						}
					}
					else if(sourceRoad.isCarAtFront()) {
						if(destinationRoad.isLastSpotEmpty()) {
							moveVehicleBetweenRoads(sourceRoad, destinationRoad);
						}
					}
				}
			}
		}
		else {
			if(travelable.length == 2) {
				for(Road destinationRoads : travelable) {
					if(destinationRoads.isLastSpotEmpty()) {
						Road sourceRoad = source.getLast(); //only one possible source
						if(sourceRoad.isCarAtFront()) {
							moveVehicleBetweenRoads(sourceRoad, destinationRoads);
						}
					}
				}
			}
			else {
				for(Road sourceRoad : source) {
					if(sourceRoad.isCarAtFront()) {
						Road destinationRoad = travelable[0]; //only one possible destination here
						if(destinationRoad.isLastSpotEmpty()) {
							moveVehicleBetweenRoads(sourceRoad, destinationRoad);
						}
					}
				}
			}
		}
	}

}
