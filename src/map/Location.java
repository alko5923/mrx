package map;
import java.util.*;


public class Location {
	private int name; 
	private List<Relation> connections = new ArrayList<Relation>();
	
	public Location(int name) {
		this.name = name;
	}
	
	public void addTaxiConnection(Location loc) {
		final TaxiConnection taxi = new TaxiConnection(this, loc);
		this.connections.add(taxi);
		loc.connections.add(taxi);
	}
	
	public void addBusConnection(Location loc) {
		final BusConnection bus = new BusConnection(this, loc);
		this.connections.add(bus);
		loc.connections.add(bus);
	}
	
	public void addTubeConnection(Location loc) {
		final TubeConnection tube = new TubeConnection(this, loc);
		this.connections.add(tube);
		loc.connections.add(tube);
	}
	
	public List<Relation> getConnections() {
		return this.connections;
	}
	

	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("loc ");
		sb.append(this.name);
		return sb.toString();
	}
	

}
