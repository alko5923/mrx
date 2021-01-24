package simulate;

import map.*;
import java.util.*;

public class Detective {
	
	private int number;
	private String name;
	private int startPosition;
	private List<Relation> travelList = new ArrayList<Relation>();
	private int taxiTicketsAvailable;
	private int busTicketsAvailable;
	private int tubeTicketsAvailable;
	
	public Detective(int number, String name, int startPosition, int taxiTickets, int busTickets, int tubeTickets) {
		this.number = number;
		this.name = name;
		this.startPosition = startPosition;
		this.taxiTicketsAvailable = taxiTickets;
		this.busTicketsAvailable = busTickets;
		this.tubeTicketsAvailable = tubeTickets;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public List<Relation> getTravelList() {
		return travelList;
	}
	
	public void removeDetectiveTaxiTicket() {
		taxiTicketsAvailable -= 1;
	}
	
	public void removeDetectiveBusTicket() {
		busTicketsAvailable -= 1;
	}
	
	public void removeDetectiveTubeTicket() {
		tubeTicketsAvailable -= 1;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------\n");
		sb.append("DETECTIVE " + name + " INFO\n");
		sb.append("---------------------------------\n");
		sb.append("Start position: " + startPosition + "\n");
		sb.append("Travel list: [ "); 
		for (int i = 0; i < travelList.size(); i+=1 ) {
			sb.append(travelList.get(i).toString());
			sb.append(", ");
		}
		sb.append(" ]\n");
		sb.append("Taxi tickets available = "); 
		sb.append(taxiTicketsAvailable);
		sb.append("\nBus tickets available = "); 
		sb.append(busTicketsAvailable);
		sb.append("\nTube tickets available = "); 
		sb.append(tubeTicketsAvailable);
		sb.append("\n---------------------------------\n");
		return sb.toString();
	}
	
}
