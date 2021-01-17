package map;

public class TubeConnection extends Relation {
	
	Location loc1;
	Location loc2;
	
	public TubeConnection(Location loc1, Location loc2) {
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public boolean isTubeConnection() {
		return true;
	}
	
}