package map;

import java.io.IOException;

public class Relation implements java.io.Serializable  {
	
	static final long serialVersionUID = 41L;
	
	public boolean isTaxiConnection() {
		return false;
	}
	
	public boolean isBusConnection() {
		return false;
	}
	
	public boolean isTubeConnection() {
		return false;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        
    }
	
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        
    }
	
	private void readObjectNoData() throws java.io.ObjectStreamException {
        System.out.println("No data!");
    }
	
}
