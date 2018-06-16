import java.util.LinkedList;


/**
 * A very large parking lot (like Curran Parking Deck on West Campus)
 *
 */
public class MegaParkingLot {

	private Road road5;
	private Road road10;
	private Road road9;
	LinkedList<Vehicle> road5WaitingQueue; 
	LinkedList<Vehicle> road9WaitingQueue; 
	LinkedList<Vehicle> road10WaitingQueue; 
	
	/**
	 * A very large parking lot
	 * @param road5
	 * @param road9
	 * @param road10
	 * @param road5WaitingQueue
	 * @param road9WaitingQueue
	 * @param road10WaitingQueue
	 */
	public MegaParkingLot(Road road5, Road road9, Road road10, LinkedList<Vehicle> road5WaitingQueue, LinkedList<Vehicle> road9WaitingQueue,
			LinkedList<Vehicle> road10WaitingQueue){
		this.road5 = road5;
		this.road10 = road10;
		this.road9 = road9;
		this.road5WaitingQueue = road5WaitingQueue;
		this.road9WaitingQueue = road9WaitingQueue;
		this.road10WaitingQueue = road10WaitingQueue;
	}
	
	
	/**
	 * Adds vehicle to the road, removes it from the internal parking lot queue
	 */
	public void updateRoad5(){                             
		while((road5.isLastSpotEmpty() && (road5WaitingQueue.size() > 0))){
			road5.addVehicle(road5WaitingQueue.getFirst());
			road5WaitingQueue.removeFirst();
		}
	}
	
	
	/**
	 * 	Adds vehicle to the road, removes it from the internal parking lot queue
	 */
	public void updateRoad9(){                      
		while((road9.isLastSpotEmpty() && (road9WaitingQueue.size() > 0))){
			road9.addVehicle(road9WaitingQueue.getFirst());
			road9WaitingQueue.removeFirst();
		}
	}
	
	
	/**
	 * 	Adds vehicle to the road, removes it from the internal parking lot queue
	 */
	public void updateRoad10(){                      
		while((road10.isLastSpotEmpty() && (road10WaitingQueue.size() > 0))){
			road10.addVehicle(road10WaitingQueue.getFirst());
			road10WaitingQueue.removeFirst();
		}
	}
}
