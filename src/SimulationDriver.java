import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;


/**
 * Runs the main simulation
 *
 */
public class SimulationDriver {
	public static final int NUMBER_OF_ITERATIONS = 1;
	
	/**
	 * Runs the main Simulation
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the main driver of the GT Evacuation Simulation");
		
		/* Creates all the roads */
		Road road1 = new Road(6, "EAST", 1);
		Road road2 = new Road(21, "EAST", 2);
		Road road3 = new Road(18, "EAST", 3);
		Road road4 = new Road(24, "EAST", 4);
		Road road5 = new Road(6, "NORTH", 5);
		Road road6 = new Road(9, "SOUTHEAST", 6);
		Road road7 = new Road(15, "NORTH", 7);
		Road road8 = new Road(12, "SOUTH", 8);
		Road road9 = new Road(3, "WEST", 9);
		Road road10 = new Road(6, "NORTHEAST", 10);
		Road road11 = new Road(9, "SOUTHEAST", 11);
		Road road12 = new Road(6, "SOUTH", 12);
		Road road13 = new Road(9, "NORTH", 13);
		Road road14 = new Road(15, "EAST", 14);
		Road road15 = new Road(18, "EAST", 15);
		Road road16 = new Road(6, "EAST", 16);
		Road road17 = new Road(15, "NORTH", 17);
		Road road18 = new Road(15, "EAST", 18);
		Road road19 = new Road(33, "SOUTHEAST", 19);
		Road road20 = new Road(9, "NORTH", 20);
		Road road21 = new Road(15, "EAST", 21);
		Road road22 = new Road(15, "EAST", 22);
		Road road23 = new Road(24, "NORTH", 23);
		Road road24 = new Road(12, "NORTH", 24);
		Road road25 = new Road(12, "EAST", 25);
		Road road26 = new Road(15, "EAST", 26);
		Road dummy = new Road(0, "NULL",500);
		
		
		/* Creates all the intersections */
		Intersection id51 = new Intersection(false, dummy, road5, road1, new Road[]{road1}, 79, 30);
		Intersection i162 = new Intersection(true, road1, road6, road2, new Road[]{road2, road6}, 115, 30);
		Intersection i273 = new Intersection(false, road2, road7, road3, new Road[]{road3}, 273, 30);
		Intersection i384 = new Intersection(true, road3, road8, road4, new Road[]{road8, road4}, 378, 30);
		Intersection id919 = new Intersection(false, dummy, road9, road19, new Road[]{road19}, 25, 105);
		Intersection i10611 = new Intersection(false, road10, road6, road11, new Road[]{road11}, 150, 86);
		Intersection i131114 = new Intersection(true, road13, road11, road14, new Road[]{road14}, 179, 131);
		Intersection i71415 = new Intersection(false, road7, road14, road15, new Road[]{road7, road15}, 272, 138);
		Intersection i161215 = new Intersection(false, road16, road12, road15, new Road[]{road16}, 380, 179);
		Intersection i8d12 = new Intersection(false, road8, dummy, road12, new Road[]{road12}, 375, 129);
		Intersection i161718 = new Intersection(true, road16, road17, road18, new Road[]{road18}, 419, 181);
		Intersection i13d20 = new Intersection(false, road13, dummy, road20, new Road[]{road13}, 153, 216);
		Intersection i192021 = new Intersection(true, road19, road20, road21, new Road[]{road21, road20}, 153, 285);
		Intersection i21d22 = new Intersection(false, road21, dummy, road22, new Road[]{road22}, 260, 312);
		Intersection i222325 = new Intersection(false, road22, road23, road25, new Road[]{road23, road25}, 331, 366);
		Intersection i252426 = new Intersection(true, road25, road24, road26, new Road[]{road26, road24}, 419, 366);
		Intersection i232417 = new Intersection(false, road23, road24, road17, new Road[]{road17}, 419, 285);
	
		/* Creates the list of intersections */
		LinkedList<Intersection> intersectionList = new LinkedList<Intersection>();
		intersectionList.add(id51);
		intersectionList.add(i162);
		intersectionList.add(i273);
		intersectionList.add(i384);
		intersectionList.add(id919);
		intersectionList.add(i10611);
		intersectionList.add(i131114);
		intersectionList.add(i71415);
		intersectionList.add(i161215);
		intersectionList.add(i8d12);
		intersectionList.add(i161718);
		intersectionList.add(i13d20);
		intersectionList.add(i192021);
		intersectionList.add(i21d22);
		intersectionList.add(i222325);
		intersectionList.add(i252426);
		intersectionList.add(i232417);
		
		/* Creates the list of roads */
		LinkedList<Road> roadsList = new LinkedList<Road>();
		roadsList.add(road1);
		roadsList.add(road2);
		roadsList.add(road3);
		roadsList.add(road4);
		roadsList.add(road5);
		roadsList.add(road6);
		roadsList.add(road7);
		roadsList.add(road8);
		roadsList.add(road9);
		roadsList.add(road10);
		roadsList.add(road11);
		roadsList.add(road12);
		roadsList.add(road13);
		roadsList.add(road14);
		roadsList.add(road15);
		roadsList.add(road16);
		roadsList.add(road17);
		roadsList.add(road18);
		roadsList.add(road19);
		roadsList.add(road20);
		roadsList.add(road21);
		roadsList.add(road22);
		roadsList.add(road23);
		roadsList.add(road24);
		roadsList.add(road25);
		roadsList.add(road26);
		
		/* Map to associate simulation time with the number of vehicles */
		TreeMap<Integer, ArrayList<Long>> simulationTimes = new TreeMap<Integer, ArrayList<Long>>();

