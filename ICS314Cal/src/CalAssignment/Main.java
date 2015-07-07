import java.util.Scanner;

public class Interface {

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
		input.close();
		
		event = createEvent(event, builder.toString());
		addToCalendar(calendar, event);
		calendar.write("calendar.ics");
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
		return event;
	}
	
	public static void addToCalendar(CalObj calendar, Event event) {
		calendar.addEvent(event);
	}
}
