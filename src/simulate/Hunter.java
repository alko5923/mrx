package simulate;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import map.*;

public class Hunter {
	
	private Scanner sc = new Scanner(System.in);
	private Setup setup = new Setup();
	
	//private List<String> ticketsUsed = new ArrayList<String>();
	//private List<Location> mrXReveals = new ArrayList<Location>();
	
	public Setup getSetup() {
		return this.setup;
	}
	
	public void setupGame() throws EmptyMapException {
		setup.setupDemo();
	}
	
	public void moveMrX() {
		System.out.println("\nOK, Mr. X moves ...\n");
		boolean waitingForMrX = true;
		
		while(waitingForMrX) {
			System.out.println("\nPress x when Mr. X has moved ...\n");
			String answer = sc.next();
			if(answer.equals("x")) {
				waitingForMrX = false;
				System.out.println("Mr X has moved!\n");
			}
		}
		System.out.println("What ticket has Mr. X used? \n");
		String ticketUsed = sc.next();
		this.setup.getMrX().addToUsedTickets(ticketUsed);
	}
	
	public Relation calculateBestMove(Detective detective) {
		Relation bestMove = setup.getMap().getMap().get(1).getConnections().get(0);
		
		return bestMove;
	}
	
	public void moveDetectives() {
		for(int i = 0; i < setup.getNrOfDetectives(); i += 1) {
			Detective detective = setup.getListDetectives().get(i);
			Relation bestMove = calculateBestMove(detective);
			System.out.println("Detective " + setup.getListDetectives().get(i).getName()
					+ " please take " + bestMove + "\n");
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The current state of affairs: \n");
		// print all detectives
		for (int i = 0; i < setup.getNrOfDetectives(); i+=1) {
			sb.append(setup.getListDetectives().get(i).toString());
		}
		// TODO: refactor this once you have created a Mr. X class 
		sb.append(" === Mr. X === ");
		sb.append(setup.getMrX().toString());
		return sb.toString();
	}
	
}
