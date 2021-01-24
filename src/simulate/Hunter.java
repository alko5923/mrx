package simulate;

import java.util.*;
import map.*;

public class Hunter {
	
	private Scanner sc = new Scanner(System.in);
	private Setup setup = new Setup();
	
	
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
			System.out.println("Press x when Mr. X has moved ...\n");
			String answer = sc.next();
			if(answer.equals("x")) {
				waitingForMrX = false;
				System.out.println("\nMr X has moved!\n");
			}
		}
		System.out.println("What ticket has Mr. X used? \n");
		String ticketUsed = sc.next();
		this.setup.getMrX().addToUsedTickets(ticketUsed);
		removeXticket(ticketUsed);
	}
	
	public void removeXticket(String ticket) {
		if (ticket.equals("taxi")) {
			setup.getMrX().removeXTaxiTicket();
		}
		else if (ticket.equals("bus")) {
			setup.getMrX().removeXBusTicket();
		}
		else if (ticket.equals("tube")) {
			setup.getMrX().removeXTubeTicket();
		}
	}
	
	public Relation calculateBestMove(int detectiveIndex) {
		//Location start = setup.getMap().getMap().get(1);
		Relation bestMove = setup.getMap().getMap().get(1).getConnections().get(0);

		handleStatistics(bestMove, detectiveIndex);
		return bestMove;
	}
	
	
	public boolean noMovesLeftCheck() {
		if(setup.getMrX().getPossibleXMovesLocations().size() == 0) {
			System.out.println(" *** Mr. X GOT CAUGHT! ***\n");
			return true;
		}
		return false;
	}
	
	public void handleStatistics(Relation bestMove, int detectiveIndex) {
		
		Detective detective = setup.getListDetectives().get(detectiveIndex);
		
		if(bestMove.isTaxiConnection()) {
			detective.removeDetectiveTaxiTicket();
			setup.getMrX().addTaxiTicket();
		}
		else if(bestMove.isBusConnection()) {
			detective.removeDetectiveBusTicket();
			setup.getMrX().addBusTicket();
		}
		else if(bestMove.isTubeConnection()) {
			detective.removeDetectiveTubeTicket();
			setup.getMrX().addTubeTicket();
		}
		
		detective.getTravelList().add(bestMove);	
	}
	
	public void moveDetectives() {
		for(int i = 0; i < setup.getNrOfDetectives(); i += 1) {
			Relation bestMove = calculateBestMove(i);
			System.out.println("\nDetective " + setup.getListDetectives().get(i).getName()
					+ " please take " + bestMove);
		}
	}
	
	public void reveal(int mrXLocation) throws LocationNotFoundException {
		this.getSetup().getMrX().addToReveals(mrXLocation);
	}
	
	public void mrXPossibleMoves() {
		// check what locations in hashmap are not occupied
		// add all Relations of those locations
		// make an occupied function for Locations? 
		
	}
	
	public boolean move() {
		if(noMovesLeftCheck() == true) {
			return false;
		}
		moveMrX();
		moveDetectives();
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------\n");
		sb.append("THE CURRENT STATE OF AFFAIRS\n");
		sb.append("---------------------------------\n");
		// print all detectives
		for (int i = 0; i < setup.getNrOfDetectives(); i+=1) {
			sb.append(setup.getListDetectives().get(i).toString());
		}
		
		sb.append(setup.getMrX().toString());
		return sb.toString();
	}
	
}
