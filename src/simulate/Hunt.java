package simulate;

import map.*;
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
				System.out.println(numberOfPlayers + " players");
				Location loc1 = new Location(1, "bus", "taxi", "underground");
				System.out.println(loc1);
				Location loc2 = new Location(2, "taxi");
				System.out.println(loc2);
				Connection con12 = new Connection(loc1, loc2, "taxi");
				System.out.println(con12);
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
