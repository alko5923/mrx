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
		trackMrX();
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
	
	
	public void trackMrX() {
		// add every location in the map that isn't occupied to the Tracker
		// for each of those locations, loop through the location's connections
		// every connection that doesn't include an occupied location, add to the list 
		
		Environment map = setup.getMap().getMap();
		MrXTracker tracker = setup.getMrX().getTracker();
		TreeSet<Integer> locations = new TreeSet<Integer>(map.keySet());
		Iterator<Integer> iter = locations.iterator();
		while(iter.hasNext()) {
			int locInt = iter.next();
			Location loc = map.get(locInt);
			List<Relation> locPossibleMoves = new ArrayList<Relation>();
			
			if(loc.isOccupied()==false) {
				for(int j = 0; j < loc.getConnections().size(); j+=1) {
					Relation connection = loc.getConnections().get(j);
					if(connection.getLoc1().isOccupied()==false && connection.getLoc2().isOccupied()==false) {
						locPossibleMoves.add(connection);
					}
				}
				tracker.put(loc, locPossibleMoves);
			}
		}
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
	
	//TODO(high): implement the Mr. X tracker 
	
	public Relation calculateBestMove(int detectiveIndex) {
		//Location start = setup.getMap().getMap().get(1);
		Relation bestMove = setup.getMap().getMap().get(1).getConnections().get(0);

		handleStatistics(bestMove, detectiveIndex);
		return bestMove;
	}
	
	
	public boolean noMovesLeftCheck() {
		if(setup.getMrX().getTracker().size() == 0) {
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
	
	public boolean move() {
		trackMrX();
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
		sb.append(setup.getMap().getMap().toString());
		return sb.toString();
	}
	
}
