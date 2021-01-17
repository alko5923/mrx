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
		assertEquals(2, one.getConnections().size());
	}
	
	@Test
	void testConnection2() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, eight.getConnections().size());
	}
	
	@Test
	void testConnection3() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, nine.getConnections().size());
	}
	
	@Test
	void testConnection4() { 
		Location one = new Location(1);
		Location fiftyeight = new Location(58);
		one.addBusConnection(fiftyeight);
		assertEquals(1, fiftyeight.getConnections().size());
	}
	
	@Test
	void testConnection5() { 
		Location one = new Location(1);
		Location fiftyeight = new Location(58);
		Location fortysix = new Location(46);
		fiftyeight.addBusConnection(one);
		one.addBusConnection(fortysix);
		fortysix.addBusConnection(fiftyeight);
		
		Location eight = new Location(8);
		eight.addTaxiConnection(one);
		one.addTubeConnection(fortysix);
		
		assertEquals(4, one.getConnections().size());
		assertEquals(3, fortysix.getConnections().size());
		assertEquals(2, fiftyeight.getConnections().size());
	}
	
	@Test
	void testConnection6() { 
		Location one = new Location(1);
		Location fiftyeight = new Location(58);
		Location fortysix = new Location(46);
		fiftyeight.addBusConnection(one);
		one.addBusConnection(fortysix);
		fortysix.addBusConnection(fiftyeight);
		
		Location eight = new Location(8);
		eight.addTaxiConnection(one);
		one.addTubeConnection(fortysix);
		
		assertEquals(true, one.getConnections().get(3).isTubeConnection());
		assertEquals(true, one.getConnections().get(2).isTaxiConnection());
		assertEquals(true, one.getConnections().get(1).isBusConnection());
		assertEquals(true, one.getConnections().get(0).isBusConnection());
	}
	

}
