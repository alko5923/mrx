package map;

public class LocationNotFoundException extends Exception {
	public LocationNotFoundException() {
			super("Location does not exist!");
		}
}
