package testing;

import map.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTests {

	@Test
	void testString1() {
		Location one = new Location(1);
		assertEquals("loc 1 has no connections.", one.toString());
	}

	
	@Test
	// testing if the right number of connections gets added / YES
	void testConnection1() { 
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(2, one.getConnections().size());
	}
	
	@Test
	// testing if the right number of connections gets added / YES
	void testConnection2() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, eight.getConnections().size());
	}
	
	@Test
	// testing if the right number of connections gets added / YES
	void testConnection3() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location nine = new Location(9);
		one.addTaxiConnection(eight);
		one.addTaxiConnection(nine);
		assertEquals(1, nine.getConnections().size());
	}
	
	@Test
	// testing if the right number of connections gets added / YES
	void testConnection4() { 
		Location one = new Location(1);
		Location fiftyeight = new Location(58);
		one.addBusConnection(fiftyeight);
		assertEquals(1, fiftyeight.getConnections().size());
	}
	
	@Test
	// testing if the right number of connections gets added / YES
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
	// testing if the right types of connections get registered / YES 
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
	
	
	@Test 
	// testing for equality of connections: is taxi connection btw loc 1 and 2, 
	// registered at location 1 equal to taxi connection btw loc 1 and 2 registered at location 2? / YES
	void testConnection7() {
		Location one = new Location(1);
		Location eight = new Location(8);
		one.addTaxiConnection(eight);
		List<Relation> con1 = one.getConnections();
		List<Relation> con2 = eight.getConnections();
		assertEquals(true, con1.get(0).isTaxiConnection());
		assertEquals(con1.get(0), con2.get(0));
	}
	
	@Test 
	// testing for equality of connections: is taxi connection btw loc 1 and 2, 
	// equal to taxi connection btw loc 2 and 1? / NO
	void testConnection8() {
		Location one = new Location(1);
		Location eight = new Location(8);
		one.addTaxiConnection(eight);
		eight.addTaxiConnection(one);
		List<Relation> con1 = one.getConnections();
		List<Relation> con2 = eight.getConnections();
		assertEquals(2, one.getConnections().size());
		assertEquals(2, eight.getConnections().size());
		assertNotEquals(one.getConnections().get(0), one.getConnections().get(1));
	}
	
	// tests for toString()
	@Test
	void testConnection9() {
		Location one = new Location(1);
		Location eight = new Location(8);
		Location fortysix = new Location(46);
		one.addTaxiConnection(eight);
		one.addBusConnection(fortysix);
		fortysix.addTubeConnection(one);
		assertEquals("loc 1 has these connections: taxi from 1 to 8, bus from 1 to 46, tube from 46 to 1 ", one.toString());
		assertEquals("loc 8 has these connections: taxi from 1 to 8 ", eight.toString());
		assertEquals("loc 46 has these connections: bus from 1 to 46, tube from 46 to 1 ", fortysix.toString());
	}
	
	// TODO: after writing and initializing the map, write tests for it 
	
}
