/**
 * 
 */
package CalAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit_AddComment
 * @author TeamElara
 * testing class for AddComment
 */
public class JUnit_AddComment {

	/**
	 * testAddComment, reads events, then calls AddComment
	 */
	@Test
	public void testAddComment() {
		
		CalObj testCal = new CalObj();
		testCal.read("calendarBW.ics");
		testCal.read("calendarSF.ics");
		testCal.read("calendarCR.ics");
		
		Event event1 = testCal.getEventArray().get(0);		
		Event event2 = testCal.getEventArray().get(1);
		Event event3 = testCal.getEventArray().get(2);
		
		AddComment ac = new AddComment();
		ac.addComment(testCal);
		
		assertEquals("COMMENT:Distance to your next event is: 7.67 miles, 12.35 km\r\n", event1.getEventComment());
		assertEquals("COMMENT:Distance to your next event is: 53.7 miles, 86.42 km\r\n", event2.getEventComment());
		assertEquals(null, event3.getEventComment());	
	}	
}
