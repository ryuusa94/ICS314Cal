package CalAssignment;

public class Event {
	private String eventSummary;
	private String eventStartTime;
	private String eventEndTime;
	private String eventUid;
	private String eventTimezone;
	private String eventGeoPos;
	private String eventClass;

	
	public Event(){
		eventSummary = "";
		eventStartTime = "";
		eventEndTime = "";
		eventUid = "";
		eventTimezone = "";
		eventGeoPos = "";
		eventClass = "";
		
	}
	

	
	public void setSummary( String summary){
		StringBuilder builder = new StringBuilder();
		builder.append("SUMMARY:");
		builder.append(summary);
		builder.append("\r\n");
		eventSummary = builder.toString();
		
		
	}
	
	public void setStart( String time){
		StringBuilder builder = new StringBuilder();
		builder.append("DTSTART:");
		builder.append(time);
		builder.append("\r\n");
		eventStartTime = builder.toString();
		
	}
	
	public void setEnd(String time){
		StringBuilder builder = new StringBuilder();
		builder.append("DTEND:");
		builder.append(time);
		builder.append("\r\n");
		eventEndTime = builder.toString();
		
	}
	
	public void setUID( String uid){
		StringBuilder builder = new StringBuilder();
		builder.append("UID:");
		builder.append(uid);
		builder.append("\r\n");
		eventUid = builder.toString();
		
	}
	
	public void setTimeZone(String tz){
		
	}
	
	public void setGeographicPosition(Float lat, Float lon){
		StringBuilder builder = new StringBuilder();
		builder.append("GEO:");
		builder.append(lat);
		builder.append(";");
		builder.append(lon);
		builder.append("\r\n");
		eventGeoPos = builder.toString();
	}

	public void setClassification(String cla ){
		
	}
	
	public String getEventSummary() {
		return eventSummary;
	}



	public String getEventStartTime() {
		return eventStartTime;
	}



	public String getEventEndTime() {
		return eventEndTime;
	}



	public String getEventUid() {
		return eventUid;
	}



	public String getEventTimezone() {
		return eventTimezone;
	}

	
	
	public String getEventGeoPos() {
		return eventGeoPos;
	}



	public String getEventClass() {
		return eventClass;
	}

}

