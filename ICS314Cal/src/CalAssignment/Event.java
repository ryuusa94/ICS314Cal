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
		eventClass;
	
	public void setSummary(String summary){
		eventSummary = new StringBuilder()
			.append("SUMMARY:")
			.append(summary)
			.append("\r\n")
		.toString();
	}
	
	public void setStart(String time){
		eventStartTime = new StringBuilder()
			.append("DTSTART:")
			.append(time)
			.append("\r\n")
		.toString();
	}
	
	public void setEnd(String time){
		eventEndTime = new StringBuilder()
			.append("DTEND:")
			.append(time)
			.append("\r\n")
		.toString();
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

	public void setClassification(String cla ){
		eventClass = new StringBuilder()
			.append("CLASS:")
			.append(cla)
			.append("\r\n")
		.toString();
	}
	
	/* getters for all private variables */
	public String getEventSummary() { return eventSummary; }
	public String getEventStartTime() { return eventStartTime; }
	public String getEventEndTime() { return eventEndTime; }
	public String getEventUid() { return eventUid; }
	public String getEventTimezone() { return eventTimezone; }
	public String getEventGeoPos() { return eventGeoPos; }
	public String getEventClass() { return eventClass; }
}
