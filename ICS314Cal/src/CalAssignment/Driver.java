package CalAssignment;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Driver Class 
 * NOT FINAL CODE
 * Creating CalObj for testing
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		CalObj event1 = new CalObj();
		event1.setSummary("test summary");
		event1.setUID("testEventID");
		event1.setStart("9:00");
		event1.setEnd("10:00");
		event1.write("test2");
		
	}
}
