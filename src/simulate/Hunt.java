package simulate;

import map.*;
import java.util.*;

// TODO: save the initialized map to a file, so you don't have to initialize it every time you run the program 

public class Hunt {

	static private Scanner sc = new Scanner(System.in);
	static private int numberOfDetectives;
	static private int numberOfPolice;
	static private List<Integer> startPosDetectives = new ArrayList<Integer>();
	static private List<Integer> startPosPolice = new ArrayList<Integer>();
	static Environment newMap = new Environment();
	
	
	static void addTaxiConnections (Environment map, Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTaxiConnection(map.get(destLoc));
				}
			}
		catch (NullPointerException m) {
		System.out.print("Station does not exist!\n");
        System.out.println(m.getMessage());
        }
			
	}
	
	static void addBusConnections (Environment map, Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addBusConnection(map.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
	
	static void addTubeConnections (Environment map, Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTubeConnection(map.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
	
	static void createMap (Environment map) {
		System.out.println("How many stations does your map have?");
		int nrLocations = sc.nextInt();
		if (nrLocations == 0) {
			System.out.println("OK, goodbye then!");
		}
		else {
			for (int i = 1; i < nrLocations+1; i+=1) {
				Location loc = new Location(i);
				map.put(i, loc);
			}
		}
	}
	
	static void populateMap (Environment map) {
		
		System.out.println("OK, let's begin with location 1: ");
		
		for(int locationNr = 1; locationNr < map.size()+1; locationNr +=1) {
			Location loc = map.get(locationNr);
			System.out.println("Please enter the number of taxi connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int taxiNr = sc.nextInt();
			addTaxiConnections(map, loc, taxiNr);
			System.out.println("Please enter the number of bus connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int busNr = sc.nextInt();
			addBusConnections(map, loc, busNr);
			System.out.println("Please enter the number of tube connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int tubeNr = sc.nextInt();
			addTubeConnections(map, loc, tubeNr);
		}

	}
				
	
	
	public static int getDetectives() {
		while(true) {
			System.out.println("Please enter the number of detectives: ");
			numberOfDetectives = sc.nextInt();
			if(numberOfDetectives > 5) {
				System.out.println("The max number of detectives is 5!");
				continue;
			}
			else if(numberOfDetectives < 2) {
				System.out.println("The min number of detectives is 2!");
				continue;
			}
			else {
				return numberOfDetectives;
			}
		}
	}
	
	public static int getPolice(int numberOfDetectives) {
		if (numberOfDetectives == 2) {
			numberOfPolice = 2;
			System.out.println("You get 2 police officers as backup help.");
			return numberOfPolice;
		}
		else if (numberOfDetectives == 3) {
			numberOfPolice = 1;
			System.out.println("You get 1 police officer as backup help.");
			return numberOfPolice;
		}
		else {
			numberOfPolice = 0;
			System.out.println("You get no police officers as backup help.");
			return numberOfPolice;
		}
	}
	
	public static List<Integer> getStartPosDetectives(int numberOfDetectives) {
		for(int i = 1; i < numberOfDetectives+1; i+=1) {
			System.out.println("Start location of detective nr. " + i);
			int detectiveStartPosition = sc.nextInt();
			startPosDetectives.add(detectiveStartPosition);
			System.out.println("Start location of detective nr. " + i + ": " + detectiveStartPosition);
		}
		return startPosDetectives;
	}
	
	public static List<Integer> getStartPosPolice(int numberOfPolice) {
		for(int i = 1; i < numberOfPolice+1; i+=1) {
			System.out.println("Start location of police officer nr. " + i);
			int policeStartPosition = sc.nextInt();
			startPosPolice.add(policeStartPosition);
			System.out.println("Start location of police officer nr. " + i + ": " + policeStartPosition);
		}
		return startPosPolice;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to The Hunt for Mr X, the codebreaker for the game Scotland Yard!");
		
		while(true) {
			
			try {
				createMap(newMap);
				populateMap(newMap);
				System.out.println(newMap);
				
				numberOfDetectives = getDetectives();
				System.out.println(numberOfDetectives + " detectives");
				numberOfPolice = getPolice(numberOfDetectives);
				
				startPosDetectives = getStartPosDetectives(numberOfDetectives);
				startPosPolice = getStartPosPolice(numberOfPolice);
			}
			
			catch(IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
			
			finally {
				sc.close();
			}
			break;
			
		}

	}

}
