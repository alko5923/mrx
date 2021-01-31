package map;
import java.util.*;
import java.io.IOException;

public class Location implements java.io.Serializable, Comparable<Location> {
	
	private static final long serialVersionUID = 1L;
	
	private int name; 
	private List<Relation> connections = new ArrayList<Relation>();
	private boolean occupied;
	
	public Location(int name) {
		this.name = name;
		this.occupied = false;
	}
	
	public String getName() {
		String name = String.valueOf(this.name);
		return name;
	}
	
	public void occupyLocation() {
		this.occupied = true;
	}
	
	public boolean isOccupied() {
		return this.occupied;
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
		List<Relation> connections = this.getConnections();
		int connections_size = connections.size();
		if (connections_size == 0) {
			sb.append(" has no connections.");
			return sb.toString();
		}
		else {
			sb.append(" has these connections: ");
			for(int i = 0; i < connections.size(); i+=1) {
				sb.append(connections.get(i).toString());
				sb.append(", ");
			}
			sb.deleteCharAt(sb.length()-2);
		}
		sb.append("\noccupied: " + occupied);
		
		return sb.toString();
	}
	
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        stream.writeInt(name);
        stream.writeObject(connections);
    }
	
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        name = stream.readInt();
        connections = (List<Relation>) stream.readObject();
    }
	
	private void readObjectNoData() throws java.io.ObjectStreamException {
        System.out.println("No data!");
    }

	@Override
	public boolean equals(Object loc) {
		if(this == loc) {
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Location loc) {
		if(this.equals(loc)) {
			return 0;
		}
		return -1;
	}
	
}
