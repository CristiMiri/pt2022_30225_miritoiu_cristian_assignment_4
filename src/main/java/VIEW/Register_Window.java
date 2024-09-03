package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Register_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JLabel lblPassword;
	private JLabel lblPassword_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirm;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Window frame = new Register_Window();
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
	public Register_Window() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setForeground(Color.WHITE);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBackground(new Color(0, 102, 153));
		textUsername.setBounds(118, 28, 150, 25);
		contentPane.add(textUsername);
		
		JLabel lblNewLabel = new JLabel("UserName : \r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 27, 90, 25);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("Password : \r\n");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(30, 78, 80, 25);
		contentPane.add(lblPassword);
		
		lblPassword_1 = new JLabel("Password : \r\n");
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(30, 128, 80, 25);
		contentPane.add(lblPassword_1);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegister.setFocusPainted(false);
		btnRegister.setBackground(new Color(255, 51, 0));
		btnRegister.setBounds(136, 193, 113, 44);
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setEchoChar('*');
		passwordField.setBackground(new Color(0, 102, 153));
		passwordField.setBounds(118, 78, 150, 25);
		contentPane.add(passwordField);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setForeground(Color.WHITE);
		passwordField_confirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField_confirm.setEchoChar('*');
		passwordField_confirm.setBackground(new Color(0, 102, 153));
		passwordField_confirm.setBounds(118, 128, 150, 25);
		contentPane.add(passwordField_confirm);
	}

	public JTextField getTextUsername() {
		return textUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JPasswordField getPasswordField_confirm() {
		return passwordField_confirm;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}
}
