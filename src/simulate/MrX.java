package simulate;


import java.util.ArrayList;
import java.util.List;
import map.*;


public class MrX {
	private int taxiTicketsAvailable = 1;
	private int busTicketsAvailable;
	private int tubeTicketsAvailable;
	private List<String> ticketsUsed = new ArrayList<String>();
	private List<Location> mrXReveals = new ArrayList<Location>();
	private Map map;
	
	public MrX(Map newMap) {
		this.map = newMap;
	}
	
	public void addToReveals(int location) throws LocationNotFoundException {
		if(map.getMap().containsKey(location)) {
			Location loc = map.getMap().get(location);
			mrXReveals.add(loc);
		}
		else {
			throw new LocationNotFoundException();
		}
	}
	
	public void removeXTaxiTicket() {
		taxiTicketsAvailable -= 1;
	}
	
	public void removeXBusTicket() {
		busTicketsAvailable -= 1;
	}
	
	public void removeXTubeTicket() {
		tubeTicketsAvailable -= 1;
	}
	
	public void addToUsedTickets(String ticket) {
		ticketsUsed.add(ticket);
	}
	
	public void addTaxiTicket() {
		taxiTicketsAvailable+=1;
	}
	
	public void addBusTicket() {
		busTicketsAvailable+=1;
	}
	
	public void addTubeTicket() {
		tubeTicketsAvailable+=1;
	}
	
	public String toString() {
			
			StringBuilder sb = new StringBuilder();
			sb.append("---------------------------------\n");
			sb.append("     *** MR X INFO ***     \n");
			sb.append("---------------------------------\n");
			
			sb.append("Taxi tickets available = "); 
			sb.append(String.valueOf(taxiTicketsAvailable));
			sb.append("\nBus tickets available = ");
			sb.append(String.valueOf(busTicketsAvailable));
			sb.append("\nTube tickets available = ");
			sb.append(String.valueOf(tubeTicketsAvailable));
			
			sb.append("\nMr. X used tickets: [ "); 
			for (int i = 0; i < ticketsUsed.size(); i+=1 ) {
				sb.append(ticketsUsed.get(i));
				sb.append(", ");
			}
			sb.append(" ]\n");
			
			sb.append("Mr. X reveal list: [ "); 
			for (int i = 0; i < mrXReveals.size(); i+=1 ) {
				sb.append(mrXReveals.get(i).getName());
				sb.append(", ");
			}
			sb.append(" ]\n");
			
			
			sb.append("---------------------------------\n");
			
			return sb.toString();
		}
	
}
