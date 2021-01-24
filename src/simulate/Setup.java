package simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import map.*;

public class Setup {
	
	private Scanner sc = new Scanner(System.in);
	private Map newMap = new Map();
	private int numberOfDetectives;
	private int numberOfPolice;
	private MrX mrX = new MrX(newMap);	
	private List<Detective> listDetectives = new ArrayList<Detective>();

	// TODO: remove startPosPolice once you have refactored code
	private List<Integer> startPosPolice = new ArrayList<Integer>();
	
	
	public MrX getMrX() {
		return mrX;
	}
	
	public Map getMap() {
		return newMap;
	}
	
	public int getNrOfDetectives() {
		return this.numberOfDetectives;
	}
	
	public List<Detective> getListDetectives() {
		return this.listDetectives;
	}
	
	public int setupDetectives() {
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
				for (int number = 1; number < numberOfDetectives+1; number+=1) {
					System.out.println("Name of detective nr. " + number + ": ");
					String nameDetective = sc.next();
					
					System.out.println("Please give start location of detective " + nameDetective + ":");
					int startPos = sc.nextInt();
					
					System.out.println("How many taxi tickets does the detective have?");
					int taxiTickets = sc.nextInt();
					System.out.println("How many bus tickets does the detective have?");
					int busTickets = sc.nextInt();
					System.out.println("How many tube tickets does the detective have?");
					int tubeTickets = sc.nextInt();
					
					createDetective(number, nameDetective, startPos, taxiTickets, busTickets, tubeTickets);
				}
				return numberOfDetectives;
			}
		}
	}

	
	//TODO(low): add check for setting a detective on non-existing station or already occupied station
	public Detective createDetective(int number, String name, int startPosition, int taxiTickets, int busTickets, int tubeTickets) {
		Detective newDetective = new Detective(number, name, startPosition, taxiTickets, busTickets, tubeTickets);
		listDetectives.add(newDetective);
		return newDetective;
	}
	
	public int setupPolice(int numberOfDetectives) {
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
	
	
	// TODO(low): refactor this into one function (setupPolice()) and 
	// add check for setting a police officer on non-existing station or already occupied station 
	
	public List<Integer> setupStartPosPolice(int numberOfPolice) {
		for(int i = 1; i < numberOfPolice+1; i+=1) {
			System.out.println("Start location of police officer nr. " + i);
			int policeStartPosition = sc.nextInt();
			startPosPolice.add(policeStartPosition);
			System.out.println("Start location of police officer nr. " + i + ": " + policeStartPosition);
		}
		return startPosPolice;
	}
	

	public void setupFullGame() {
		System.out.println(newMap.getMap());
		
		numberOfDetectives = setupDetectives();
		numberOfPolice = setupPolice(numberOfDetectives);
		
		startPosPolice = setupStartPosPolice(numberOfPolice);
	}
	
	public void setupDemo() throws EmptyMapException {
		
		newMap.loadMap();
		System.out.println(newMap.getMap());
	
		numberOfDetectives = setupDetectives();
		/*
		for (int i = 0; i < listDetectives.size(); i+=1) {
			System.out.println(listDetectives.get(i));
		}
		*/
	}
	
	
}
