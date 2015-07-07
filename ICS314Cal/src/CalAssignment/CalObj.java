import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CalObj {
	
	private String 
		version    = "VERSION:1.0\r\n", 
		prodid     = "PRODID://Elara/lofy/tanare/delp/314sum2015//\r\n",
		calBegin   = "BEGIN:VCALENDAR\r\n",
		calEnd     = "END:VCALENDAR\r\n",
		eventBegin = "BEGIN:VEVENT\r\n",
		eventEnd   = "END:VEVENT\r\n";
	private ArrayList<Event> eventArray = new ArrayList<>();
	
	//Adds event to CalObj event array list
	public void addEvent(Event e){
		eventArray.add(e);
	}
	
	//Writes CalObj to .ics file
	//Takes filename in 
	public void write(String name){
		
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(".ics");
		
		try {
			File file = new File(builder.toString());
 
			// if file doesn't exists, then create it
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
//				bw.write( e.getEventGeoPos() ); // since we don't have this method in Event.java yet, main method crashes if this is on
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
