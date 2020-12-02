package map;

public class Connection {
	private Location start;
	private Location end;
	private String type; 
	
	public Connection(Location start, Location end, String type) {
		this.start = start;
		this.end = end;
		this.type = type;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Connection ");
		sb.append("from ");
		sb.append(this.start);
		sb.append(" to ");
		sb.append(this.end);
		sb.append(" and vice versa.");
		return sb.toString();
	}
	
}
