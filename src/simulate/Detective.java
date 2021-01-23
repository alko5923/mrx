package simulate;

public class Detective {
	
	private int number;
	private String name;
	
	public Detective(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Detective info: \n");
		sb.append("Detective nr. " + number + "\n");
		sb.append("Detective name: " + name + "\n");
		return sb.toString();
	}
	
}
