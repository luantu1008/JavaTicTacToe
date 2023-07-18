import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame {
	private JPanel operandPanel;
	private JLabel operand1;
	private JTextField op1;
	private JLabel operand2;
	private JTextField op2;
	private JLabel result;
	private JButton button;
	private JPanel buttonPanel;
	private ActionListener listener;
	private JFrame frame;

	public Calculator() {
		setSize(700,800);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		listener = new ButtonListener();
		
		createOperandPanel();
		createButtonPanel();
	}

	public void createOperandPanel() {
		operandPanel = new JPanel();
		
		operand1 = new JLabel("Operand 1");
		op1 = new JTextField(6);
		operand2 = new JLabel("Operand 2");
		op2 = new JTextField(6);
		result = new JLabel("0");
		
		operandPanel.add(operand1);
		operandPanel.add(op1);
		operandPanel.add(operand2);
		operandPanel.add(op2);
		operandPanel.add(result);
		
		add(operandPanel,BorderLayout.NORTH);
	}
	
	public void createButtonPanel() {
		button = new JButton("+");
		buttonPanel = new JPanel();
		
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		add(buttonPanel,BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			double num1 = Double.parseDouble(op1.getText());
			double num2 = Double.parseDouble(op2.getText());
			double sum = ((num1 + num2)*100.0)/100;
			result.setText(String.valueOf(sum));
			} catch (Exception ex){
				JOptionPane.showMessageDialog(frame, "Please enter numbers only");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
