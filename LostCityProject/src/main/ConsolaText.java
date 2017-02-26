package main;

public class ConsolaText {

	//Rules of the game and instructions
	
	public void displayRules(){
		
		System.out.println("We can score from 1 to 7.");
		System.out.println("For that we are going to use a random dice generator.");
		System.out.println("As a user we have the chance to throw the dice twice");
		System.out.println("If the Ai score less then 6 ,it will throw the second dice automatically.");
		System.out.println("Wins who has a better scored, but not more then 10.");
		System.out.println("If both players score above 10, then is a draw.");
		System.out.println("Who won the round is receiving the first district from his opponent list.");
	}
	
}
