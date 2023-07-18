package BankAccount;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BankAccount extends JFrame {

	private static double BALANCE = 1000;
	private JPanel ratePanel;
	private JFrame frame;
	private JTextField rateTextField;
	private JButton button;
	private JLabel resultLabel;
	private JPanel resultPanel;
	private JScrollPane history;
	private JPanel historyPanel;
	private JTextArea resultArea;
	
	public BankAccount() {
		setTitle("Investment");
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		resultArea = new JTextArea(30,20);
		resultArea.setText(BALANCE + "\n");
		resultArea.setEditable(false);
		
		createTextField();
		createButton();
		createPanel();
	}
	
	public void createTextField() {
		rateTextField = new JTextField(10);
		
		
	}
	
	class AddInterestListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!rateTextField.getText().isEmpty()) {
				double interest = 0;
				try {
					interest = Double.parseDouble(rateTextField.getText());
					if(interest<0) {
						rateTextField.setText("");
						JOptionPane.showMessageDialog(frame, "Please enter the interest rate!","WARNING",JOptionPane.WARNING_MESSAGE);						
					}else{
						BALANCE = BALANCE + BALANCE*interest/100;
						resultLabel.setText("Balance: " + BALANCE);
						resultArea.append(BALANCE + "\n");
					}
				}catch(Exception ex) {
					rateTextField.setText("");
					JOptionPane.showMessageDialog(frame, "Please enter the interest rate!","WARNING",JOptionPane.WARNING_MESSAGE);
				}			
			}
			else {
				JOptionPane.showMessageDialog(frame, "Please enter the interest rate!","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}
	
	public void createButton() {
		button = new JButton("Add Interest");
		
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	public void createPanel() {
	ratePanel = new JPanel();
	resultPanel = new JPanel();
	resultLabel = new JLabel("Balance: " + BALANCE);
	historyPanel = new JPanel();
	history = new JScrollPane(resultArea);

	
	
	ratePanel.add(new JLabel("Interest Rate: "));
	ratePanel.add(rateTextField);
	ratePanel.add(button);
	
	resultPanel.add(resultLabel);
	
	historyPanel.add(history);
	
	
	add(ratePanel,BorderLayout.NORTH);
	add(resultPanel,BorderLayout.CENTER);
	add(historyPanel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		JFrame frame = new BankAccount();
		frame.setVisible(true);
	}
}
