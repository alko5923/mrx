package map;

public class Location {
	private int name; 
	private int numberOfStations;
	private String[] transportation;
	
	public Location(int name, String... transportation) {
		this.name = name;
		this.transportation = new String[transportation.length];
        for (int i = 0; i < transportation.length; ++i) {
            this.transportation[i] = transportation[i].toString();
        }
        this.numberOfStations = transportation.length;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Location ");
		sb.append(this.name);
		sb.append(" has stations: ");
		for (int i = 0; i < transportation.length; ++i) {
			sb.append(this.transportation[i]);
	        sb.append(" ");
	        }
		return sb.toString();
	}

}
