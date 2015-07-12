package CalAssignment;
import javax.swing.JOptionPane;

/**
 * Interface
 * creates the javax user interface, takes user input
 * @author TeamElara
 */
public class Interface {

	/* Used for determining whether user has entered geo pos and classification info.
	 * both within this classes' createEvent method, and CalObj's write method, 
	 */ 
	private static boolean geoInfo;
	private static boolean classInfo;
	private static boolean tzInfo;
	
	/**
	 * main
	 * executes program
	 * @param args (this program does not use the command line)
	 */
	public static void main(String[] args) {
		CalObj calendar = new CalObj();
		Event event = new Event();
		StringBuilder builder = new StringBuilder();
		
		// ask information to setup base event
		String[] prompts = getEventPrompts();
		for(int i = 0; i < prompts.length; i++) {
			builder.append(prompts[i] + ", ");
		}
		
		// optional prompts for GPS coordinates
		if(JOptionPane.showConfirmDialog(null, "Would you like to set a geographic position?", "Geographic Position", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			String[] optionalPrompts = getOptionalGeoPrompts();
			for(int i = 0; i < optionalPrompts.length; i++) {
				builder.append(optionalPrompts[i] + ", ");
			}
			setGeoInfo(true);
		}
		
		// optional prompts for setting classification
		if(JOptionPane.showConfirmDialog(null, "Would you like to set an access classification?", "Classification", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			String[] optionalPrompts = getOptionalClassificationPrompts();
			for(int i = 0; i < optionalPrompts.length; i++) {
				builder.append(optionalPrompts[i] + ", ");
			}
			setClassInfo(true);
		}
		
		// optional prompts for setting time zone
		if(JOptionPane.showConfirmDialog(null, "Would you like to set a timezone?", "Timezone", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			String[] optionalPrompts = getOptionalTimezonePrompts();
			for(int i = 0; i < optionalPrompts.length; i++) {
				builder.append(optionalPrompts[i] + ", ");
			}
			setTzInfo(true);
		}
		
		// final housekeeping: create event, add to calendar, write to calendar file
		event = createEvent(event, builder.toString());
		addToCalendar(calendar, event);
		calendar.write("calendar");
	}
	
	/**
	 * getEventPrompts
	 * gets user input to create the basic event
	 * @return an array of user input (answers)
	 */
	public static String[] getEventPrompts() {
		String title = "Creating your event";
		int type = JOptionPane.QUESTION_MESSAGE;
		return new String[] {
			JOptionPane.showInputDialog(null, "Name the event", title, type),
			JOptionPane.showInputDialog(null, "Set a start date (yyyymmdd)", title, type),
			JOptionPane.showInputDialog(null, "Set a start time (hhmm)", title, type),
			JOptionPane.showInputDialog(null, "Set an end date (yyyymmdd)", title, type),
			JOptionPane.showInputDialog(null, "Set an end time (hhmm)", title, type),
			JOptionPane.showInputDialog(null, "Enter your email address", title, type)
		};		
	}
	
	/**
	 * getOptionalGeoPrompts
	 * gets user input to add coordinate plotting info
	 * @return an array of user input (answers)
	 */
	public static String[] getOptionalGeoPrompts() {
		return new String[] {
			JOptionPane.showInputDialog(null, "Please enter the latitude in decimal degrees"),
			JOptionPane.showInputDialog(null, "Please enter the longitude in decimal degrees")
		};
	}
	
	/**
	 * getOptionalClassificationPrompts
	 * gets user input to add classification information
	 * @return an array of user input (answers)
	 */
	public static String[] getOptionalClassificationPrompts() {
		return new String[] {
			JOptionPane.showInputDialog(null, "Please enter the classification")
		};
	}
	
	/**
	 * getOptionalTimezonePrompts
	 * gets user input to add timezone information
	 * @return an array of user input (answers)
	 */
	public static String[] getOptionalTimezonePrompts() {
		String[] choices = {
			"",
			"Eastern",
			"Central",
			"Mountain",
			"Pacific",
			"Alaska",
			"Hawaii"	
		};
		return new String[] {
			(String) JOptionPane.showInputDialog(null, "Please select a timezone", "Timezone", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0])
		};
	}
	
	/**
	 * createEvent
	 * creates an Event instance with provided data/information
	 * @param event an Event
	 * @param info information about the event to be created
	 * @return a new Event instance
	 */
	public static Event createEvent(Event event, String info) {
		String[] descriptors = info.split(", ");
		int i = 0;
		event.setSummary(descriptors[i++]);
		//only works if timezone info is last in array.
		event.setStart(descriptors[i++], descriptors[i++], descriptors[descriptors.length-1]);
		event.setEnd(descriptors[i++], descriptors[i++], descriptors[descriptors.length-1]);
		event.setUID(descriptors[i++]);
		if(getGeoInfo()) {
			event.setGeographicPosition(Float.parseFloat(descriptors[i++]), Float.parseFloat(descriptors[i++]));
		}
		if(getClassInfo()) {
			event.setClassification(descriptors[i++].toUpperCase());
		}
		if(getTzInfo()) {
			event.setTimeZone(descriptors[i++]);
		}		
		return event;
	}
	
	/**
	 * addToCalendar
	 * add a fully realized event to a calendar object
	 * @param calendar a Calendar object
	 * @param event an Event object
	 */
	public static void addToCalendar(CalObj calendar, Event event) { calendar.addEvent(event); }
	// setters and getters for geographic info, classification, and timezone
	private static void setGeoInfo(boolean b) { geoInfo = b; }
	public static boolean getGeoInfo() { return geoInfo; }
	private static void setClassInfo(boolean b) { classInfo = b; }
	public static boolean getClassInfo() { return classInfo; }
	public static void setTzInfo(boolean b) { tzInfo = b; }
	public static boolean getTzInfo() { return tzInfo; }
}
