package CalAssignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * CalObj class
 * 
 */
public class CalObj 
{
	
	private String version =  	"VERSION:1.0\r\n";
	private String prodid = 	"PRODID://Elara/lofy/tanare/delp/314sum2015//\r\n";
	private String calBegin =  	"BEGIN:VCALENDAR\r\n";
	private String calEnd =  	"END:VCALENDAR\r\n";
	private String eventBegin = "BEGIN:VEVENT\r\n";
	private String eventEnd =   "END:VEVENT\r\n";
	
	private String eventSummary;
	private String eventStartTime;
	private String eventEndTime;
	private String eventUid;
	private String eventTimezone;
	private String eventGeoPos;
	private String eventClass;
		
	//kept these from eariler draft
	private String[] location;
	private Float lat;//latitude used for geographic position
	private Float lon;//longitude used for geographic position
	
	
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
	
	public void setGeographicPosition(String geoPos){
		
	}
	
	public void setClassification(String cla ){
		
	}
	

public void write( String name ){
		
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(".ics");
		
		try {
			
 
			File file = new File(builder.toString());
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(calBegin);
			bw.write(version);
			bw.write(prodid);
			bw.write(eventBegin);
			bw.write(eventUid);
			bw.write(eventStartTime);
			bw.write(eventEndTime);
			bw.write(eventSummary);
			bw.write(eventEnd);
			bw.write(calEnd);
			
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
