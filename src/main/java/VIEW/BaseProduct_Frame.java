package VIEW;

import MODEL.MenuItem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class BaseProduct_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldRating;
	private JTextField textFieldCalories;
	private JTextField textFieldProteins;
	private JTextField textFieldFats;
	private JTextField textFieldSodium;
	private JTextField textFieldPrice;
	private JButton btnProduct;
	MenuItem menuItemm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseProduct_Frame frame = new BaseProduct_Frame();
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
	public BaseProduct_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBackground(new Color(0, 102, 153));
		textFieldName.setBounds(197, 11, 150, 25);
		contentPane.add(textFieldName);
		
		textFieldRating = new JTextField();
		textFieldRating.setForeground(Color.WHITE);
		textFieldRating.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldRating.setColumns(10);
		textFieldRating.setBackground(new Color(0, 102, 153));
		textFieldRating.setBounds(197, 55, 150, 25);
		contentPane.add(textFieldRating);
		
		JLabel lblName = new JLabel("Name : \r\n");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(76, 11, 90, 25);
		contentPane.add(lblName);
		
		JLabel lblRating = new JLabel("Rating : \r\n");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRating.setBounds(76, 57, 90, 25);
		contentPane.add(lblRating);
		
		JLabel lblCalories = new JLabel("Calories :");
		lblCalories.setForeground(Color.WHITE);
		lblCalories.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCalories.setBounds(76, 93, 90, 25);
		contentPane.add(lblCalories);
		
		JLabel lblProteins = new JLabel("Proteins : \r\n");
		lblProteins.setForeground(Color.WHITE);
		lblProteins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProteins.setBounds(76, 139, 90, 25);
		contentPane.add(lblProteins);
		
		JLabel lblFats = new JLabel("Fats : \r\n");
		lblFats.setForeground(Color.WHITE);
		lblFats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFats.setBounds(76, 185, 90, 25);
		contentPane.add(lblFats);
		
		JLabel lblSodium = new JLabel("Sodium : \r\n");
		lblSodium.setForeground(Color.WHITE);
		lblSodium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSodium.setBounds(76, 231, 90, 25);
		contentPane.add(lblSodium);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(76, 277, 90, 25);
		contentPane.add(lblPrice);
		
		textFieldCalories = new JTextField();
		textFieldCalories.setForeground(Color.WHITE);
		textFieldCalories.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldCalories.setColumns(10);
		textFieldCalories.setBackground(new Color(0, 102, 153));
		textFieldCalories.setBounds(197, 99, 150, 25);
		contentPane.add(textFieldCalories);
		
		textFieldProteins = new JTextField();
		textFieldProteins.setForeground(Color.WHITE);
		textFieldProteins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldProteins.setColumns(10);
		textFieldProteins.setBackground(new Color(0, 102, 153));
		textFieldProteins.setBounds(197, 143, 150, 25);
		contentPane.add(textFieldProteins);
		
		textFieldFats = new JTextField();
		textFieldFats.setForeground(Color.WHITE);
		textFieldFats.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldFats.setColumns(10);
		textFieldFats.setBackground(new Color(0, 102, 153));
		textFieldFats.setBounds(197, 187, 150, 25);
		contentPane.add(textFieldFats);
		
		textFieldSodium = new JTextField();
		textFieldSodium.setForeground(Color.WHITE);
		textFieldSodium.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldSodium.setColumns(10);
		textFieldSodium.setBackground(new Color(0, 102, 153));
		textFieldSodium.setBounds(197, 231, 150, 25);
		contentPane.add(textFieldSodium);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setForeground(Color.WHITE);
		textFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBackground(new Color(0, 102, 153));
		textFieldPrice.setBounds(197, 275, 150, 25);
		contentPane.add(textFieldPrice);

		btnProduct = new JButton("Create");
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnProduct.setFocusPainted(false);
		btnProduct.setBackground(new Color(255, 51, 0));
		btnProduct.setBounds(161, 319, 113, 44);
		contentPane.add(btnProduct);
	}

	public void choise(MenuItem item)
	{
		if(item!=null)
		{
			textFieldName.setText(item.getTitle());
			textFieldRating.setText(String.valueOf(item.getRating()));
			textFieldCalories.setText(String.valueOf(item.getCalories()));
			textFieldProteins.setText(String.valueOf(item.getProteins()));
			textFieldFats.setText(String.valueOf(item.getFats()));
			textFieldSodium.setText(String.valueOf(item.getSodium()));
			textFieldPrice.setText(String.valueOf(item.getPrice()));
			btnProduct.setText("Edit");
			menuItemm=item;
		}
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldRating() {
		return textFieldRating;
	}

	public JTextField getTextFieldCalories() {
		return textFieldCalories;
	}

	public JTextField getTextFieldProteins() {
		return textFieldProteins;
	}

	public JTextField getTextFieldFats() {
		return textFieldFats;
	}

	public JTextField getTextFieldSodium() {
		return textFieldSodium;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public JButton getBtnProduct() {
		return btnProduct;
	}

	public MenuItem getMenuItemm() {
		return menuItemm;
	}
}
