package map;

public class BusConnection extends Relation {
	
	Location loc1;
	Location loc2;
	
	public BusConnection(Location loc1, Location loc2) {
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public boolean isBusConnection() {
		return true;
	}
	
	
}