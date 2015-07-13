package CalAssignment;

/**
 * Event
 * class Event
 * @author TeamElara
 *
 */
public class Event {
	private String eventSummary, 
		eventStartTime, 
		eventEndTime,
		eventUid, 
		eventTimezone, // we either need to put this in automatically, or ask user to put in (optional or mandatory)
		// if asking, see RFC 5545 page 27 section 3.2.19 Time Zone Identifier at https://tools.ietf.org/html/rfc5545#section-3.2.19
		// TZID=America/New_York is appended after DTSTART;, precedes the time (I think).
		// so code has to be flexible so that we can throw the time zone inbetween DTSTART and the entered time 
		// (i.e., private variables eventStartTime and eventEndTime being String ArrayList or something so we can push inbetween their contents)
		// essentially, TZID for timezone is an extra parameter of DTSTART start time, not its own specification
		eventGeoPos, 
		eventClass,
		eventComment;
	
	public void setSummary(String summary){
		eventSummary = new StringBuilder()
			.append("SUMMARY:")
			.append(summary)
			.append("\r\n")
		.toString();
	}
	
	/**
	 * setStart, sets start time, including time zone if provided.
	 * Uses tzInfo boolean from Interface to determine whether user
	 * has provided time zone information, and thus which items to append.
	 * @param date, user set date
	 * @param time, user set time
	 * @param tz, user set time zone
	 */
	public void setStart(String date, String time, String tz){
		if(Interface.getTzInfo()) {
			eventStartTime = new StringBuilder()
			.append("DTSTART;")
			.append("TZID=")
			.append(tz)
			.append(":")
			.append(date)
			.append("T")
			.append(time)
			.append("00")
			.append("\r\n")
		.toString();
		} else { 
			eventStartTime = new StringBuilder()
			.append("DTSTART:")
			.append(date)
			.append("T")
			.append(time)
			.append("00")
			.append("\r\n")
		.toString();
		}		
	}
	
	public void setStart( String date ){
		if(date.contains("TZID")) {
			eventStartTime = new StringBuilder()
					.append("DTSTART;")
					.append(date)
					.append("\r\n")
			.toString();
		} else {
			eventStartTime = new StringBuilder()
					.append("DTSTART:")
					.append(date)
					.append("\r\n")
			.toString();

		}
	}
	
	/**
	 * setEnd, sets end time, including time zone if provided.
	 * Uses tzInfo boolean from Interface to determine whether user
	 * has provided time zone information, and thus which items to append.
	 * @param date, user set date
	 * @param time, user set time
	 * @param tz, user set time zone
	 */
	public void setEnd(String date, String time, String tz){
		if(Interface.getTzInfo()) {
			eventEndTime = new StringBuilder()
			.append("DTEND;")
			.append("TZID=")
			.append(tz)
			.append(":")
			.append(date)
			.append("T")
			.append(time)
			.append("00")
			.append("\r\n")
		.toString();
		} else { 
			eventEndTime = new StringBuilder()
			.append("DTEND:")
			.append(date)
			.append("T")
			.append(time)
			.append("00")
			.append("\r\n")
		.toString();
		}		
	}
	
	public void setEnd( String date ){
		if(date.contains("TZID")) {
		eventEndTime = new StringBuilder()
				.append("DTEND;")
				.append(date)
				.append("\r\n")
			.toString();
		} else {
			eventEndTime = new StringBuilder()
					.append("DTEND:")
					.append(date)
					.append("\r\n")
				.toString();
		}
	}
	
	public void setUID(String uid){
		eventUid = new StringBuilder()
			.append("UID:")
			.append(uid)
			.append("\r\n")
		.toString();
	}
	
	public void setTimeZone(String tz){
		eventTimezone = new StringBuilder()
			.append("TZID=")
			.append(tz)
			.append(":")
			.append("\r\n")
		.toString();
			
	}
	
	public void setGeographicPosition(Float lat, Float lon){
		eventGeoPos = new StringBuilder()
			.append("GEO:")
			.append(lat)
			.append(";")
			.append(lon)
			.append("\r\n")
		.toString();
	}
	
	public void setGeographicPosition(String geo){
		eventGeoPos = new StringBuilder()
				.append("GEO:")
				.append(geo)
				.append("\r\n")
			.toString();
	}

	public void setClassification(String cla ){
		eventClass = new StringBuilder()
			.append("CLASS:")
			.append(cla)
			.append("\r\n")
		.toString();
	}
	
	public void setComment() {
		//don't know how this should work yet
		/*eventComment = new StringBuilder()
		 * .append("COMMENT:")
		 * .append("Distance to your next event is: ")
		 * .append( ~need to call GreatCircle.miles and GreatCircle.km with 
		 * the geo positions from this and the next event~ )
		 * .toString();
		 */
	}
	
	/* getters for all private variables */
	public String getEventSummary() { return eventSummary; }
	public String getEventStartTime() { return eventStartTime; }
	public String getEventEndTime() { return eventEndTime; }
	public String getEventUid() { return eventUid; }
	public String getEventTimezone() { return eventTimezone; }
	public String getEventGeoPos() { return eventGeoPos; }
	public String getEventClass() { return eventClass; }
	public String getEventComment() { return eventComment; }
}
