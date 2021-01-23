package simulate;


import java.util.ArrayList;
import java.util.List;
import map.*;


public class MrX {
	private List<String> ticketsAvailable = new ArrayList<String>();
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
	
	public void addToUsedTickets(String ticket) {
		ticketsUsed.add(ticket);
	}
	
	public void addToTicketsAvailable(String ticket) {
		ticketsAvailable.add(ticket);
	}
	
	public String toString() {
			
			StringBuilder sb = new StringBuilder();
			sb.append("---------------------------------\n");
			sb.append("Mr. X info: \n");
			
			sb.append("Mr. X reveal list: [ "); 
			for (int i = 0; i < mrXReveals.size(); i+=1 ) {
				sb.append(mrXReveals.get(i).getName());
				sb.append(", ");
			}
			sb.append(" ]\n");
			
			sb.append("Mr. X available tickets: [ "); 
			for (int i = 0; i < ticketsAvailable.size(); i+=1 ) {
				sb.append(ticketsAvailable.get(i));
				sb.append(", ");
			}
			sb.append(" ]\n");
			
			sb.append("Mr. X used tickets: [ "); 
			for (int i = 0; i < ticketsUsed.size(); i+=1 ) {
				sb.append(ticketsUsed.get(i));
				sb.append(", ");
			}
			sb.append(" ]\n");
			sb.append("---------------------------------\n");
			
			return sb.toString();
		}
	
}
