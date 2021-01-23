package map;

import java.util.*;

/*
 * An Environment is a HasMap using location names as keys, and locations as values.
 */

public class Environment extends HashMap<Integer, Location> implements java.io.Serializable {
	
	private static final long serialVersionUID = 6L;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Locations and their connections: \n");
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
