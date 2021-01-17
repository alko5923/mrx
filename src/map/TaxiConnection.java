package map;

public class TaxiConnection extends Relation {
	
	Location loc1;
	Location loc2;
	
	public TaxiConnection(Location loc1, Location loc2) {
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public boolean isTaxiConnection() {
		return true;
	}
	
}
