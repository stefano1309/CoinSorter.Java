import java.util.ArrayList;
import java.util.Scanner;

public class testCoinSorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> coinList = new ArrayList<Integer>(); 
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
		CoinSorter t1 = new CoinSorter("GBP", 0,10000, coinList);
		
		char choice;
		char choice2;	
		int exchangeValue;
		int coinType;
		int excludedCoin;
		int exchangeValue2;
		Scanner sc = new Scanner(System.in);
		int [] someArray;
		System.out.println("***Coin Sorter - Main Menu***");
		//menu below
		do
		{
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			choice = sc.next().charAt(0);
			
			//switch below
			switch (choice)
			{
			case '1': 	t1.validateTotalCoinValue();
						System.out.println("Kindly enter again the above confirmed value");
						exchangeValue = sc.nextInt();
						System.out.println("Indicate the coin type (10,20,50,100,200) for the calculation");	
						coinType = sc.nextInt();
						System.out.println("");
						System.out.println(t1.coinCalculator(exchangeValue, coinType));
						System.out.println("");	 
						break;
			case '2': 	Scanner sc5 = new Scanner(System.in);
						t1.validateExcludedCoin();
						System.out.println("Kindly enter again the above confirmed value");
						excludedCoin = sc5.nextInt();
						System.out.println("Indicate the value for the calculation");
						exchangeValue2 = sc5.nextInt();
						System.out.println("");
						System.out.println(t1.multiCoinCalculator(exchangeValue2, excludedCoin));
						System.out.println("");
						break;
			case '3': 	System.out.println("");
						System.out.println(t1.printCoinList());
						System.out.println("");
						break;

			case '4': 	do {
							System.out.println("***Set Details Sub-Menu***");
							System.out.println("1 - Set currency");
							System.out.println("2 - Set minimum coin input value");
							System.out.println("3 - Set maximum coin input value");
							System.out.println("4 - Return to main menu");
							choice2 = sc.next().charAt(0); 
							//switch menu
							switch(choice2) 
							{
							case '1': String currencyIn;
									  Scanner sc2 = new Scanner(System.in);
									  System.out.println("enter a value to set the currency: ");
									  currencyIn = sc2.next();
									  t1.setCurrency(currencyIn);
									  break;
							case '2': int minCoinIn;
								      Scanner sc3 = new Scanner(System.in);
									  System.out.println("enter the minimum coin value: ");
									  minCoinIn = sc3.nextInt();
									  t1.setMinCoin(minCoinIn);
									  break;
							case '3': int maxCoinIn;
							  		  Scanner sc4 = new Scanner(System.in);
							          System.out.println("enter the maximum coin value: ");		
							          maxCoinIn= sc4.nextInt();
							          t1.setMaxCoin(maxCoinIn);
									  break;
			
							}
							} while (choice2 !='4');
						break;
			case '5': 	System.out.println("");
						System.out.println(t1.displayProgramConfigs());
						System.out.println("");
						break;

			}
		} while (choice != '6');
		System.out.println("exiting, goodbye!");
	}

}
