package CalAssignment;
/**
 * CalObj class
 * private variables, empty constructor, public setters and getters,
 * and MAC CALENDAR toString
 */
public class CalObj 
{
	private String name;
  	private String startTime; //used in toString below
  	private String endTime; //used in toString below
  	private String timezone; //will be Pacific/Honolulu here
	private String date; //may need to mix date and time, exp: 201500701T010000
	private String[] location;
	private String coordinates;
  	private String summary; //used in toString below
  	  	
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
	public void setCoordinates(String coordinates) 
	{
		this.coordinates = coordinates;
	}
	public String getSummary() 
	{
		return summary;
	}
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}
	
	/* toString method
	 * WORKS WITH MAC CALENDAR
	 * several of the lines appended below with need to be changed from
	 * hard coding to variables 
	 */
	public String toString()
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
			.append("SUMMARY:" + this.summary + "\n")
			.append("DTSTART;TZID="+ this.timezone +":" + this.startTime + "\n") //need to mix date with time?
			.append("DTSTAMP:20150701T090000Z\n")
			.append("LOCATION:" + this.location + "\n")
			.append("SEQUENCE:0\n")
			//.append("SEQUENCE:" + Driver.sequence + "\n")//don't know if sequence needs to increase
			.append("END:VEVENT\n")
			.append("ENDVCALENDAR\n").toString();
	}

	
	
}
