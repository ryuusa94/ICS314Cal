package CalAssignment;

import java.util.Iterator;

/**
 * AddComment
 * @author TeamElara
 * Adds COMMENT field to event with distance to next event
 */
public class AddComment {

	/**
	 * addComment, iterates through arraylist of events, calling GreatCircle
	 * when geographic positions are available.
	 */
	/**
	 * addComment, iterates through arraylist of events, calling GreatCircle
	 * when geographic positions are available.
	 * @param cal, calendar object generated at time of reading
	 */
	public void addComment(CalObj cal) {
		
		GreatCircle gc = new GreatCircle();
	
		Iterator<Event> itr = cal.getEventArray().iterator();
		
		int eCount = 0;
		
		while(itr.hasNext()) {
			
			itr.next();

			if (eCount > 0) {
				Event previous = cal.getEventArray().get(eCount - 1);
				Event current = cal.getEventArray().get(eCount);
				
				
				if(previous.getEventGeoPos() != null && current.getEventGeoPos() != null) {
					String[] geo1 = previous.getEventGeoPos().split("[:;]");
					String[] geo2 = current.getEventGeoPos().split("[:;]");
					
					double lat1 = Double.parseDouble(geo1[1]);
					double long1 = Double.parseDouble(geo1[2]);
					double lat2 = Double.parseDouble(geo2[1]);
					double long2 = Double.parseDouble(geo1[2]);
					
					//sets previous event's comment section with distance to current event
					previous.setComment(gc.miles(lat1, long1, lat2, long2), 
							gc.km(lat1, long1, lat2, long2));
					
					//testing only
					System.out.println("Added to " + previous.getEventSummary() + previous.getEventComment());
				}
			}

			eCount++;
		}
	}
}
