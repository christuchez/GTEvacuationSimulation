/**
 * Calculates the chi square values to test the bias on our DRNG
 *
 */
public class ChiSquareTest {

	private int[] data;
	private int ceiling;
	private int bins[];
	/**
	 * Initializes the bins and data arrays
	 * @param data
	 * @param ceiling
	 */
	public ChiSquareTest(int[] data, int ceiling){
		this.data = data;
		this.ceiling = ceiling;
		bins = new int[ceiling + 1];
	}
	
	/**
	 * Adds data to bins so that we can determine the number of occurences of each value
	 */
	private void putDataInBins(){  //puts the data into bins
		for(int binNumber = 1; binNumber <= ceiling; binNumber++){ //does not count 0s
			int counter = 0;                                       //0 bin is empty
			for(int oneData = 0; oneData <= (data.length - 1); oneData++){
				if(binNumber == data[oneData]){
					counter = counter + 1; 
				}
			}
			bins[binNumber] = counter;
			System.out.println("bins["+binNumber+"]" + " = " + counter);
		}
	}
	/**
	 * Calculates the value of chi square based on the Chi Square Formula
	 * 				--       --
	 *              | (O-E)^2 | 
	 *  X^2 =  SUMOF| ------- |
	 *              |    E    |
	 *              --       --
	 * @return
	 */
	public double getChiSquare(){
		double chiSquare = 0;
		putDataInBins();                                
		double expected = data.length/ceiling;    //if there is 100 samples <= 10 then we expect
		                                         // 10 1's, 10 2's, 10 3's...
		for(int i = 1; i <= ceiling; i++){      
			double observed = bins[i];
			double obsMinusExp = observed - expected;
			chiSquare = chiSquare + ((Math.pow(obsMinusExp, 2))/expected); //square and divide
		}
		return chiSquare;
	}
	

	/**
	 * Tests that the chi squared test works
	 * @param args
	 */
	public static void main( String[] args){
		int[] underOrEqual10 = {5,4,8,8,1,5,7,6,2,10,7,1,3,8,6,6,2,2,3,10,10,9,2,7,
				    			2,2,1,5,2,4,2,9,10,4,8,6,8,7,4,1,6,4,9,1,4,9,4,5,7,
				    			8,4,7,7,10,2,10,4,1,5,6,5,7,7,6,3,3,8,4,9,7,9,10,6,
				    			3,3,3,1,7,10,8,6,8,2,9,6,8,2,5,2,4,7,9,4,2,9,4,5,2,3,8};
		
		
		int[] underOrEqual30 = {19,11,24,26,23,4,25,20,12,28,16,11,14,4,26,26,26,12,29,
				                29,30,22,10,26,5,2,6,24,2,12,16,11,8,20,11,17,23,18,11,
				                6,3,28,9,17,18,25,21,2,24,17,16,12,29,3,8,10,12,30,30,16,
				                1,15,24,29,23,19,18,2,16,5,27,6,4,18,4,30,22,14,27,19,23,
				                30,18,24,10,7,3,8,13,5,16,18,15,12,6,15,11,3,2,17};

				
		int[] underOrEqual50 = {38,47,6,32,4,37,45,8,11,21,43,39,38,10,36,29,9,30,18,17,
								36,16,17,18,12,33,6,15,32,31,17,11,39,3,38,40,37,22,26,7,
								14,43,40,11,49,17,35,28,18,44,7,16,43,3,30,21,10,9,28,12,
								23,32,47,33,40,2,33,2,3,4,23,28,22,11,43,31,23,46,3,14,44,
								10,16,49,45,16,31,13,18,22,35,37,41,17,27,29,42,16,47,39};
		
		
		ChiSquareTest theTest = new ChiSquareTest(underOrEqual10, 10); 
		double chiSquare = theTest.getChiSquare();                     
		System.out.println("Chi Square Measure is: " + chiSquare);
		
		ChiSquareTest theTest2 = new ChiSquareTest(underOrEqual30, 10); 
		double chiSquare2 = theTest2.getChiSquare();                     
		System.out.println("Chi Square Measure is: " + chiSquare2);
		
		ChiSquareTest theTest3 = new ChiSquareTest(underOrEqual50, 10); 
		double chiSquare3 = theTest3.getChiSquare();                     
		System.out.println("Chi Square Measure is: " + chiSquare3);
		
		//for 10: 5.2
		//for 30: 27.99
		//for 50: 45		
	}
	
}
