package map;

import java.util.*;

/*
 * An Environment is a HasMap using location names as keys, and locations as values.
 */

public class Environment extends HashMap<Integer, Location> {
	
	static private Scanner sc = new Scanner(System.in);
	
	public void addTaxiConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTaxiConnection(this.get(destLoc));
				}
			}
		catch (NullPointerException m) {
		System.out.print("Station does not exist!\n");
        System.out.println(m.getMessage());
        }
			
	}
	
	public void addBusConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addBusConnection(this.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
	
	public void addTubeConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTubeConnection(this.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
	
	public void createMap() {
		System.out.println("How many stations does your map have?");
		int nrLocations = sc.nextInt();
		if (nrLocations == 0) {
			System.out.println("OK, goodbye then!");
		}
		else {
			for (int i = 1; i < nrLocations+1; i+=1) {
				Location loc = new Location(i);
				this.put(i, loc);
			}
		}
	}
	
	public void populateMap() {
		
		System.out.println("OK, let's begin with location 1: ");
		
		for(int locationNr = 1; locationNr < this.size()+1; locationNr +=1) {
			Location loc = this.get(locationNr);
			System.out.println("Please enter the number of taxi connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int taxiNr = sc.nextInt();
			addTaxiConnections(loc, taxiNr);
			System.out.println("Please enter the number of bus connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int busNr = sc.nextInt();
			addBusConnections(loc, busNr);
			System.out.println("Please enter the number of tube connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int tubeNr = sc.nextInt();
			addTubeConnections(loc, tubeNr);
		}

	}
				
	
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
