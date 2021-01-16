package map;
import java.util.*;



public class Location {
	private int name; 
	private List<Location> taxiConnections = new ArrayList<Location>();
	private List<Location> busConnections = new ArrayList<Location>();
	private List<Location> tubeConnections = new ArrayList<Location>();
	
	public Location(int name) {
		this.name = name;
	}
	
	public void addTaxiConnection(Location loc) {
		this.taxiConnections.add(loc);
		loc.taxiConnections.add(this);
	}
	
	public void addBusConnection(Location loc) {
		this.busConnections.add(loc);
		loc.busConnections.add(this);
	}
	
	public void addTubeConnection(Location loc) {
		this.tubeConnections.add(loc);
		loc.tubeConnections.add(this);
	}
	
	public List<Location> getTaxiConnections() {
		return this.taxiConnections;
	}
	
	public List<Location> getBusConnections() {
		return this.busConnections;
	}
	
	public List<Location> getTubeConnections() {
		return this.tubeConnections;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("loc ");
		sb.append(this.name);
		return sb.toString();
	}
	

}
