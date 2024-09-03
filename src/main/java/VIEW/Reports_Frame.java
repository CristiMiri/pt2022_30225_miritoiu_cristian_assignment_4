package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Reports_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaxHour;
	private JTextField textFieldMinHour;
	private JTextField textFieldProductsOrderd;
	private JTextField textFieldClientsAmount;
	private JTextField textFieldTotalPrice;
	private JTextField textFieldDay;
	private JTextField textFieldProductDay;
	private JButton btnGenerate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports_Frame frame = new Reports_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reports_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldMaxHour = new JTextField();
		textFieldMaxHour.setForeground(Color.WHITE);
		textFieldMaxHour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldMaxHour.setColumns(10);
		textFieldMaxHour.setBackground(new Color(0, 102, 153));
		textFieldMaxHour.setBounds(192, 43, 90, 25);
		contentPane.add(textFieldMaxHour);
		
		JLabel lblHourInterval = new JLabel("Hour Interval :");
		lblHourInterval.setForeground(Color.WHITE);
		lblHourInterval.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHourInterval.setBounds(10, 11, 120, 25);
		contentPane.add(lblHourInterval);
		
		textFieldMinHour = new JTextField();
		textFieldMinHour.setForeground(Color.WHITE);
		textFieldMinHour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldMinHour.setColumns(10);
		textFieldMinHour.setBackground(new Color(0, 102, 153));
		textFieldMinHour.setBounds(10, 43, 90, 25);
		contentPane.add(textFieldMinHour);
		
		JLabel lblProductsOrderedFor = new JLabel("Products ordered for a specified amount :");
		lblProductsOrderedFor.setForeground(Color.WHITE);
		lblProductsOrderedFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductsOrderedFor.setBounds(10, 79, 305, 25);
		contentPane.add(lblProductsOrderedFor);
		
		textFieldProductsOrderd = new JTextField();
		textFieldProductsOrderd.setForeground(Color.WHITE);
		textFieldProductsOrderd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldProductsOrderd.setColumns(10);
		textFieldProductsOrderd.setBackground(new Color(0, 102, 153));
		textFieldProductsOrderd.setBounds(10, 115, 90, 25);
		contentPane.add(textFieldProductsOrderd);
		
		JLabel lblClientOrderedFor = new JLabel("Client ordered for a specified amount and total price of order:");
		lblClientOrderedFor.setForeground(Color.WHITE);
		lblClientOrderedFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientOrderedFor.setBounds(10, 151, 416, 25);
		contentPane.add(lblClientOrderedFor);
		
		textFieldClientsAmount = new JTextField();
		textFieldClientsAmount.setForeground(Color.WHITE);
		textFieldClientsAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldClientsAmount.setColumns(10);
		textFieldClientsAmount.setBackground(new Color(0, 102, 153));
		textFieldClientsAmount.setBounds(10, 187, 90, 25);
		contentPane.add(textFieldClientsAmount);
		
		textFieldTotalPrice = new JTextField();
		textFieldTotalPrice.setForeground(Color.WHITE);
		textFieldTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldTotalPrice.setColumns(10);
		textFieldTotalPrice.setBackground(new Color(0, 102, 153));
		textFieldTotalPrice.setBounds(192, 187, 90, 25);
		contentPane.add(textFieldTotalPrice);
		
		JLabel lblProductsOrderedWithin = new JLabel("Products ordered within a specified day and number of times :");
		lblProductsOrderedWithin.setForeground(Color.WHITE);
		lblProductsOrderedWithin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductsOrderedWithin.setBounds(10, 223, 436, 25);
		contentPane.add(lblProductsOrderedWithin);
		
		textFieldDay = new JTextField();
		textFieldDay.setForeground(Color.WHITE);
		textFieldDay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldDay.setColumns(10);
		textFieldDay.setBackground(new Color(0, 102, 153));
		textFieldDay.setBounds(10, 259, 90, 25);
		contentPane.add(textFieldDay);
		
		textFieldProductDay = new JTextField();
		textFieldProductDay.setForeground(Color.WHITE);
		textFieldProductDay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldProductDay.setColumns(10);
		textFieldProductDay.setBackground(new Color(0, 102, 153));
		textFieldProductDay.setBounds(192, 259, 90, 25);
		contentPane.add(textFieldProductDay);

		btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(Color.WHITE);
		btnGenerate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGenerate.setFocusPainted(false);
		btnGenerate.setBackground(new Color(255, 51, 0));
		btnGenerate.setBounds(171, 303, 113, 44);
		contentPane.add(btnGenerate);
	}

	public JTextField getTextFieldMaxHour() {
		return textFieldMaxHour;
	}

	public JTextField getTextFieldMinHour() {
		return textFieldMinHour;
	}

	public JTextField getTextFieldProductsOrderd() {
		return textFieldProductsOrderd;
	}

	public JTextField getTextFieldClientsAmount() {
		return textFieldClientsAmount;
	}

	public JTextField getTextFieldTotalPrice() {
		return textFieldTotalPrice;
	}

	public JTextField getTextFieldDay() {
		return textFieldDay;
	}

	public JTextField getTextFieldProductDay() {
		return textFieldProductDay;
	}

	public JButton getBtnGenerate() {
		return btnGenerate;
	}
}
