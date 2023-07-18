import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
	private JPanel resultPanel;
	private JPanel buttonPanel;
	private JButton resetButton;
	private JFrame frame;
	private JTextArea moveIndicator;
	private JScrollPane moveScroller;
	JButton[] button = new JButton[9];
	JTextField p1 = new JTextField("0", 3);
	JTextField p2 = new JTextField("0", 3);
	JTextField tie = new JTextField("0", 3);
	private static int p1Score = 0;
	private static int p2Score = 0;
	private static int tieScore = 0;
	private boolean p1Turn = true;
	private boolean winner;

	public TicTacToe() {
		setTitle("TicTacToe");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		createPanel();
		createButton();

	}

	public void createPanel() {
		// Create the result panel on top
		resultPanel = new JPanel();
		resetButton = new JButton("Reset");
		ActionListener resetListener = new ResetListener();
		resetButton.addActionListener(resetListener);

		p1.setEditable(false);
		p2.setEditable(false);
		tie.setEditable(false);

		resultPanel.add(resetButton);
		resultPanel.add(new JLabel("Player 1: "));
		resultPanel.add(p1);
		resultPanel.add(new JLabel("Player 2: "));
		resultPanel.add(p2);
		resultPanel.add(new JLabel("Tie: "));
		resultPanel.add(tie);
		add(resultPanel, BorderLayout.NORTH);

		// Create move indicator for each player

		moveIndicator = new JTextArea(10, 15);
		moveIndicator.setEditable(false);
		moveScroller = new JScrollPane(moveIndicator);

		add(moveScroller, BorderLayout.EAST);

	}

	class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == resetButton) {
				moveIndicator.setText("");
				for (int i = 0; i < 9; i++) {
					button[i].setText("");
					button[i].setBackground(null);
					button[i].setEnabled(true);
					p1Turn = true;
					winner = false;
				}
			}
		}

	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 9; i++) {

				if (e.getSource() == button[i]) {
					if (button[i].getText().isEmpty()) {
						if (p1Turn) {
							button[i].setText("X");
							button[i].setForeground(Color.BLUE);
							button[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 124));
							p1Turn = false;
							moveIndicator.append("player 1: " + moveLocator(i) + "\n");
							check();

						} else {
							button[i].setText("O");
							button[i].setForeground(Color.RED);
							button[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 124));
							p1Turn = true;
							moveIndicator.append("player 2: " + moveLocator(i) + "\n");
							check();
						}

					} else {
						JOptionPane.showMessageDialog(frame, "Duplicated move. Choose another one.");
					}

				}
			}
		}
	}

	public void createButton() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3));

		ActionListener buttonListener = new ButtonListener();

		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			buttonPanel.add(button[i]);
			button[i].addActionListener(buttonListener);
		}

		add(buttonPanel, BorderLayout.CENTER);

	}

	public void check() {

		if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
			xWins(0, 1, 2);
			winner = true;
		}
		if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
			xWins(3, 4, 5);
			winner = true;
		}
		if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
			xWins(6, 7, 8);
			winner = true;
		}
		if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
			xWins(0, 3, 6);
			winner = true;
		}
		if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
			xWins(1, 4, 7);
			winner = true;
		}
		if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
			xWins(2, 5, 8);
			winner = true;
		}
		if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
			xWins(0, 4, 8);
			winner = true;
		}
		if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
			xWins(2, 4, 6);
			winner = true;
		}
		// check O win conditions
		if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
			oWins(0, 1, 2);
			winner = true;
		}
		if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
			oWins(3, 4, 5);
			winner = true;
		}
		if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
			oWins(6, 7, 8);
			winner = true;
		}
		if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
			oWins(0, 3, 6);
			winner = true;
		}
		if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
			oWins(1, 4, 7);
			winner = true;
		}
		if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
			oWins(2, 5, 8);
			winner = true;
		}
		if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
			oWins(0, 4, 8);
			winner = true;
		}
		if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
			oWins(2, 4, 6);
			winner = true;
		}
		if (!button[0].getText().isEmpty() && !button[1].getText().isEmpty() && !button[2].getText().isEmpty()
				&& !button[3].getText().isEmpty() && !button[4].getText().isEmpty() && !button[5].getText().isEmpty()
				&& !button[6].getText().isEmpty() && !button[7].getText().isEmpty() && !button[8].getText().isEmpty()
				&& winner == false) {
			tie();
		}
	}

	public String moveLocator(int i) {
		String text = "";
		switch (i) {
		case 0:
			text = "(1,1)";
			break;
		case 1:
			text = "(1,2)";
			break;
		case 2:
			text = "(1,3)";
			break;
		case 3:
			text = "(2,1)";
			break;
		case 4:
			text = "(2,2)";
			break;
		case 5:
			text = "(2,3)";
			break;
		case 6:
			text = "(3,1)";
			break;
		case 7:
			text = "(3,2)";
			break;
		case 8:
			text = "(3,3)";
			break;
		}
		return text;
	}

	public void xWins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		p1Score++;
		JOptionPane.showMessageDialog(frame, "Player 1 wins.");
		p1.setText(String.valueOf(p1Score));

	}

	public void oWins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		p2Score++;
		JOptionPane.showMessageDialog(frame, "Player 2 wins.");
		p2.setText(String.valueOf(p2Score));
	}

	public void tie() {
		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
			button[i].setBackground(Color.decode("#FFC1CC"));
		}
		JOptionPane.showMessageDialog(frame, "Tie");
		tieScore++;
		tie.setText(String.valueOf(tieScore));

	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}