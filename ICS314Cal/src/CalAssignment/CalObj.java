package CalAssignment;
/**
 * CalObj class
 * private variables, empty constructor, public setters and getters,
 * and MAC CALENDAR toString
 */
public class CalObj 
{
	private String name; //associated with SUMMARY category
  	private String startTime; 
  	private String endTime; 
  	private String timezone; //will be Pacific/Honolulu here
	private String date; //may need to mix date and time, exp: 201500701T010000
	private String[] location;
	private Float lat;//latitude used for geographic position
	private Float lon;//longitude used for geographic position
	private String coordinates; //could lump lat and long into string if needed
  	private String descript; //associated with DESCRIPTION category
  	  	
  	public CalObj()
  	{
  		
  	}
  	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getStartTime() 
	{
		return startTime;
	}
	public void setStartTime(String startTime) 
	{
		this.startTime = startTime;
	}
	public String getEndTime() 
	{
		return endTime;
	}
	public void setEndTime(String endTime) 
	{
		this.endTime = endTime;
	}
	public String getTimezone() 
	{
		return timezone;
	}
	public void setTimezone(String timezone) 
	{
		this.timezone = timezone;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String[] getLocation() 
	{
		return location;
	}
	public void setLocation(String[] location) 
	{
		this.location = location;
	}
	public String getCoordinates() 
	{
		return coordinates;
	}
	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public void setCoordinates(String coordinates) 
	{
		this.coordinates = coordinates;
	}
	public String getDescript() 
	{
		return descript;
	}
	public void setDescript(String descript) 
	{
		this.descript = descript;
	}
	
	/* toString method
	 * WORKS WITH MAC CALENDAR
	 * several of the lines appended below with need to be changed from
	 * hard coding to variables 
	 */
/*	public String toString()
	{
		return new StringBuffer("BEGIN:VCALENDAR\n")
			.append("CALSCALE:GREGORIAN\n")
			.append("VERSION:2.0\n")
			.append("METHOD:PUBLISH\n")			
			.append("X-WR-CALNAME:Home\n")
			.append("X-WR-TIMEZONE:"+ this.timezone +"\n")
			.append("DTSTART:19330430T020000\n")//don't know why this date is so old
			.append("X-APPLE-CALENDAR-COLOR:#1BADF8\n")
			.append("BEGIN:VEVENT\n")
			.append("UID:6BB808D7-C47A-4BDC-AF61-63B65AC28D0C\n")
			.append("DTEND;TZID="+ this.timezone +":"+ this.endTime +"\n") //need to mix date with time?
			.append("TRANSP:OPAQUE\n")
			.append("CREATED:20150701T052850Z\n")
			.append("SUMMARY:" + this.name + "\n")
			.append("DTSTART;TZID="+ this.timezone +":" + this.startTime + "\n") //need to mix date with time?
			.append("DTSTAMP:20150701T090000Z\n")
			.append("LOCATION:" + this.location + "\n")
			.append("GEO:" + this.lat + ";" + this.lon + "\n")//geographic position
			.append("SEQUENCE:0\n")
			//.append("SEQUENCE:" + Driver.sequence + "\n")//don't know if sequence needs to increase
			.append("END:VEVENT\n")
			.append("END:VCALENDAR\n").toString();
	}
*/
	
	/* toString method
	 * WORKS WITH GOOGLE CALENDAR (also works with Mac, but not as well as Mac version)
	 * Commented lines are still untested, and are likely unneeded.
	 */
	public String toString()
	{
		return new StringBuffer("BEGIN:VCALENDAR\n")			
			//.append("X-WR-TIMEZONE:"+ this.timezone +"\n")
			.append("BEGIN:VEVENT\n")
			.append("DTSTART;VALUE=DATE:" + this.date + "\n")
			.append("DTEND;VALUE=DATE:20150705\n") //need end date variable
			//.append("DTSTAMP:20150701T090000Z\n")
			//.append("UID:0pcbu9mp1eqeak59v0m04lspn0@google.com\n") //don't know how to use this
			//.append("CREATED:20150701T052850Z\n")
			.append("DESCRIPTION:" + this.descript + "\n")
			//.append("LAST-MODIFIED:20150701T052850Z\n")
			.append("LOCATION:" + this.location + "\n")
			.append("GEO:" + this.lat + ";" + this.lon + "\n")//geographic position
			//.append("SEQUENCE:0\n")
			//.append("STATUS:CONFIRMED\n")
			.append("SUMMARY:" + this.name + "\n")
			//.append("TRANSP:TRANSPARENT\n")			
			.append("END:VEVENT\n")
			.append("END:VCALENDAR\n").toString();
	}

	
	
}
