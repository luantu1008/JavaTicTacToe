
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Flight extends JFrame {
	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 700;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel topPanel;
	private JLabel headerLabel1;
	private JLabel headerLabel2;

	private JPanel centrePanel = new JPanel();
	private JPanel centreSubPanel = new JPanel();
	private JPanel txtArea = new JPanel();
	private JPanel rsPanel = new JPanel();

	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea txtField = new JTextArea(15, 40);

	private JPanel centrePanel2 = new JPanel();
	private JPanel centreSubPanel2 = new JPanel();
	private JPanel centreSubPanel3 = new JPanel();

	private JPanel upperPanel = new JPanel();
	private JPanel upperSubPanel = new JPanel();
	private JPanel upperSubPanel1 = new JPanel();



	private JComboBox dest;
	private JComboBox destTo;
	private JComboBox dayOfWeek;
	private String[] destCode = { "YYC", "YYZ", "ON", "QB" };
	private String days []  = {"Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday", "Any"};

	public Flight() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle("FIlight Reservation Managerment System");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildTopPanel();
		buildCentrePanel();
		buildCentrePanel2();
		buildUpperPanel();

	}

	private void buildTopPanel() {

		// button flights

		button1 = new JButton("Flight");

		ActionListener FlightListener = new FlightListener();
		
		
		button2 = new JButton("Reservations");
		ActionListener ReservationListener = new ReservationListener();
		
		
		headerLabel1 = new JLabel("Flights");
		headerLabel1.setText("DCM Dans");

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(0, 2));
		topPanel.add(button1);button1.addActionListener(FlightListener);
		topPanel.add(button2);button2.addActionListener( ReservationListener);

		add(topPanel, BorderLayout.NORTH);

	}
	
	private class FlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == button1) {
				headerLabel1.setText("DCM Dans");
				
			}
			
			
			}
			
		}
		
	private class ReservationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button2) {
				headerLabel1.setText("Reservation");
			}
		}
		
	}
		
	

	public void buildCentrePanel() {

		centrePanel.add(centreSubPanel);

		centreSubPanel.setLayout(new BorderLayout(5, 10));

		JLabel flights = new JLabel("Flights");
		flights.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));
		flights.setHorizontalAlignment(JLabel.CENTER);
		centreSubPanel.add(flights, BorderLayout.NORTH);

		txtArea.add(txtField);
		centreSubPanel.add(txtField, BorderLayout.CENTER);

		add(centrePanel, BorderLayout.CENTER);
	}

	public void buildCentrePanel2() {

		
		JLabel reserve = new JLabel("Reserve");
//		reserve.setHorizontalAlignment(JLabel.CENTER);
		centreSubPanel2.add(reserve, BorderLayout.NORTH);
		
		
		reserve.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));

		JLabel inputFlight = new JLabel("Flight:");
		JLabel inputAirline = new JLabel("Airline: ");
		JLabel inputDay = new JLabel("Day: ");
		JLabel inputTime = new JLabel("Time: ");
		JLabel inputCost = new JLabel("Cost: ");
		JLabel inputName = new JLabel("Name: ");
		JLabel inputCitizenShip = new JLabel("CitizenShip: ");

		JTextField inputFlight1 = new JTextField(15);

		JTextField inputAirline1 = new JTextField(15);
		JTextField inputDay1 = new JTextField(15);
		JTextField inputTime1 = new JTextField(15);
		JTextField inputCost1 = new JTextField(15);
		JTextField inputName1 = new JTextField(15);
		JTextField inputCitizenShip1 = new JTextField(15);
		button3 = new JButton("Reserve");

		centreSubPanel3.setLayout(new GridLayout(11, 1));

		centreSubPanel3.add(inputFlight);
		centreSubPanel3.add(inputFlight1);

		centreSubPanel3.add(inputAirline);
		centreSubPanel3.add(inputAirline1);

		centreSubPanel3.add(inputDay);
		centreSubPanel3.add(inputDay1);

		centreSubPanel3.add(inputTime);
		centreSubPanel3.add(inputTime1);

		centreSubPanel3.add(inputCost);
		centreSubPanel3.add(inputCost1);

		centreSubPanel3.add(inputName);
		centreSubPanel3.add(inputName1);

		centreSubPanel3.add(inputCitizenShip);
		centreSubPanel3.add(inputCitizenShip1);
		centreSubPanel3.add(button3);

		centrePanel2.add(centreSubPanel2);
		centreSubPanel2.add(centreSubPanel3);
		add(centrePanel2,BorderLayout.EAST);
		
	}

	public void buildUpperPanel() {
		
		JLabel flightFinder = new JLabel("Flight Finder");
		upperSubPanel.add(flightFinder, BorderLayout.NORTH);
		
		flightFinder.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));

		

		JLabel from = new JLabel("From: ");
		dest = new JComboBox(destCode);
		
		JLabel to = new JLabel("To: ");
		destTo = new JComboBox(destCode);
		
		JLabel day = new JLabel("Day: ");
		dayOfWeek = new JComboBox(days);
		JButton fReservation = new JButton("Find Reservation");

		upperSubPanel1.setLayout(new GridLayout(3, 1));
		
		upperSubPanel1.add(flightFinder);

		upperSubPanel1.add(from);
		upperSubPanel1.add(dest);
		upperSubPanel1.add(to);
		upperSubPanel1.add(destTo);
		upperSubPanel1.add(day);
		upperSubPanel1.add(dayOfWeek);
		upperSubPanel1.add(fReservation);
		
		
		
		upperPanel.add(upperSubPanel);
		upperSubPanel.add(upperSubPanel1);
		add(upperPanel, BorderLayout.SOUTH);
//		upperPanel.setComponentPopupMenu(ComponentOrientation.);
	}

	public static void main(String[] args) {
		new Flight();
	}

}
