import java.util.ArrayList;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CoinSorterGUI extends Application // inheritance from the CoinSorter class
{
	//creating test object
	ArrayList<Integer> coinList = new ArrayList<Integer>(); 
	CoinSorter t1 = new CoinSorter("GBP", 0,10000, coinList);
	
	//Scenes declaration
	Scene scene, scene2, scene3, scene4;
	
	//TextFields
	TextField userInput;
	TextField userInputM;
	TextField userInputM2;
	TextField userInputM3;
	TextField userInputM4;
	
	//Labels
	Label label1;
	Label label2;
	Label label3;
	Label label4;
	Label label5;
	Label label6;
	Label label7;
	Label label8;
	Label label9;
	Label label10;
	Label label11;
	Label label12;
	Label label13;
	
	//main menu buttons
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	//sub menu (option4) sub buttons
	Button button41;
	Button button42;
	Button button43;
	Button button44;
	//sub menu for option1
	Button calculateButton;
	Button goBack;
	//sub menu for option2
	Button calculateButton2;
	Button goBack2;
	
	int minCoinIn=0; //setting initial value
	int maxCoinIn=10000; //setting initial value

	
	public void start(Stage stage) throws Exception
	{
		//Initial settings of the coin list
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
		//Labels
		label1 = new Label ("Welcome to the CoinSorter calculator");
		label1.setLayoutX(25);
		label1.setFont(new Font("Arial", 18));
		label1.setTextFill(Color.web("#0000cc"));
		
		label5 = new Label ("Total value");
		label5.setLayoutX(200);
		label5.setLayoutY(30);
		label5.setFont(new Font("Arial", 13));
		label5.setTextFill(Color.web("#0000cc"));
		
		label6 = new Label ("Coin Denominator");
		label6.setLayoutX(400);
		label6.setLayoutY(30);
		label6.setFont(new Font("Arial", 13));
		label6.setTextFill(Color.web("#0000cc"));
		
		label7 = new Label ("Total value");
		label7.setLayoutX(200);
		label7.setLayoutY(30);
		label7.setFont(new Font("Arial", 13));
		label7.setTextFill(Color.web("#0000cc"));
		
		label8 = new Label ("Excluded Coin");
		label8.setLayoutX(400);
		label8.setLayoutY(30);
		label8.setFont(new Font("Arial", 13));
		label8.setTextFill(Color.web("#0000cc"));
		
		label9 = new Label ("Result");
		label9.setLayoutX(350);
		label9.setLayoutY(160);
		label9.setFont(new Font("Arial", 16));
		label9.setTextFill(Color.web("#DB0A0A"));
		
		label10 = new Label ("Result");
		label10.setLayoutX(350);
		label10.setLayoutY(160);
		label10.setFont(new Font("Arial", 16));
		label10.setTextFill(Color.web("#DB0A0A"));
		
		label11 = new Label ("Main Display - results of options 3 and 5 are shown below");
		label11.setLayoutX(350);
		label11.setLayoutY(160);
		label11.setFont(new Font("Arial", 13));
		label11.setTextFill(Color.web("#0000cc"));
		
		label12 = new Label ("Option 1 calculates how many coins of a certain denomination \ncan be exchanged given an input value in pennies \nand the denomination");
		label12.setLayoutX(350);
		label12.setLayoutY(30);
		label12.setFont(new Font("Arial", 13));
		label12.setTextFill(Color.web("#0000cc"));
		
		label13 = new Label ("Option 2 calculates how many coins can be exchanged given a \ntotal value and a coin type to be excluded");
		label13.setLayoutX(350);
		label13.setLayoutY(90);
		label13.setFont(new Font("Arial", 13));
		label13.setTextFill(Color.web("#0000cc"));
		
		//Title of the stage
		stage.setTitle("CoinSorter calculator");
		
		//set choiceboxes
		ChoiceBox<Integer> coinDenom = new ChoiceBox<>(); //option1 coin denominator 
		coinDenom.getItems().addAll(10,20,50,100,200);
		coinDenom.setLayoutX(400);
		coinDenom.setLayoutY(45);
		coinDenom.setMinSize(130, 20);
		
		ChoiceBox<Integer> exclCoin = new ChoiceBox<>(); //option2 excluded coin
		exclCoin.getItems().addAll(10,20,50,100,200);
		exclCoin.setLayoutX(400);
		exclCoin.setLayoutY(45);
		exclCoin.setMinSize(130, 20);
		
		//display
		TextArea display = new TextArea();        
		display.setEditable(false);         
		display.setMinSize(350,130);         
		display.setMaxSize(350,130);
		display.setLayoutX(350);
		display.setLayoutY(180);
		display.setWrapText(true);
	    
		display.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		//text field menu
		userInputM = new TextField(); // total value for option1 
		userInputM.setLayoutX(200);
		userInputM.setLayoutY(45);
		//text field3 menu
		userInputM3 = new TextField(); //total value for option2
		userInputM3.setLayoutX(200); 
		userInputM3.setLayoutY(45);
		
		// setup of the main 6 buttons and their position
		//button1 settings
		button1=new Button("1 - CoinCalculator");
		button1.setLayoutX(60);
		button1.setLayoutY(40);
		button1.setMinSize(250, 30);
		button1.setOnAction(e -> stage.setScene(scene3));
		//button2 settings
		button2=new Button("2 - Multiple coin calculator");
		button2.setLayoutX(60);
		button2.setLayoutY(90);
		button2.setMinSize(250, 30);
		button2.setOnAction(e -> stage.setScene(scene4));
		//Button3 settings
		button3=new Button("3 - Print coin list");
		button3.setLayoutX(60);
		button3.setLayoutY(140);
		button3.setMinSize(250, 30);
		button3.setOnAction( e -> {			
			display.setText(t1.printCoinList());                       
		});
		//button4 settings
		button4=new Button("4 - Set details");
		button4.setLayoutX(60);
		button4.setLayoutY(190);
		button4.setMinSize(250, 30);
		button4.setOnAction(e -> stage.setScene(scene2));
		//button5 settings
		button5=new Button("5 - Display program configurations");
		button5.setLayoutX(60);
		button5.setLayoutY(240);
		button5.setMinSize(250, 30);
		button5.setOnAction( e -> {
			display.setText(t1.displayProgramConfigs());                       
		});
		//button6 settings
		button6=new Button("6 - Quit the program");  
		button6.setLayoutX(60);
		button6.setLayoutY(290);
		button6.setMinSize(250, 30);
		button6.setOnAction( e -> Platform.exit());
		
		//group1 - to group the buttons together
		Group primaryButtons = new Group(button1, button2, button3, button4, button5, button6); 
		//group for labels in main menu
		Group labelsMenu = new Group(label1,label7,label8, label11, label12, label13);
		
		//set up the pane and get the buttons
		Pane layout = new Pane();
		layout.getChildren().addAll(primaryButtons, display, labelsMenu, exclCoin);
		
		// create and configure a scene2   
		scene = new Scene(layout, 750, 400);
		
		//settings of secondary buttons
		//button 41
		button41=new Button("1 - Set currency");
		button41.setLayoutX(250);
		button41.setLayoutY(130);
		button41.setMinSize(250, 30);
		button41.setOnAction( e -> {
			String currencyIn;
			currencyIn = userInput.getText();
			t1.setCurrency(currencyIn);;                       
		});
		//button42
		button42=new Button("2 - Set minimum coin input value");
		button42.setLayoutX(250);
		button42.setLayoutY(180);
		button42.setMinSize(250, 30);
		button42.setOnAction( e -> {
			minCoinIn = Integer.parseInt(userInput.getText());
			t1.setMinCoin(minCoinIn);;                       
		});
		//button43
		button43=new Button("3 - Set maximum coin input value");
		button43.setLayoutX(250);
		button43.setLayoutY(230);
		button43.setMinSize(250, 30);
		button43.setOnAction( e -> {
			maxCoinIn = Integer.parseInt(userInput.getText());
			t1.setMaxCoin(maxCoinIn);;                       
		});
		//button44
		button44=new Button("4 - Return to main menu");
		button44.setLayoutX(250);
		button44.setLayoutY(280);
		button44.setMinSize(250, 30);
		button44.setOnAction(e -> stage.setScene(scene));

		//text field for SubMenu
		userInput = new TextField();
		userInput.setLayoutX(300);
		userInput.setLayoutY(50);
		
		//label2
		label2 = new Label("1) Insert the desired value");
		label2.setLayoutX(300);
		label2.setLayoutY(30);
		label2 .setTextFill(Color.web("#0000cc"));
		//label3
		label3 = new Label("*** You can validate the correct input by selecting option 5 from the main menu! ***");
		label3.setLayoutX(100);
		label3.setLayoutY(350);
		label3.setFont(new Font("Arial", 15));
		label3 .setTextFill(Color.web("#0000cc"));	
		//label4
		label4 = new Label("2) Click on the correspondig button below to enter the new value");
		label4.setLayoutX(200);
		label4.setLayoutY(100);
		label4 .setTextFill(Color.web("#0000cc"));
		
		//group2 - secondary buttons
		Group secondaryButons = new Group(button41, button42, button43, button44);
		
		//group of labels
		Group labels2 = new Group (label2, label3, label4);
		
		//secondary scene layout
		Pane layout2 = new Pane();
		layout2.getChildren().addAll(secondaryButons,userInput,labels2);
		
		//****************************************************************************************************************
		// display for results of option1
		TextArea displayOp1 = new TextArea();        
		displayOp1.setEditable(false);         
		displayOp1.setMinSize(350,130);         
		displayOp1.setMaxSize(350,130);
		displayOp1.setLayoutX(190);
		displayOp1.setLayoutY(190);
		displayOp1.setWrapText(true);
	    
		displayOp1.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		//Button settings for option1 sub menu
		calculateButton = new Button("Calculate");
		calculateButton.setLayoutX(240);
		calculateButton.setLayoutY(100);
		calculateButton.setMinSize(250, 30);
		calculateButton.setOnAction( e -> {
			int exchangeValue;
			int coinType;
			exchangeValue = Integer.parseInt(userInputM.getText());
			if (exchangeValue < minCoinIn || exchangeValue > maxCoinIn)
			{
				displayOp1.setText("The total value is invalid, please make sure it is within the allowed range");
			}
			else {
				exchangeValue = Integer.parseInt(userInputM.getText());
				coinType = coinDenom.getValue(); 
				displayOp1.setText(t1.coinCalculator(exchangeValue, coinType));
			}
		});
		
		//button to go back to main menu settings
		goBack=new Button("Return to main menu");
		goBack.setLayoutX(240);
		goBack.setLayoutY(340);
		goBack.setMinSize(250, 30);
		goBack.setOnAction(e -> stage.setScene(scene));
				
		//group for sub menu of option 1
		Group labeloption1 = new Group(label5,label6);
		//creating and collect items for sub menu of option1
		Pane layout3 = new Pane();
		layout3.getChildren().addAll(calculateButton, goBack, labeloption1, coinDenom, userInputM,displayOp1, label9);
		
	//***********************************************************************************************************************
		//Display for sub menu of option2 
		TextArea displayOp2 = new TextArea();        
		displayOp2.setEditable(false);         
		displayOp2.setMinSize(350,130);         
		displayOp2.setMaxSize(350,130);
		displayOp2.setLayoutX(190);
		displayOp2.setLayoutY(190);
		displayOp2.setWrapText(true);
	    
		displayOp2.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		//Button settings for option2 sub menu
		calculateButton2 = new Button ("Calculate");
		calculateButton2.setLayoutX(240);
		calculateButton2.setLayoutY(100);
		calculateButton2.setMinSize(250, 30);
		calculateButton2.setOnAction( e -> {
			int exchangeValue2;
			int excludedCoin;
			exchangeValue2 = Integer.parseInt(userInputM3.getText());
			if (exchangeValue2 < minCoinIn || exchangeValue2 > maxCoinIn)
			{
				displayOp2.setText("The total value is invalid, please make sure it is within the allowed range");
			}
			else {
				exchangeValue2 = Integer.parseInt(userInputM3.getText());
				excludedCoin = exclCoin.getValue();  
				
				displayOp2.setText(t1.multiCoinCalculator(exchangeValue2, excludedCoin));  
			}  
		});
		
		//go back button for sub menu option2
		//button to go back to main menu settings
		goBack2=new Button("Return to main menu");
		goBack2.setLayoutX(240);
		goBack2.setLayoutY(340);
		goBack2.setMinSize(250, 30);
		goBack2.setOnAction(e -> stage.setScene(scene));
		
		// create pane layout for sub menu of option 2
		Pane layout4 = new Pane();
		layout4.getChildren().addAll(calculateButton2, displayOp2, label8, label7, exclCoin,userInputM3,goBack2, label10);
		
		//second scene
		scene2 = new Scene(layout2, 750, 400);
		//third scene for sub menu option1
		scene3 = new Scene(layout3, 750, 400);
		//forth scene for sub menu option2
		scene4 = new Scene(layout4, 750, 400);
		
		// add the scene to the stage, then set the title 
		stage.setScene(scene);
		stage.setTitle("CoinSorter calculator"); 
		
		//Show the stage
		stage.show();
		
		//set display color
		Region region = ( Region ) display.lookup( ".content" );
	    region.setBackground( new Background( new BackgroundFill( Color.LEMONCHIFFON, CornerRadii.EMPTY, Insets.EMPTY ) ) );
	    
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}

