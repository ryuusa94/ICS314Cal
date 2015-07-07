package CalAssignment;
import java.util.Scanner;

public class Interface {

	/*Used for determining whether user has entered geo pos and classification info.
		both within this classes' createEvent method, and CalObj's write method, */ 
	private static boolean geoInfo;
	private static boolean classInfo;
	
	public static void main(String[] args) {
		Event event = new Event();
		CalObj calendar = new CalObj();
		
		StringBuilder builder = new StringBuilder();
		Scanner input = new Scanner(System.in);
		
		String[] prompts = getPrompts();
		for(int i = 0; i < prompts.length; i++) {
			String prompt = prompts[i] + ": ";
			System.out.print(prompt);
			builder.append(input.nextLine() + ", ");
		}
		
		//Optional user input (Geographic Position)
		System.out.println("Would you like to set a geographic position (Y/N)?");
		if(input.nextLine().equalsIgnoreCase("y")) {
			System.out.println("Please enter the latitude in decimal degrees:");
			builder.append(input.nextLine() + ", ");
			System.out.println("Please enter the longitude in decimal degrees:");
			builder.append(input.nextLine() + ", ");
			setGeoInfo(true);
		}
		
		//Optional user input (Classification), converted to Upper Case
		System.out.println("Would you like to set an access classification (Y/N)?");
		if(input.nextLine().equalsIgnoreCase("y")) {
			System.out.println("Please enter the classification:");
			builder.append(input.nextLine() + ", ");
			setClassInfo(true);
		}
		
		input.close();
		
		event = createEvent(event, builder.toString());
		addToCalendar(calendar, event);
		calendar.write("calendar");
	}
	
	public static String[] getPrompts() {
		return new String[] {
			"Name the event",
			"Set a start time",
			"Set an end time",
			"Enter your email address"
		};		
	}
	
	public static Event createEvent(Event event, String info) {
		String[] descriptors = info.split(", ");
		int i = 0;
		event.setSummary(descriptors[i++]);
		event.setStart(descriptors[i++]);
		event.setEnd(descriptors[i++]);
		event.setUID(descriptors[i++]);
		if(getGeoInfo()) {
			event.setGeographicPosition(Float.parseFloat(descriptors[i++]), 
					Float.parseFloat(descriptors[i++]));
		}
		if(getClassInfo()) {
			event.setClassification(descriptors[i++].toUpperCase());
		}		
		return event;
	}
	
	public static void addToCalendar(CalObj calendar, Event event) {
		calendar.addEvent(event);
	}
	
	private static void setGeoInfo(boolean b) {
		geoInfo = b;	
	}
	
	public static boolean getGeoInfo() {
		return geoInfo;
	}
	
	private static void setClassInfo(boolean b) {
		classInfo = b;	
	}
	
	public static boolean getClassInfo() {
		return classInfo;
	}
	
}
