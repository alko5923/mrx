package simulate;

import java.util.*;

import map.Location;
import map.Relation;

/* 
 * A hashmap storing all possible locations of Mr. X (key) with a list of all possible moves
 * from those locations (value)
 */ 

public class MrXTracker extends HashMap<Location, List<Relation>> {
	
	//TODO(high): fix this!
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tracker size = " + this.size() + "\n");
		sb.append("-------------------------------------------------------\n");
		sb.append(" MR X POSSIBLE LOCATIONS WITH POSSIBLE MOVES FROM THEM    \n");
		sb.append("-------------------------------------------------------\n");
		TreeSet<Location> locs = new TreeSet<Location>(this.keySet());
		Iterator<Location> iter = locs.iterator();
		while(iter.hasNext()) {
			Location loc = iter.next();
			sb.append("LOCATION " + loc.getName()+":\n");
			List<Relation> possibleMoves = this.get(loc);
			//sb.append(System.lineSeparator());
			for (int i = 0; i < possibleMoves.size(); i+=1) {
				sb.append(possibleMoves.get(i));
				sb.append(", ");
				sb.append("\n");
			}
		}
		
		//sb.deleteCharAt(sb.length()-2);	
		//sb.append("------------------------------------\n");
		return sb.toString();
	}

}
