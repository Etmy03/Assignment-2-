/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This program generates a random number and asks the user to guess the number. 
 * 				It prompts the user to enter numbers between 0 and 100, and with each guess, 
 * 				the range of possible guesses becomes smaller and smaller.
 * Due: 6/30/2023
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Etmy Barbosa
*/

import java.util.Scanner;
public class RandomNumberGuesser {

	public static void main(String[] args) {
		int num = 1;
		int rNum; //random number;
		int userNum; //user's guess
		String play = "yes"; //used to save the user answer to replaying the game
		RNG user;
		boolean bound = true;
		
		Scanner in = new Scanner(System.in);
		
		
		do {
			//step 1
			user = new RNG();
			rNum = user.rand();
			play = "yes";
			
			//step 2
			int lowerNum = 0;
			int higherNum = 100;
			
			//step 3
			System.out.println("Enter your first guess ");
			userNum = in.nextInt();
			
			user.resetCount();
			
			while((play.equals("yes"))){
				
				//step 4 (need the variable count)
				bound = user.inputValidation(userNum, lowerNum, higherNum);
				if(!bound) {
					userNum = in.nextInt();
					
				}
				
				//step 6
				else if(userNum>rNum) {
					System.out.println("Number of guesses is " + user.getCount());
					System.out.println("Your guess is too high");
					higherNum = userNum;
					System.out.println("Enter your next guess between " + lowerNum + " and " + higherNum);
					userNum = in.nextInt();
				}
				
				//step 7
				else if(userNum<rNum) {
					System.out.println("Number of guesses is " + user.getCount());
					System.out.println("Your guess is too low");
					lowerNum = userNum;
					System.out.println("Enter your next guess between " + lowerNum + " and " + higherNum);
					userNum = in.nextInt();
				}
				//step 5
				else if(userNum == rNum) {
					System.out.println("Congratulations, you guessed correctly");
					System.out.println("Try again? (yes or no)");
					in.nextLine();
					play = in.nextLine();
					//System.out.println(play);
					if(!(in.nextLine()).equals("yes") ){
						play = "no";
					}
				}
			}
		}while(!(play.equals("no"))); // part of step 4/c-d 	
		System.out.println("Thanks for playing...");
		System.out.println("Etmy Barbosa");
	}
}
