package simulate;

import map.*;
import java.util.*;

public class Detective {
	
	private int number;
	private String name;
	private int startPosition;
	private List<Relation> travelList = new ArrayList<Relation>();
	private List<String> availableTickets = new ArrayList<String>();
	
	public Detective(int number, String name, int startPosition) {
		this.number = number;
		this.name = name;
		this.startPosition = startPosition;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------\n");
		sb.append("Detective info: \n");
		sb.append("Detective nr. " + number + "\n");
		sb.append("Detective name: " + name + "\n");
		sb.append("Detective start position: " + startPosition + "\n");
		sb.append("Detective travel list: [ "); 
		for (int i = 0; i < travelList.size(); i+=1 ) {
			sb.append(travelList.get(i).toString());
			sb.append(", ");
		}
		sb.append(" ]\n");
		sb.append("Available tickets: [ "); 
		for (int i = 0; i < availableTickets.size(); i+=1 ) {
			sb.append(availableTickets.get(i).toString());
			sb.append(", ");
		}
		sb.append(" ]\n");
		sb.append("---------------------------------\n");
		return sb.toString();
	}
	
}
