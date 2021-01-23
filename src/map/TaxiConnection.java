package map;

public class TaxiConnection extends Relation {
	
	private static final long serialVersionUID = 3L;
	
	private Location loc1;
	private Location loc2;
	
	public TaxiConnection(Location loc1, Location loc2) {
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public boolean isTaxiConnection() {
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("taxi from ");
		sb.append(loc1.getName());
		sb.append(" to ");
		sb.append(loc2.getName());
		return sb.toString();
	}
}
