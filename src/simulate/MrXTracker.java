package simulate;

import java.util.*;

import map.Location;
import map.Relation;

/* 
 * A hashmap storing all possible locations of Mr. X (key) with a list of all possible moves
 * from those locations (value)
 */ 

public class MrXTracker extends HashMap<Location, List<Relation>> {
	
	//TODO(high): finish the toString() function
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------------------------------------\n");
		sb.append(" MR X POSSIBLE LOCATIONS WITH POSSIBLE MOVES FROM THEM    \n");
		sb.append("-------------------------------------------------------\n");
		sb.append("Locations and their connections: \n");
		TreeSet<Location> locations = new TreeSet<Location>(this.keySet());
		Iterator<Location> iter = locations.iterator();
		while(iter.hasNext()) {
			Location loc = iter.next();
			sb.append(loc.toString());
			sb.append("; ");
			sb.append(System.lineSeparator());
		}
		
		sb.deleteCharAt(sb.length()-2);	
		sb.append("-------------------------------------------------------\n");
		return sb.toString();
	}

}
