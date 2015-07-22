package CalAssignment;
// http://www.c-sharpcorner.com/UploadFile/fd0172/registration-form-in-windows-form-using-swing-in-java/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MenuNavigation extends JFrame implements ActionListener {
	JLabel l0, l1, l2, l3, l4, l5, l6, l7;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton btn1, btn2;

	MenuNavigation() {
		setVisible(true);
		setSize(1266, 668);
		setLayout(null); // null, or a chosen LayoutManager
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calender Appointment");

		l0 = new JLabel("Make your own Event:");
		l0.setForeground(Color.blue);
		l0.setFont(new Font("Serif", Font.BOLD, 20));

		l1 = new JLabel("Event Name:");
		l2 = new JLabel("Start Date:");
		l3 = new JLabel("Start Time:");
		l4 = new JLabel("End Date:");
		l5 = new JLabel("End Time:");
		l6 = new JLabel("Email Address:");
		l7 = new JLabel("Timezone:");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();

		btn1 = new JButton("Save");
		btn2 = new JButton("Clear");

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		// set the dimensions of the components (labels, fields, etc.)
		l0.setBounds(100, 30, 400, 30);
		l1.setBounds(80, 70, 200, 30);
		l2.setBounds(80, 110, 200, 30);
		l3.setBounds(80, 150, 200, 30);
		l4.setBounds(80, 190, 200, 30);
		l5.setBounds(80, 230, 200, 30);
		l6.setBounds(80, 270, 200, 30);
		l7.setBounds(80, 310, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		tf2.setBounds(300, 110, 200, 30);
		tf3.setBounds(300, 150, 200, 30);
		tf4.setBounds(300, 190, 200, 30);
		tf5.setBounds(300, 230, 200, 30);
		tf6.setBounds(300, 270, 200, 30);
		tf7.setBounds(300, 310, 200, 30);
		btn1.setBounds(50, 350, 100, 30);
		btn2.setBounds(170, 350, 100, 30);

		// add the components to the GUI in specific order
		add(l0);
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		add(l4);
		add(tf4);
		add(l5);
		add(tf5);
		add(l6);
		add(tf6);
		add(l7);
		add(tf7);
		add(btn1);
		add(btn2);
	}

	public void actionPerformed(ActionEvent e) {
		// if user clicks "Save"
		if (e.getSource() == btn1) {
			String[] data = {
				tf1.getText(),
				tf2.getText(),
				tf3.getText(),
				tf4.getText(),
				tf5.getText(),
				tf6.getText(),
				tf7.getText()
			};
		}
		// if user clicks "Clear"
		else {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
		}
	}
	public static void main(String args[]) { new MenuNavigation(); }
}