		/* Run the simulation for a set number of iterations */
		for(int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
			System.out.println("---------------------Start---------------------");
			
			/* Creates all the exits */
			LinkedList<Exit> exitList = new LinkedList<Exit>();
			Exit tenthStExit = new Exit(road4, 548, 43);
			Exit northAveExit  = new Exit(road18, 548, 199);
			Exit fifthStExit = new Exit(road26, 548, 376);
			exitList.add(tenthStExit);
			exitList.add(northAveExit);
			exitList.add(fifthStExit);
			
			/* Tesla makes all the vehicles */
			Tesla carMaker = new Tesla();
		
			/* Creates the parking lots */
			FunSizeParkingLot funSizeParkingLot1 = new FunSizeParkingLot(road13, carMaker.getFunSized1List());
			FunSizeParkingLot funSizeParkingLot2 = new FunSizeParkingLot(road22, carMaker.getFunSized2List());
			FunSizeParkingLot funSizeParkingLot3 = new FunSizeParkingLot(road12, carMaker.getFunSized3List());
			MegaParkingLot curranParkingDeck = new MegaParkingLot(road5, road9, road10, carMaker.getRoad5Queue(), carMaker.getRoad9Queue(),
			carMaker.getRoad10Queue());
			
			int totalNumCars = carMaker.getTotalCars();
			System.out.println("Total Num Cars: " + totalNumCars);
			int numVehiclesExited = 0;
		
			/* Creates the map and starts it */
			GeorgiaTechMap map = new GeorgiaTechMap(NUMBER_OF_ITERATIONS, intersectionList, exitList);
			GeorgiaTechMap.start();
			
			/* Holds simulation until viewer has had enough time to read the description panel */
			if(NUMBER_OF_ITERATIONS == 1) {
				try {
					Thread.sleep(30000);
		    	}
		    	catch(InterruptedException ex) {
		    		Thread.currentThread().interrupt();
		    	}
			}
			
			/* Gets current start time */
			long startTime = System.currentTimeMillis();
			
			/* Runs until the number of vehicles exited is equal to the total number of cars created */
			while(numVehiclesExited < totalNumCars) {
			
				curranParkingDeck.updateRoad5();
				curranParkingDeck.updateRoad9();
				curranParkingDeck.updateRoad10();
				funSizeParkingLot1.updateRoad();
				funSizeParkingLot2.updateRoad();
				funSizeParkingLot3.updateRoad();
				
				for (Road aRoad : roadsList){
					aRoad.moveCarsForward();
					//System.out.println(aRoad.toString());	//Lets you see the cars move forward on console
				}
				/* Update the lights of each intersection one by one */
				for(Intersection intersection : intersectionList) { 
					intersection.updateQueues();
					if(intersection.shouldFlash()){
						map.paintAgain();
						try {
							Thread.sleep(250); //Simulation slows down allowing viewer to see changes in color better
											   //Place this and the sleep at line 205
											   //lower for multiple iterations if you would like to run through
											   //lots of iterations
				    	}
				    	catch(InterruptedException ex) {
				    		Thread.currentThread().interrupt();
				    	}
						map.paintAgain();
						intersection.setShouldNotFlash();
					}
				}
				/* Update the lights of each exit one by one */
				for(Exit exit : exitList) {
					exit.removeVehicle();
					if(exit.shouldFlash()) {
						map.paintAgain();
						try {
							Thread.sleep(250); //Simulation slows down allowing viewer to see changes in color better.
				    	}
				    	catch(InterruptedException ex) {
				    		Thread.currentThread().interrupt();
				    	}
						map.paintAgain();
						exit.setShouldNotFlash();
					}
				}
				/* Number of vehicles exited */
				numVehiclesExited = tenthStExit.getNumberExited() + 
						northAveExit.getNumberExited() +
						fifthStExit.getNumberExited();
			}
			long endTime = System.currentTimeMillis();
			long totalSimulationTime = (endTime - startTime)/1000;
			addValues(simulationTimes, totalNumCars, totalSimulationTime);
			
			tenthStExit.getExitedVehicles();
			northAveExit.getExitedVehicles();
			fifthStExit.getExitedVehicles();
						
			System.out.println("Have exited: " + numVehiclesExited);
			System.out.println("Total: " + totalNumCars);
			System.out.println("Time taken for "+numVehiclesExited +" to exit: "+totalSimulationTime);
		}
		 /* Useful generally for more than one simulation iteration. For 1 
		  * iteration, it'll only show one key:value pair.
		  */
		 Iterator<Integer> iterator = simulationTimes.keySet().iterator();
		 ArrayList<Long> tempList = null;
		 while(iterator.hasNext()) {
			 int key = iterator.next().intValue();
			 tempList = simulationTimes.get(key);
			 if(tempList != null) {
				 for(Long value : tempList) {
					 System.out.println("Number of Cars: " +key +" Time: " +value);
				 }
			 }
		 }
		System.out.println("---------------------END---------------------");	
	}
	
	/**
	 * Adds time values to the treemap. Useful for multiple iterations
	 * @param hashMap
	 * @param key
	 * @param value
	 */
	private static void addValues(TreeMap<Integer, ArrayList<Long>> hashMap, Integer key, Long value) {
		ArrayList<Long> tempList = null;
		if (hashMap.containsKey(key)) {
			tempList = hashMap.get(key);
			if(tempList == null) {
				tempList = new ArrayList<Long>();
			}
			tempList.add(value);  
		} 
		else {
			tempList = new ArrayList<Long>();
			tempList.add(value);               
		}
		hashMap.put(key,tempList);
	}
}
