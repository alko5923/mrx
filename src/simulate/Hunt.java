package simulate;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Hunt {

	public static void main(String[] args) {
		System.out.println("Welcome to Mr X, the codebreaker for the game Scotland Yard!");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			
			System.out.println("Please enter the number of players: ");
			
			try {
				int numberOfPlayers = sc.nextInt();
				System.out.println("The number of players is" + " " + numberOfPlayers);
			}
			
			catch(IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
			
			finally {
				sc.close();
			}
			break;
			
			
		}
		
		

	}

}
