package testing;

import map.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTests {

	@Test
	void testString1() {
		Location one = new Location(1);
		assertEquals("loc 1", one.toString());
	}
	
	@Test
	void testConnection1() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(2, one.getTaxiConnections().size());
	}
	
	@Test
	void testConnection2() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, eight.getTaxiConnections().size());
	}
	
	@Test
	void testConnection3() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, nine.getTaxiConnections().size());
	}
	

}
