import java.util.stream.IntStream;

import net.nullschool.util.DigitalRandom;
/**
 * API for Digital Random Number Generator Library developed by Cameron Baccario
 * Interfaces with Intel's DRNG rdnand instruction to generate random values based 
 * on the thermal entropy from the silicon of the CPU
 *
 */
public class DRNG 
{
	private DigitalRandom random;
	
	/**
	 * Creates a new DigitalRandom object
	 */
	public DRNG() {
		random = new DigitalRandom();
	}
	
	/**
	 * Gets a random integer within a certain upper bound
	 * @param upperBound
	 * @return
	 */
	public int getRandomInt(int upperBound) {
		return random.nextInt(upperBound);
	}
	
	/**
	 * Simply gets the next random integer, no bound selected
	 * @return
	 */
	public int getRandomInt() {
		return random.nextInt();
	}
	
	/**
	 * Gets a random integer within a certain lower and upper bound
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public int getRandomInt(int lowerBound, int upperBound) {
		return random.nextInt(lowerBound, upperBound);
	}
	
	/**
	 * Gets an array of random integers within a certain upper and lower bound
	 * @param numberOfRandomValues
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public int[] getRandomInts(int numberOfRandomValues, int lowerBound, int upperBound) {
		IntStream stream = random.ints(numberOfRandomValues, lowerBound, upperBound+1);
		return stream.toArray();
	}
	
	/**
	 * Tests that DRNG works
	 * @param args
	 */
	public static void main(String[] args) {
		DRNG generator = new DRNG();
		
		final int UPPERBOUND = 100;
		final int LOWERBOUND = 1;
		final int NUMBER_OF_RANDOM_VALUES = 100;
		
		System.out.println("============RANDOM NUMBER GENERATION TEST=============");
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println("RANDOM VALUE " + (i+1) +": " +generator.getRandomInt());
		}
		
		System.out.println("============UPPER BOUND TEST=============");
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println("RANDOM VALUE " + (i+1) +": " +generator.getRandomInt(UPPERBOUND));
		}
		
		System.out.println("============LOWER AND UPPER BOUND TEST=============");
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println("RANDOM VALUE " + (i+1) +": " +generator.getRandomInt(LOWERBOUND, UPPERBOUND));
		}
		
		System.out.println("============ARRAY OF VALUES TEST=============");
		int[] array = generator.getRandomInts(NUMBER_OF_RANDOM_VALUES, LOWERBOUND, UPPERBOUND);
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println("RANDOM VALUE " + (i+1) +": " +array[i]);
		}
		
		System.out.println("============ARRAY OF VALUES TEST (100, 1, 10)=============");
		int[] randomArray1 = generator.getRandomInts(NUMBER_OF_RANDOM_VALUES, LOWERBOUND, 10);
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println(randomArray1[i]);
		}
		
		System.out.println("============ARRAY OF VALUES TEST (100, 1, 30)=============");
		int[] randomArray2 = generator.getRandomInts(NUMBER_OF_RANDOM_VALUES, LOWERBOUND, 30);
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println(randomArray2[i]);
		}
		
		System.out.println("============ARRAY OF VALUES TEST (100, 1, 50)=============");
		int[] randomArray3 = generator.getRandomInts(NUMBER_OF_RANDOM_VALUES, LOWERBOUND, 50);
		for(int i = 0; i < NUMBER_OF_RANDOM_VALUES; i++) {
			System.out.println(randomArray3[i]);
		}
	}
}
