package map;

import java.util.*;

/*
 * A Map is a HasMap using location names as keys, and locations as values.
 */

public class Environment extends HashMap<Integer, Location> {
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Locations and their connections: ");
		TreeSet<Integer> locations = new TreeSet<Integer>(this.keySet());
		Iterator<Integer> iter = locations.iterator();
		while(iter.hasNext()) {
			Integer loc = iter.next();
			sb.append(this.get(loc));
			sb.append("; ");
			sb.append(System.lineSeparator());
		}
		sb.deleteCharAt(sb.length()-2);	
		return sb.toString();
	}
	
}
