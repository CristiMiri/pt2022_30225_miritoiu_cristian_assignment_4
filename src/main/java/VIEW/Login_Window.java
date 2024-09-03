package VIEW;

import CONTROLLER.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("unused")
public class Login_Window extends JFrame {

    private JPanel contentPane;
    private JTextField text_Username;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private Register_Window register_window;
    private JButton btnRegister;
    /**
     * Create the frame.
     */
    public Login_Window(Controller controller) {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 51, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        text_Username = new JTextField();
        text_Username.setBackground(new Color(0, 102, 153));
        text_Username.setForeground(Color.WHITE);
        text_Username.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        text_Username.setBounds(143, 64, 150, 25);
        contentPane.add(text_Username);
        text_Username.setColumns(10);

        JLabel lblNewLabel = new JLabel("UserName : \r\n");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(30, 68, 90, 25);
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password : \r\n");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblPassword.setBounds(30, 154, 80, 25);
        contentPane.add(lblPassword);

        btnLogin = new JButton("Login\r\n");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(255, 51, 0));
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnLogin.setBounds(70, 208, 113, 44);
        contentPane.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnRegister.setFocusPainted(false);
        btnRegister.setBackground(new Color(255, 51, 0));
        btnRegister.setBounds(253, 208, 113, 44);
        contentPane.add(btnRegister);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(0, 102, 153));
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordField.setBounds(143, 155, 150, 25);
        contentPane.add(passwordField);
    }

    public JTextField getText_Username() {
        return text_Username;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public Register_Window getRegister_window() {
        return register_window;
    }

    public void setRegister_window(Register_Window register_window) {
        this.register_window = register_window;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }
}

