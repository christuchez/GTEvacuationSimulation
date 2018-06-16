import java.util.LinkedList;
import java.util.Random;

/**
 * The official car maker
 *
 */
public class Tesla {
	
	private final int ROAD5UPPERBOUND 	  = 50;
	private final int ROAD9UPPERBOUND 	  = ROAD5UPPERBOUND;
	private final int ROAD10UPPERBOUND    = ROAD5UPPERBOUND;
	private final int FUNSIZED1UPPERBOUND = 25;
	private final int FUNSIZED2UPPERBOUND = FUNSIZED1UPPERBOUND;
	private final int FUNSIZED3UPPERBOUND = FUNSIZED1UPPERBOUND;
	
	private final int ROAD5LOWERBOUND  	  = 25;
	private final int ROAD9LOWERBOUND 	  = ROAD5LOWERBOUND;
	private final int ROAD10LOWERBOUND    = ROAD5LOWERBOUND;
	private final int FUNSIZED1LOWERBOUND = 12;
	private final int FUNSIZED2LOWERBOUND = FUNSIZED1LOWERBOUND;
	private final int FUNSIZED3LOWERBOUND = FUNSIZED1LOWERBOUND;
	
	private DRNG digitalRandom;
	private Random normalRandom;
	
	private LinkedList<Vehicle> funSized1;
	private LinkedList<Vehicle> funSized2;
	private LinkedList<Vehicle> funSized3;
	private LinkedList<Vehicle> road5Queue;
	private LinkedList<Vehicle> road9Queue;
	private LinkedList<Vehicle> road10Queue;
	private LinkedList<Vehicle> allTheCars;
	
	private int total;
	private int road5Actual;
	private int road9Actual;
	private int road10Actual;
	private int funSized1Actual;
	private int funSized2Actual;
	private int funSized3Actual;
	private boolean hasIvyBridge;
	
	/**
	 * Checks if we have an IvyBridge system, otherwise uses Java's built in random generator
	 * Makes and assigns the cars
	 */
	public Tesla(){
		try {
			digitalRandom = new DRNG();
			hasIvyBridge = true;
		}
		catch(UnsupportedOperationException e) {
			normalRandom  = new Random();
		}
		
		funSized1 	  = new LinkedList<Vehicle>();
		funSized2 	  = new LinkedList<Vehicle>();
		funSized3 	  = new LinkedList<Vehicle>();
		road5Queue	  = new LinkedList<Vehicle>();
		road5Queue 	  = new LinkedList<Vehicle>();
		road9Queue 	  = new LinkedList<Vehicle>();
		road10Queue   = new LinkedList<Vehicle>();
		allTheCars 	  = new LinkedList<Vehicle>();
		
		if(hasIvyBridge) {
			setNumberOfCarsAssignableByDRNG(digitalRandom);
		} 
		else {
			setNumberOfCarsAssignableByJRNG(normalRandom);
		}
		
		total = funSized1Actual + funSized2Actual + funSized3Actual + road5Actual + road9Actual + road10Actual;
		makeAndAssignCars();
	}

	/**
	 * Generates cars and adds them to the carsList
	 */
	private void makeAndAssignCars(){
		for(int i = 1; i <= total; i++){
			Vehicle newCar = new Vehicle(i,  System.currentTimeMillis());
			allTheCars.add(newCar);
		}
		assignCars();
	}
	
	/**
	 * Assigns each car to parking lot's road queue
	 */
	private void assignCars(){ 
		for(int i = 0; i < road5Actual; i++){
			road5Queue.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
		for(int i = 0; i < road9Actual; i++){
			road9Queue.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
		for(int i = 0; i < road10Actual; i++){
			road10Queue.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
		
		for(int i = 0; i < funSized1Actual; i++){
			funSized1.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
		for(int i = 0; i < funSized2Actual; i++){
			funSized2.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
		for(int i = 0; i < funSized3Actual; i++){ 
			funSized3.add(allTheCars.getFirst());
			allTheCars.removeFirst();
		}
	}
	
	/**
	 * Generates the number of cars for each road coming out of the parking lot based on DRNG
	 * @param randomGenerator
	 */
	private void setNumberOfCarsAssignableByDRNG(DRNG randomGenerator) {
		road5Actual = randomGenerator.getRandomInt(ROAD5LOWERBOUND, ROAD5UPPERBOUND);
		road9Actual = randomGenerator.getRandomInt(ROAD9LOWERBOUND, ROAD9UPPERBOUND);
		road10Actual = randomGenerator.getRandomInt(ROAD10LOWERBOUND, ROAD10UPPERBOUND);
		funSized1Actual = randomGenerator.getRandomInt(FUNSIZED1LOWERBOUND, FUNSIZED1UPPERBOUND); 
		funSized2Actual = randomGenerator.getRandomInt(FUNSIZED2LOWERBOUND, FUNSIZED2UPPERBOUND);    
		funSized3Actual = randomGenerator.getRandomInt(FUNSIZED3LOWERBOUND, FUNSIZED3UPPERBOUND);
	}
	
	/**
	 * Generates the number of cars for each road coming out of the parking lot based on JRNG
	 * @param randomGenerator
	 */
	private void setNumberOfCarsAssignableByJRNG(Random randomGenerator) {
		funSized1Actual = randomGenerator.nextInt(FUNSIZED1UPPERBOUND-FUNSIZED1LOWERBOUND)+FUNSIZED1LOWERBOUND; 
		funSized2Actual = randomGenerator.nextInt(FUNSIZED2UPPERBOUND-FUNSIZED2LOWERBOUND)+FUNSIZED2LOWERBOUND;    
		funSized3Actual = randomGenerator.nextInt(FUNSIZED3UPPERBOUND-FUNSIZED3LOWERBOUND)+FUNSIZED3LOWERBOUND;
		road5Actual = randomGenerator.nextInt(ROAD5UPPERBOUND-ROAD5LOWERBOUND)+ROAD5LOWERBOUND;
		road9Actual = randomGenerator.nextInt(ROAD9UPPERBOUND-ROAD9LOWERBOUND)+ROAD9LOWERBOUND;
		road10Actual = randomGenerator.nextInt(ROAD10UPPERBOUND-ROAD10LOWERBOUND)+ROAD10LOWERBOUND;
	}
	
	/**
	 * Gets the total number of cars
	 * @return
	 */
	public int getTotalCars(){
		return total;
	}
	
	/**
	 * Returns the list of cars at fun size parking lot 1
	 * @return
	 */
	public LinkedList<Vehicle> getFunSized1List(){
		return funSized1;
	}
	
	/**
	 * Returns the list of cars at fun size parking lot 2
	 * @return
	 */
	public LinkedList<Vehicle> getFunSized2List(){
		return funSized2;
	}
	
	/**
	 * Returns the list of cars at fun size parking lot 3
	 * @return
	 */
	public LinkedList<Vehicle> getFunSized3List(){
		return funSized3;
	}
	
	/**
	 * Returns the list of cars assigned to road 5's queue in mega parking lot
	 * @return
	 */
	public LinkedList<Vehicle> getRoad5Queue(){
		return road5Queue;
	}
	
	/**
	 * Returns the list of cars assigned to road 9's queue in mega parking lot
	 * @return
	 */
	public LinkedList<Vehicle> getRoad9Queue(){
		return road9Queue;
	}
	
	/**
	 * Returns the list of cars assigned to road 10's queue in mega parking lot
	 * @return
	 */
	public LinkedList<Vehicle> getRoad10Queue(){
		return road10Queue;
	}
	
	
}
