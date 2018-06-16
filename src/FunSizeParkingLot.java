import java.util.LinkedList;

/**
 * Small parking lot
 *
 */
public class FunSizeParkingLot {

	private Road aRoad;
	LinkedList<Vehicle> aRoadWaitingQueue;
	
	/**
	 * Instantiates the roads and internal waiting queue
	 * @param aRoad
	 * @param aRoadWaitingQueue
	 */
	public FunSizeParkingLot(Road aRoad, LinkedList<Vehicle> aRoadWaitingQueue){
		this.aRoad = aRoad;
		this.aRoadWaitingQueue = aRoadWaitingQueue;
	}
	
	/**
	 * Adds vehicle to the road, removes vehicle from the internal waiting queue
	 */
	public void updateRoad(){                      
		while((aRoad.isLastSpotEmpty() && (aRoadWaitingQueue.size() > 0))){
			aRoad.addVehicle(aRoadWaitingQueue.getFirst());
			aRoadWaitingQueue.removeFirst();
		}
	}
}
