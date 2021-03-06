package map;

public class TubeConnection extends Relation {
	
	private static final long serialVersionUID = 4L;
	
	private Location loc1;
	private Location loc2;
	
	public TubeConnection(Location loc1, Location loc2) {
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public Location getLoc1() {
		return this.loc1;
	}
	
	public Location getLoc2() {
		return this.loc2;
	}
	
	public boolean isTubeConnection() {
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("tube from ");
		sb.append(loc1.getName());
		sb.append(" to ");
		sb.append(loc2.getName());
		return sb.toString();
	}
}