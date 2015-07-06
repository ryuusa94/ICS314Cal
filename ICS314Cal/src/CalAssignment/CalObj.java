package CalAssignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CalObj {
	
	private String version =  	"VERSION:1.0\r\n";
	private String prodid = 	"PRODID://Elara/lofy/tanare/delp/314sum2015//\r\n";
	private String calBegin =  	"BEGIN:VCALENDAR\r\n";
	private String calEnd =  	"END:VCALENDAR\r\n";
	private String eventBegin = "BEGIN:VEVENT\r\n";
	private String eventEnd =   "END:VEVENT\r\n";
	
	private ArrayList<Event> eventArray = new ArrayList<Event>();
	
	
	//Adds event to CalObj event array list
	public void addEvent( Event e){
		eventArray.add(e);
	}
	
	//Writes CalObj to .ics file
	//Takes filename in 
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
			for (int i = 0; i < eventArray.size(); i++) {
				Event e = eventArray.get(i);
				bw.write(eventBegin);
				bw.write( e.getEventUid() );
				bw.write( e.getEventStartTime() );
				bw.write( e.getEventEndTime() );
				bw.write( e.getEventSummary() );
				//GEO
				bw.write( e.getEventGeoPos() );
	            bw.write(eventEnd);
	        }
			bw.write(calEnd);
			
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
