package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

public class Employe_Frame extends JFrame implements Observer {

	private JPanel contentPane;
	private JList notifications;
	private static DefaultComboBoxModel model=new DefaultComboBoxModel<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employe_Frame frame = new Employe_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		String mesage= (String) arg;
		DefaultComboBoxModel model= (DefaultComboBoxModel) notifications.getModel();
		model.addElement(mesage);
		System.out.println("Notify "+mesage);
		for (int i = 0; i < model.getSize(); i++) {
			System.out.println(model.getElementAt(i));
		}

	}

	/**
	 * Create the frame.
	 */
	public Employe_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(51, 0, 153));
		scrollPane.getViewport().setBackground(new Color(51, 0, 153));
		scrollPane.setBounds(10, 11, 416, 220);
		contentPane.add(scrollPane);

		for (int i = 0; i < model.getSize(); i++) {
			System.out.println(model.getElementAt(i));
		}

		notifications=new JList();
		notifications.setBackground(new Color(51, 0, 153));
		notifications.setForeground(Color.WHITE);
		notifications.setModel(model);
		scrollPane.setViewportView(notifications);
		
		JButton btnClear = new JButton("Clear ");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnClear.setFocusPainted(false);
		btnClear.setBackground(new Color(255, 51, 0));
		btnClear.setBounds(140, 238, 150, 44);
		btnClear.addActionListener(e -> {
			int row=notifications.getSelectedIndex();
			model.removeElementAt(row);
		});
		contentPane.add(btnClear);
	}
}
