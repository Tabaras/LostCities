package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import entity.CompareClass;
import entity.Kingdom;
import entity.Residence;
import entity.Town;
import players.Ai;
import players.HumanUser;

public class App {
	CompareClass c = new CompareClass();
	HumanUser user = new HumanUser();
	Ai computer = new Ai();
	boolean showInstructions = true;
	Integer opt;
	private Scanner s;
	private boolean runningApp = true;

	// Main method
	public void run() {
		
			while (showInstructions) {
			System.out.println("Starting application");
			System.out.println("(1)Main rules!");
			System.out.println("(2)User districts.");
			System.out.println("(3)Ai districts.");
			System.out.println("(4)Start game.");
			opt = readInstructions();
			switch (opt) {
			case 1:
				initGame();
				break;
			case 2:
				displayUserDistricts();
				break;
			case 3:
				displayAiDistricts();
				break;
			case 4:
				System.out.println("EXIT instruction menu!");
				showInstructions = false;
				break;
			default:
				System.out.println("Wrong input!!");
			}// end switch statement
		} // end while

		
		mainAction();
	}// end void run method

	public void initGame() {
		ConsolaText consola = new ConsolaText();
		consola.displayRules();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	// user display districts
	public void displayUserDistricts() {
		System.out.println("User districts available!");
		Collections.sort(user.getUserDistricts(), c);
		for (Kingdom elem : user.getUserDistricts()) {
			System.out.println(elem);

		} // end enhance for loop
		
	}// end displayUserDistricts method

	// ai display districts method
	public void displayAiDistricts() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Ai districts available!");
		Collections.sort(computer.getAiDistricts(), c);
		for (Kingdom elem : computer.getAiDistricts()) {
			System.out.println(elem);
		}
	}// end method

	public Integer readInstructions() {
		Integer opt;
		s = new Scanner(System.in);
		System.out.println("Choose an option!");
		opt = s.nextInt();
		return opt;
	}// end method

	public Integer userAction() {
		// we throw a dice, dice value is between 1 and 7
		// we can use another dice if we want, but if we score above 10 we'll
		// lose
		Scanner s = new Scanner(System.in);
		Integer totalSum = 0;
		Random userRandom = new Random();
		Integer firstDice = userRandom.nextInt(7) + 1;
		System.out.println("First dice: " + (totalSum += firstDice));
		System.out.println(
				"You can roll the dice one more time, but if the sum of both dices is greater then 10, you lose");
		System.out.println("Yes or No.");
		String answer = s.nextLine();
		if (answer.equalsIgnoreCase("Yes")) {
			Integer secondDice = userRandom.nextInt(7) + 1;
			System.out.println("Second dice value is: " + secondDice);
			System.out.println("Sum of both throws: " + (totalSum += secondDice));
			if (totalSum > 10) {
				return 0;
			}
			return totalSum;
		} else {
			System.out.println("You scored :" + (firstDice));

			return firstDice;
		}

	}// end method userAction

	// AI action method
	public Integer aiAction() {
		//if the first dice is less then six, throw the second dice 
		//if the both throws > 10 the ai has lost, and will return 0
		//if the first dice == 7, return first dice
		Integer totalSum = 0;
		Random aiRandom = new Random();
		Integer firstDice = aiRandom.nextInt(7) + 1;
		System.out.println("First dice: " + (totalSum += firstDice));
		if (firstDice < 6) {
			Integer secondDice = aiRandom.nextInt(7) + 1;
			System.out.println("Second dice value is: " + secondDice);
			System.out.println("Sum of both throws: " + (totalSum += secondDice));
			if(totalSum > 10){
				return 0;
				
			}
			return totalSum;
		} else {
			System.out.println("Ai scored :" + (firstDice));
			return firstDice;
		}

	}//end aiAction method

	public void mainAction() {
		Kingdom d;
		Residence residence;
		Town town;
		Integer userScore = 0;
		Integer aiScore = 0;
		System.out.println("Please choose a name: ");
		String userName = s.next();
		user.setUserName(userName);

		while (runningApp) {
			
			Collections.shuffle(user.getUserDistricts());
			Collections.shuffle(computer.getAiDistricts());
			System.out.println("Press Yes to continue playing.");
			String press = s.next();

			if (press.equalsIgnoreCase("Yes")) {

				userScore = userAction();
				System.out.println("User final score is: \n" + userScore);
				System.out.println();
				aiScore = aiAction();
				System.out.println("Ai final score is: \n" + aiScore);

				if (userScore > aiScore) {
					d = computer.getAiDistricts().get(0);
					if (d instanceof Residence) {
						residence = (Residence) d;
						System.out.println("Residence lost value: " + residence.getNumberOfPoints()
								+ " residence name: " + residence.getName());
								
					} else if (d instanceof Town) {
						town = (Town) d;
						System.out.println(
								"Town lost value: " + town.getNumberOfPoints() + " town name: " + town.getName());
					} // end else if
					computer.getAiDistricts().remove(d);
					user.getUserDistricts().add(d);

				} else if (userScore < aiScore) {
					d = user.getUserDistricts().get(0);
					if (d instanceof Residence) {
						residence = (Residence) d;
						System.out.println("Residence lost value: " + residence.getNumberOfPoints()
								+ " residence name: " + residence.getName());
					} else if (d instanceof Town) {
						town = (Town) d;
						System.out.println(
								"Town lost value: " + town.getNumberOfPoints() + " town name: " + town.getName());
					}
					user.getUserDistricts().remove(d);
					computer.getAiDistricts().add(d);

				} else if (userScore == aiScore) {
					System.out.println("Draw game!!");
				}
				// test
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("User array iteration.");
				for (Kingdom district : user.getUserDistricts()) {
					System.out.print(district + " \n");
					
				}

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Ai array iteration");
				for (Kingdom district : computer.getAiDistricts()) {
					System.out.println(district + " ");
					
				}
				if (userScore > aiScore) {
					System.out.println("The user has won a new District!!!!!!!!!!!");
				} else if(aiScore> userScore){
					System.out.println("The ai has won a new District!!!!!!!!!!!!!");
				}else
					System.out.println("Nobody won, draw!");
			} // end main if
			int userCounter = user.getUserDistricts().size();
			int aiCounter = computer.getAiDistricts().size();
			System.out.println("User has: " + userCounter + " districts left.");
					
			System.out.println("Ai has: " + aiCounter + " districts left." );
			

			if (userCounter == 0) {
				System.out.println("AI won all the available Districts.");
				runningApp = false;
			} else if (aiCounter == 0) {
				System.out.println(user.getUserName() + " won the game.");
				runningApp = false;
			}

		}
		
	}
	
	
}
