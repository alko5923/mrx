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
				Location loc1 = new Location(1, "bus", "taxi", "tube");
				Location loc9 = new Location(9, "taxi");
				Location loc8 = new Location(8, "taxi");
				Location loc46 = new Location(46, "bus, taxi, tube");
				System.out.println(loc1);
				System.out.println(loc9);
				System.out.println(loc8);
				Connection con19 = new Connection(loc1, loc9, "taxi");
				System.out.println(con19);
				Connection con18 = new Connection(loc1, loc8, "taxi");
				System.out.println(con18);
				Connection con146 = new Connection(loc1, loc46, "bus");
				System.out.println(con146);
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
