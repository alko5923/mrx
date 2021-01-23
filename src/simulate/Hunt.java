package simulate;

import java.util.Scanner;

import map.*;


public class Hunt {
	
	private static Scanner sc = new Scanner(System.in);
	private static int moves = 24;
	private static int mrXLocation;
	
	public static void main(String[] args) throws InterruptedException, LocationNotFoundException {
		
		Hunter hunter = new Hunter();
		
		System.out.println("Welcome to The Hunt for Mr X, the codebreaker for the game Scotland Yard!\n");
		
		try 
		{
			hunter.setupGame();
		}
		catch (EmptyMapException m){
			System.err.println("Empty map! " + m.getMessage());
			return;
		}
		
		for(int step = 0; step < moves; step+=1) {
			
			System.out.println(" ***** Move nr. " + (step+1) + " *****\n");
			hunter.moveMrX();
			
			if (step == 2) {
				System.out.println("Mr. X, reveal yourself!\n");
				System.out.println("Where is Mr. X at the moment?\n");
				mrXLocation = sc.nextInt();
				hunter.getSetup().getMrX().addToReveals(mrXLocation);
				System.out.println("Current location of Mr. X: " + mrXLocation + "\n");
			}
			
			if (step == 7) {
				System.out.println("Mr. X, reveal yourself!\n");
				System.out.println("Where is Mr. X at the moment?\n");
				mrXLocation = sc.nextInt();
				hunter.getSetup().getMrX().addToReveals(mrXLocation);
				System.out.println("Current location of Mr. X: " + mrXLocation + "\n");
			}
			
			if (step == 12) {
				System.out.println("Mr. X, reveal yourself!\n");
				System.out.println("Where is Mr. X at the moment?\n");
				mrXLocation = sc.nextInt();
				hunter.getSetup().getMrX().addToReveals(mrXLocation);
				System.out.println("Current location of Mr. X: " + mrXLocation + "\n");
			}
			
			if (step == 17) {
				System.out.println("Mr. X, reveal yourself!\n");
				System.out.println("Where is Mr. X at the moment?\n");
				mrXLocation = sc.nextInt();
				hunter.getSetup().getMrX().addToReveals(mrXLocation);
				System.out.println("Current location of Mr. X: " + mrXLocation + "\n");
			}
			
			if (step == 23) {
				System.out.println("Mr. X, reveal yourself!\n");
				System.out.println("Where is Mr. X at the moment?\n");
				mrXLocation = sc.nextInt();
				hunter.getSetup().getMrX().addToReveals(mrXLocation);
				System.out.println("Current location of Mr. X: " + mrXLocation + "\n");
			}
			
			hunter.moveDetectives();
			
			System.out.println(hunter);
		}
			
	}
}
