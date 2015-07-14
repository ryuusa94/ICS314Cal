package CalAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit_Event
 * @author TeamElara
 * Testing class for Event
 */
public class JUnit_Event {

	/**
	 * testing setStart called with time zone info during file writing
	 */
	@Test
	public void setStartTZtest() {
		Event testEvent = new Event();
		//testing with time zone
		Interface.setTzInfo(true);
		testEvent.setStart("20150710", "1500", "Pacific");
		assertEquals("DTSTART;TZID=Pacific:20150710T150000\r\n" , testEvent.getEventStartTime());		
	}
	
	/**
	 * testing setStart called without time zone info during file writing
	 */
	@Test
	public void setStartNoTZtest() {
		Event testEvent2 = new Event();
		//testing without time zone
		Interface.setTzInfo(false);
		testEvent2.setStart("20150710", "1500", null);
		assertEquals("DTSTART:20150710T150000\r\n" , testEvent2.getEventStartTime());		
	}
	
	/**
	 * Testing setStart called during file reading
	 */
	@Test
	public void setStartReadTest() {
		Event testEvent3 = new Event();
		//testing with time zone		
		testEvent3.setStart("TZID=Pacific:20150710T150000");
		assertEquals("DTSTART;TZID=Pacific:20150710T150000\r\n" , testEvent3.getEventStartTime());		
	}

}
