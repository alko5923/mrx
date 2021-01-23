package map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Map {
	
	private Scanner sc = new Scanner(System.in);
	private Environment newMap = new Environment();
	
	public Environment getMap() {
		return this.newMap;
	}
	
	public Environment loadMap() throws EmptyMapException {
		try {
			File file = new File("map.ser");
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			newMap = (Environment)in.readObject();
			in.close();
			}
		catch (FileNotFoundException m) {
			System.out.println("File not found, proceeding to create map ...");
			createMap();
			
			if (newMap.size() > 0) {
				populateMap();
			}
			else {
				throw new EmptyMapException();
			}
		}
		catch (IOException m) {
			m.printStackTrace();
		}
		catch (ClassNotFoundException m) {
			System.out.println("Class not found!");
			m.printStackTrace();
		}
		return newMap;
	}
	
	public Environment createMap() throws EmptyMapException {
		System.out.println("How many stations does your map have?");
		int nrLocations = sc.nextInt();
		if (nrLocations == 0) {
			System.out.println("OK, goodbye then!");
			throw new EmptyMapException();
		}
		else {
			for (int i = 1; i < nrLocations+1; i+=1) {
				Location loc = new Location(i);
				newMap.put(i, loc);
			}
		}
		return newMap;
	}
	
	public void populateMap() {
		
		System.out.println("OK, let's begin with location 1: ");
		
		for(int locationNr = 1; locationNr < newMap.size()+1; locationNr +=1) {
			Location loc = newMap.get(locationNr);
			System.out.println("Please enter the number of TAXI connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int taxiNr = sc.nextInt();
			addTaxiConnections(loc, taxiNr);
			System.out.println("Please enter the number of BUS connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int busNr = sc.nextInt();
			addBusConnections(loc, busNr);
			System.out.println("Please enter the number of TUBE connections from station " 
					+ locationNr + " to HIGHER ranked stations: ");
			int tubeNr = sc.nextInt();
			addTubeConnections(loc, tubeNr);
		}
		writeMap();
	}
	
	public Environment writeMap() {
		try {
			File file = new File("map.ser");  
			FileOutputStream f = new FileOutputStream(file);  
			ObjectOutputStream m = new ObjectOutputStream(f);          
			m.writeObject(newMap);
			m.flush();
			m.close();
		}
		catch (IOException m) {
			m.printStackTrace();
		}
		return newMap;
	}
	
	// TODO(low): implement option to try again in case you input non-existing station nr. 
	// TODO(low): implement Are you sure? after you input every connection
	// TODO(low): implement check if destination location is a higher nr. than start location
	
	public void addTaxiConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTaxiConnection(newMap.get(destLoc));
				}
			}
		catch (NullPointerException m) {
		System.out.print("Station does not exist!\n");
        System.out.println(m.getMessage());
        }
			
	}
	
	public void addBusConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addBusConnection(newMap.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
	
	public void addTubeConnections (Location loc, int nrConnections) {
		try {
			for (int i = 0; i < nrConnections; i+=1) {
				System.out.println("Please enter destination location: ");
				int destLoc = sc.nextInt();
				loc.addTubeConnection(newMap.get(destLoc));
				}
		}
		catch (NullPointerException m) {
			System.out.print("Station does not exist!\n");
	        System.out.println(m.getMessage());
		}
	}
}
