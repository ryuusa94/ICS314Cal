package CalAssignment;

public class Main {

	public static void main(String[] args) {
		CalObj cal = new CalObj();
		Event ev = new Event();
		ev.setSummary("Bastille Day Party");
		ev.setStart("20150714T170000Z");
		ev.setEnd("20150715T035959Z");
		ev.setUID("elara@example.edu");
		//GEO
		ev.setGeographicPosition((float)21.297688, (float)-157.815916);
		cal.addEvent(ev);
		cal.write("new");

	}

}
