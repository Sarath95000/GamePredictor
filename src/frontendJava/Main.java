package frontendJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Main {

	private static JFrame frame;
	private static JPanel left, right, middle, innerLine, colorPanel;
	private static JLabel title, periodL, currentNumberL, previousNumberL, invalidPeriod, invalidcurrentNumber,
			invalidpreviousNumber, predictionStatusLabel, color;
	private static JTextField period, currentNumber, previousNumber, periodFV, currentNumberFV,
			previousNumberFV, status;
	private static JButton addPeriod, addPrevious, submit, reset, viewTable, save, exit;
	private static Image icon;

	Main() {
		setFrame();
		setAppIcon();
		panelSetUp();
		setText();
		setTextFields();
		setButton();
	}

	private static void setFrame() {
		frame = new JFrame("Wealth Club9-Prediction");
		frame.setSize(1301, 740);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#3498DB"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void setAppIcon() {
		icon = Toolkit.getDefaultToolkit()
				.getImage("/home/sarath/Desktop/programs/Projects/JAVA/WealthClub9/src/IMG/app.png");
		frame.setIconImage(icon);
	}

	private static void panelSetUp() {
		middle = new JPanel();
		middle.setBounds(100, 50, 1100, 100);
		middle.setVisible(true);
		middle.setBackground(Color.green);
		middle.setBackground(Color.black);
		frame.add(middle);

		left = new JPanel();
		left.setBounds(50, 200, 550, 400);
		left.setBorder(new LineBorder(Color.DARK_GRAY));
		left.setVisible(true);
		left.setLayout(null);
		left.setBackground(Color.white);
		frame.add(left);

		right = new JPanel();
		right.setBounds(650, 200, 600, 400);
		right.setBorder(new LineBorder(Color.BLACK, 3));
		right.setVisible(true);
		right.setLayout(null);
		right.setBackground(Color.white);
		frame.add(right);

		innerLine = new JPanel();
		innerLine.setBounds(330, 80, 5, 280);
		innerLine.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		innerLine.setVisible(true);
		innerLine.setLayout(null);
		innerLine.setBackground(Color.LIGHT_GRAY);
		right.add(innerLine);

		colorPanel = new JPanel();
		colorPanel.setBounds(350, 260, 150, 30);
		colorPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		colorPanel.setVisible(true);
		colorPanel.setLayout(null);
		colorPanel.setBackground(Color.LIGHT_GRAY);
		right.add(colorPanel);

	}

	private static void setText() {
		title = new JLabel("Wealth Club9 Predictor");
		title.setVisible(true);
		title.setBounds(10, 10, 200, 150);
		title.setFont(new Font("Ubuntu", 1, 50));
		title.setForeground(Color.white);
		middle.add(title);

		periodL = new JLabel("Period");
		periodL.setVisible(true);
		periodL.setBounds(50, 40, 130, 40);
		periodL.setFont(new Font("Roboto", 1, 25));
		periodL.setForeground(Color.black);
		left.add(periodL);

		currentNumberL = new JLabel("Current Number");
		currentNumberL.setVisible(true);
		currentNumberL.setBounds(50, 140, 250, 40);
		currentNumberL.setFont(new Font("Roboto", 1, 25));
		currentNumberL.setForeground(Color.black);
		left.add(currentNumberL);

		previousNumberL = new JLabel("Previous Number");
		previousNumberL.setVisible(true);
		previousNumberL.setBounds(50, 240, 250, 40);
		previousNumberL.setFont(new Font("Roboto", 1, 25));
		previousNumberL.setForeground(Color.black);
		left.add(previousNumberL);

		invalidPeriod = new JLabel("*Invalid. Please Enter 3 Digit Number.");
		invalidPeriod.setVisible(false);
		invalidPeriod.setBounds(330, 80, 220, 45);
		invalidPeriod.setFont(new Font("Roboto", 1, 10));
		invalidPeriod.setForeground(Color.red);
		left.add(invalidPeriod);

		invalidcurrentNumber = new JLabel("*Invalid. Please Enter 1 Digit Number.");
		invalidcurrentNumber.setVisible(false);
		invalidcurrentNumber.setBounds(330, 180, 220, 45);
		invalidcurrentNumber.setFont(new Font("Roboto", 1, 10));
		invalidcurrentNumber.setForeground(Color.red);
		left.add(invalidcurrentNumber);

		invalidpreviousNumber = new JLabel("*Invalid. Please Enter 1 Digit Number.");
		invalidpreviousNumber.setVisible(false);
		invalidpreviousNumber.setBounds(330, 280, 220, 45);
		invalidpreviousNumber.setFont(new Font("Roboto", 1, 10));
		invalidpreviousNumber.setForeground(Color.red);
		left.add(invalidpreviousNumber);

		predictionStatusLabel = new JLabel("Prediction Status");
		predictionStatusLabel.setVisible(true);
		predictionStatusLabel.setBounds(180, 20, 300, 45);
		predictionStatusLabel.setFont(new Font("Roboto", 1, 25));
		predictionStatusLabel.setForeground(Color.DARK_GRAY);
		right.add(predictionStatusLabel);

		color = new JLabel("Color : ");
		color.setVisible(true);
		color.setBounds(350, 210, 300, 45);
		color.setFont(new Font("Roboto", 1, 25));
		color.setForeground(Color.DARK_GRAY);
		right.add(color);
	}

	private static void setTextFields() {
		period = new JTextField();
		period.setVisible(true);
		period.setBounds(50, 80, 220, 40);
		period.setFont(new Font("Roboto", 1, 20));
		period.setBorder(new LineBorder(Color.black));
		period.setForeground(Color.black);
		period.setBackground(Color.LIGHT_GRAY);
		period.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					Integer.parseInt(period.getText());
					if (period.getText().length() == 3) {

					} else {
						period.setBorder(new LineBorder(Color.red, 3));
						invalidPeriod.setVisible(true);
						submit.setEnabled(false);
					}
				} catch (NumberFormatException ae) {
					period.setBorder(new LineBorder(Color.red, 3));
					invalidPeriod.setVisible(true);
					submit.setEnabled(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		left.add(period);

		currentNumber = new JTextField();
		currentNumber.setVisible(true);
		currentNumber.setBounds(50, 180, 270, 40);
		currentNumber.setFont(new Font("Roboto", 1, 20));
		currentNumber.setBorder(new LineBorder(Color.black));
		currentNumber.setForeground(Color.black);
		currentNumber.setBackground(Color.LIGHT_GRAY);
		currentNumber.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					Integer.parseInt(period.getText());
					if (period.getText().length() == 3) {
						submit.setEnabled(true);
					} else {
						period.setBorder(new LineBorder(Color.red, 3));
						invalidPeriod.setVisible(true);
						submit.setEnabled(false);
					}
					Integer.parseInt(currentNumber.getText());
					if (currentNumber.getText().length() == 1) {

					} else {
						currentNumber.setBorder(new LineBorder(Color.red, 3));
						invalidcurrentNumber.setVisible(true);
						submit.setEnabled(true);
					}
				} catch (NumberFormatException ae) {
					currentNumber.setBorder(new LineBorder(Color.red, 3));
					invalidcurrentNumber.setVisible(true);
					submit.setEnabled(false);
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					Integer.parseInt(period.getText());
					if (period.getText().length() == 3) {
						invalidPeriod.setVisible(false);
						period.setBorder(new LineBorder(Color.BLACK, 2));
						submit.setEnabled(true);
					} else {
						period.setBorder(new LineBorder(Color.red, 3));
						invalidPeriod.setVisible(true);
						submit.setEnabled(false);
					}
				} catch (NumberFormatException ae) {
					period.setBorder(new LineBorder(Color.red, 3));
					invalidPeriod.setVisible(true);
					submit.setEnabled(false);
				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		left.add(currentNumber);

		previousNumber = new JTextField();
		previousNumber.setVisible(true);
		previousNumber.setBounds(50, 280, 220, 40);
		previousNumber.setFont(new Font("Roboto", 1, 20));
		previousNumber.setBorder(new LineBorder(Color.black));
		previousNumber.setForeground(Color.black);
		previousNumber.setBackground(Color.LIGHT_GRAY);
		previousNumber.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {

					Integer.parseInt(previousNumber.getText());
					if (previousNumber.getText().length() == 1) {
						previousNumber.setBorder(new LineBorder(Color.black, 2));
						invalidpreviousNumber.setVisible(false);
						submit.setEnabled(true);
					} else {
						previousNumber.setBorder(new LineBorder(Color.red, 3));
						invalidpreviousNumber.setVisible(true);
						submit.setEnabled(false);
					}
				} catch (NumberFormatException ae) {
					previousNumber.setBorder(new LineBorder(Color.red, 3));
					invalidpreviousNumber.setVisible(true);
					submit.setEnabled(false);
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					Integer.parseInt(period.getText());
					if (period.getText().length() == 3) {
						invalidPeriod.setVisible(false);
						submit.setEnabled(true);
					} else {
						period.setBorder(new LineBorder(Color.red, 3));
						invalidPeriod.setVisible(true);
						submit.setEnabled(false);
					}
					Integer.parseInt(currentNumber.getText());
					if (currentNumber.getText().length() == 1) {
						currentNumber.setBorder(new LineBorder(Color.BLACK, 2));
						invalidcurrentNumber.setVisible(false);
						submit.setEnabled(true);
					} else {
						currentNumber.setBorder(new LineBorder(Color.red, 3));
						invalidcurrentNumber.setVisible(true);
						submit.setEnabled(false);
					}
				} catch (NumberFormatException ae) {

				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		left.add(previousNumber);

		periodFV = new JTextField();
		periodFV.setVisible(true);
		periodFV.setBounds(50, 100, 250, 40);
		periodFV.setFont(new Font("Roboto", 1, 18));
		periodFV.setBorder(new LineBorder(Color.white));
		periodFV.setForeground(Color.black);
		periodFV.setBackground(Color.white);
		periodFV.setEditable(false);
		periodFV.setText("Period Number is : ");
		right.add(periodFV);

		currentNumberFV = new JTextField();
		currentNumberFV.setVisible(true);
		currentNumberFV.setBounds(50, 200, 250, 40);
		currentNumberFV.setFont(new Font("Roboto", 1, 18));
		currentNumberFV.setBorder(new LineBorder(Color.white));
		currentNumberFV.setForeground(Color.black);
		currentNumberFV.setBackground(Color.white);
		currentNumberFV.setEditable(false);
		currentNumberFV.setText("Current Number is : ");
		right.add(currentNumberFV);

		previousNumberFV = new JTextField();
		previousNumberFV.setVisible(true);
		previousNumberFV.setBounds(50, 300, 250, 40);
		previousNumberFV.setFont(new Font("Roboto", 1, 18));
		previousNumberFV.setBorder(new LineBorder(Color.white));
		previousNumberFV.setForeground(Color.black);
		previousNumberFV.setBackground(Color.white);
		previousNumberFV.setEditable(false);
		previousNumberFV.setText("Previous Number is : ");
		right.add(previousNumberFV);

		status = new JTextField();
		status.setVisible(true);
		status.setBounds(350, 140, 200, 40);
		status.setFont(new Font("Roboto", 1, 18));
		status.setBorder(new LineBorder(Color.white));
		status.setForeground(Color.DARK_GRAY);
		status.setBackground(Color.WHITE);
		status.setEditable(false);
		status.setText("Status : -");
		right.add(status);
	}

	private static void setButton() {
		addPeriod = new JButton("+");
		addPeriod.setVisible(true);
		addPeriod.setBounds(270, 80, 50, 40);
		addPeriod.setFont(new Font("Ubuntu", 1, 18));
		addPeriod.setForeground(Color.black);
		addPeriod.setBackground(Color.LIGHT_GRAY);
		addPeriod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int tempData = Integer.parseInt(period.getText());
				tempData++;
				period.setText(Integer.toString(tempData));
			}
		});
		left.add(addPeriod);

		addPrevious = new JButton("+");
		addPrevious.setVisible(true);
		addPrevious.setBounds(270, 280, 50, 40);
		addPrevious.setFont(new Font("Ubuntu", 1, 18));
		addPrevious.setForeground(Color.black);
		addPrevious.setBackground(Color.LIGHT_GRAY);
		addPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				previousNumber.setText(currentNumber.getText());
				currentNumber.setText(null);
			}
		});
		left.add(addPrevious);

		submit = new JButton("Submit");
		submit.setVisible(true);
		submit.setBounds(70, 340, 200, 45);
		submit.setFont(new Font("Ubuntu", 1, 18));
		submit.setBackground(Color.decode("#2E4053"));
		submit.setForeground(Color.white);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (period.getText().length() == 3 && currentNumber.getText().length() == 1
						&& previousNumber.getText().length() == 1) {
					executeOutput();
				} else {

				}

			}
		});
		left.add(submit);

		reset = new JButton("Reset");
		reset.setVisible(true);
		reset.setBounds(290, 340, 200, 45);
		reset.setFont(new Font("Ubuntu", 1, 18));
		reset.setBackground(Color.black);
		reset.setForeground(Color.white);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				period.setText(null);
				currentNumber.setText(null);
				previousNumber.setText(null);
				invalidPeriod.setVisible(false);
				invalidcurrentNumber.setVisible(false);
				invalidpreviousNumber.setVisible(false);
				period.setBorder(new LineBorder(Color.BLACK, 2));
				currentNumber.setBorder(new LineBorder(Color.BLACK, 2));
				previousNumber.setBorder(new LineBorder(Color.BLACK, 2));
				periodFV.setText("Period Number is : ");
				previousNumberFV.setText("Previous Number is : ");
				currentNumberFV.setText("Current Number is : ");
				color.setForeground(Color.DARK_GRAY);
				status.setBackground(Color.white);
				status.setForeground(Color.BLACK);
				status.setBorder(new LineBorder(Color.white, 0));
				status.setText("Status : -");
				colorPanel.setBackground(Color.LIGHT_GRAY);
				colorPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
			}
		});
		left.add(reset);

		viewTable = new JButton("View Table");
		viewTable.setVisible(true);
		viewTable.setBounds(80, 630, 140, 40);
		viewTable.setFont(new Font("Ubuntu", 1, 18));
		viewTable.setBackground(Color.black);
		viewTable.setForeground(Color.white);
		viewTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewTable.setVisible(false);
				JButton viewStatus = new JButton("View Status");
				viewStatus.setVisible(true);
				viewStatus.setBounds(80, 630, 140, 40);
				viewStatus.setFont(new Font("Ubuntu", 1, 18));
				viewStatus.setBackground(Color.black);
				viewStatus.setForeground(Color.white);
				viewStatus.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						viewStatus.setVisible(false);
						viewTable.setVisible(true);

					}
				});
				frame.add(viewStatus);

			}
		});
		frame.add(viewTable);

		save = new JButton("Save");
		save.setVisible(true);
		save.setBounds(250, 630, 140, 40);
		save.setFont(new Font("Ubuntu", 1, 18));
		save.setBackground(Color.decode("#238534"));
		save.setForeground(Color.white);
		frame.add(save);

		exit = new JButton("Exit");
		exit.setVisible(true);
		exit.setBounds(420, 630, 140, 40);
		exit.setFont(new Font("Ubuntu", 1, 18));
		exit.setBackground(Color.decode("#f44336"));
		exit.setForeground(Color.white);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		frame.add(exit);
		frame.setSize(1300, 741);
	}

	private static void executeOutput() {
		backendJava.DataJavaBean.setPeriod(Integer.parseInt(period.getText()));
		backendJava.DataJavaBean.setCurrentNumber(Integer.parseInt(currentNumber.getText()));
		backendJava.DataJavaBean.setPreviousNumber(Integer.parseInt(previousNumber.getText()));
		backendJava.CalculateOutput.calculate();
		periodFV.setText("Period Number is : " + Integer.toString(backendJava.DataJavaBean.getPeriod()));
		currentNumberFV.setText("Current Number is : " + Integer.toString(backendJava.DataJavaBean.getCurrentNumber()));
		previousNumberFV
				.setText("Previous Number is : " + Integer.toString(backendJava.DataJavaBean.getPreviousNumber()));
		if (backendJava.DataJavaBean.getStatus() == true) {
			colorPanel.setBackground(Color.red);
			status.setForeground(Color.white);
			status.setBackground(Color.red);
			status.setBorder(new LineBorder(Color.red, 3));
			colorPanel.setBorder(new LineBorder(Color.red, 3));
			status.setText("Status : Even");
		} else {
			colorPanel.setBackground(Color.green);
			status.setForeground(Color.white);
			status.setBackground(Color.green);
			status.setBorder(new LineBorder(Color.green, 3));
			colorPanel.setBorder(new LineBorder(Color.green, 3));
			status.setText("Status : Odd");
		}

	}

	public static void main(String[] args) {
		new Main();
	}

}
