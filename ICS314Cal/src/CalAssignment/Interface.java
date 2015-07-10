package CalAssignment;
import java.util.Scanner;

public class Interface {

	/*Used for determining whether user has entered geo pos and classification info.
		both within this classes' createEvent method, and CalObj's write method, */ 
	private static boolean geoInfo;
	private static boolean classInfo;
	private static boolean tzInfo;
	
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
		
		//Optional user input (Time Zone)
		System.out.println("Would you like to set a time zome (Y/N)?");
		if(input.nextLine().equalsIgnoreCase("y")) {
			String[] tzList = tzPrompts();
			for(int i = 0; i < tzList.length; i++) {
				String tz = tzList[i];
				System.out.println((i+1) + ". " + tz);
			}
			System.out.println("Please enter the number of the time zone.");
			
			String choice = input.nextLine();			
			switch (choice) { 
				case "1": builder.append("America/New_York");
					break;
				case "2": builder.append("America/Chicago");
					break;
				case "3": builder.append("America/Denver");
					break;
				case "4": builder.append("America/Los_Angles");
					break;
				case "5": builder.append("America/Anchorage");
					break;
				case "6": builder.append("Pacific/Honolulu");
					break;
				default: System.out.println("There has been an error.");
					break;
			}									
			setTzInfo(true);
		}
		
		input.close();
		
		event = createEvent(event, builder.toString());
		addToCalendar(calendar, event);
		calendar.write("calendar");
	}
	


	public static String[] getPrompts() {
		return new String[] {
			"Name the event",
			"Set a start date (yyyymmdd)",
			"Set a start time (hhmm)",
			"Set an end date (yyyymmdd)",
			"Set an end time (hhmm)",
			"Enter your email address"
		};		
	}
	
	public static String[] tzPrompts() {
		return new String[] {
				"Eastern",
				"Central",
				"Mountain",
				"Pacific",
				"Alaska",
				"Hawaii"
		};
	}
	
	public static Event createEvent(Event event, String info) {
		String[] descriptors = info.split(", ");
		int i = 0;
		event.setSummary(descriptors[i++]);
		//only works if timezone info is last in array.
		event.setStart(descriptors[i++], descriptors[i++], descriptors[descriptors.length-1]);
		event.setEnd(descriptors[i++], descriptors[i++], descriptors[descriptors.length-1]);
		event.setUID(descriptors[i++]);
		if(getGeoInfo()) {
			event.setGeographicPosition(Float.parseFloat(descriptors[i++]), 
					Float.parseFloat(descriptors[i++]));
		}
		if(getClassInfo()) {
			event.setClassification(descriptors[i++].toUpperCase());
		}
		if(getTzInfo()) {
			event.setTimeZone(descriptors[i++]);
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
	
	public static boolean getTzInfo() {
		return tzInfo;
	}

	public static void setTzInfo(boolean b) {
		tzInfo = b;
	}
	
}
