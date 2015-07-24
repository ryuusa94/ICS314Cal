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
		testCal.read("calBW1400geo.ics");
		testCal.read("calCR1430geo.ics");
		testCal.read("calSF2100geo.ics");
		
		Event event1 = testCal.getEventArray().get(0);		
		Event event2 = testCal.getEventArray().get(1);
		Event event3 = testCal.getEventArray().get(2);
		
		AddComment ac = new AddComment();
		ac.addComment(testCal);
		
		assertEquals("COMMENT:Distance to your next event is: 1.38 miles, 2.22 km\r\n", event1.getEventComment());
		assertEquals("COMMENT:Distance to your next event is: 2.07 miles, 3.33 km\r\n", event2.getEventComment());
		assertEquals(null, event3.getEventComment());	
	}	
}
