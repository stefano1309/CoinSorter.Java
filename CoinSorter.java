import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

/* This program will have the functions of sorting coins give an user input.
 * Author Stefano Karov
 * On date 25.9.2020
 */


public class CoinSorter {

	// Set the attributes as per UML diagram provided in the instructions for this assessment 
	private String currency;
	private int minCoin; // min value in p is 0
	private int maxCoin; // max value in p is 10K
	private int totalCoinValue; // value of p to be used for the operation
	private int excludedCoin;  // type of coin to be excluded from the operation
	private List<Integer> coinList; //10p,20p,50p,1Pound,2Pounds 

	// List of operations as indicated in the UML 
	public CoinSorter (String currencyIn, int minCoinIn, int maxCoinIn, List<Integer> coinListIn) {    // constructor
		currency = currencyIn;
		minCoin = minCoinIn;
		maxCoin = maxCoinIn;
		coinList = coinListIn;
	}
	
	public CoinSorter() { // empty constructor 
		minCoin = 0; 
	    maxCoin = 10000; 
	    totalCoinValue = 0; 
	    excludedCoin = -1; 
	    coinList = new ArrayList<Integer>(); 
	
	}
	public void setCurrency(String currencyIn) { // user can input the currency value
		currency=currencyIn;
	}
	public void setMinCoin(int minCoinIn) {  //to input minCoin value
		minCoin=minCoinIn;
	}
	public void setMaxCoin(int maxCoinIn) { // to input maxCoin value
		maxCoin=maxCoinIn;
	}
	// getters below
	public String getCurrency() {  // this method returns the currency value when the user asks for it
		return currency;
	}
	public int MinCoinIn()  
	{
		return minCoin;
	}
	public int MaxCoinIn() 
	{
		return maxCoin;
	}
	public String printCoinList()
	{
		return "The current coin denominations are in circulation: " + coinList;
	}
	public void validateTotalCoinValue() // to validate whether the use input is within the right range of allowed values
	{
		int exchangeValue;
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Please enter the total coins value: "); 
		exchangeValue = keyboard.nextInt();
		while (exchangeValue < 0 || exchangeValue>10000)
		{
			System.out.println("Invalid input! total coin value should range between 0 and 10'000! please enter a new value");
			exchangeValue = keyboard.nextInt();
		}
		if (exchangeValue > 0 || exchangeValue < 10000)
		{
			System.out.println("We confirm that the value you have entered is valid.");
		}
	
	}
	public void validateExcludedCoin() // to validate whether the excluded coin chosen by user is allowed
	{
		int userExcludedCoin;
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Please enter the excluded coin value (10,20,50,100,200)p"); 
		userExcludedCoin = keyboard.nextInt();
		while (!(userExcludedCoin == 10 || userExcludedCoin == 20 || userExcludedCoin == 50 || userExcludedCoin == 100 || userExcludedCoin == 200))
		{
			System.out.println("Invalid input! excluded coin value should be one of the following (10,20,50,100,200)p");
			userExcludedCoin = keyboard.nextInt();
		}
		if (userExcludedCoin == 10 || userExcludedCoin == 20 || userExcludedCoin == 50 || userExcludedCoin == 100 || userExcludedCoin == 200); 
		{
			System.out.println("We confirm that the value you have entered is valid.");
		}
	}
	public String coinCalculator(int exchangeValue, int coinType)
	{
		int value1;
		int remainder;
		value1= exchangeValue/coinType;
		remainder = exchangeValue%coinType;
		return "A total of " + value1 + " x " + coinType + "p coins can be exchanged, with a remainder  of " + remainder + "p";
	}
	public String multiCoinCalculator(int exchangeValue2, int excludedCoin)
	{

			List<Integer> excludedList = new ArrayList<>(coinList); // copy the original list and exclude user's input
			excludedList.remove(new Integer (excludedCoin));
			//do calculations
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<excludedList.size(); i++)		
				{int numb;
				numb=exchangeValue2/excludedList.get(i);
				exchangeValue2-=numb*excludedList.get(i);
				sb.append(numb + " " + "x "+ excludedList.get(i) + "p, ");
				}
			
				return  "The coins exchanged are: " + sb.toString() + "With a remainder of: " + exchangeValue2 +"p" ;
	}
	public String displayProgramConfigs()
	{
		return "The currency is set to: " + currency + ", the minimum coin value is set to: " + minCoin + ", the max coin value is set to: "+ maxCoin;
	}
}

