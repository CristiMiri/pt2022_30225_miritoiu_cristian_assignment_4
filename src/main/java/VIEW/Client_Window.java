package VIEW;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class Client_Window extends JFrame {

	private JTable tableProducts;
	private JTextField textFieldName;
	private JTable tableCart;
	private JButton btnAddToCart;
	private JButton btnRemoveFromCart;
	private JButton btnCommand;
	private JButton btnFilterOut;
	private JComboBox<String> comboBoxProteins;
	private JComboBox<String> comboBoxFats;
	private JComboBox<String> comboBoxSodium;
	private JComboBox<String> comboBoxPrice;
	private JComboBox<String> comboBoxCalories;
	private JComboBox<String> comboBoxRating;
	/**
	 * Create the frame.
	 */
	public Client_Window() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 570);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 20, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPaneProducts = new JScrollPane();
		scrollPaneProducts.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPaneProducts.setBackground(new Color(0, 20, 79));
		scrollPaneProducts.setBounds(0, 0, 350, 533);
		contentPane.add(scrollPaneProducts);
		scrollPaneProducts.getViewport().setBackground(new Color(245, 174, 24));
		tableProducts = new JTable();
		tableProducts.setForeground(Color.WHITE);
		tableProducts.getTableHeader().setBackground(new Color(245, 174, 24));
		tableProducts.getTableHeader().setForeground(new Color(55, 41, 2));
		tableProducts.setBackground(new Color(243, 190, 148));
		tableProducts.getTableHeader().setReorderingAllowed(false);
		tableProducts.setAutoCreateRowSorter(true);
		tableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneProducts.setViewportView(tableProducts);

		textFieldName = new JTextField();
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBackground(new Color(0, 102, 153));
		textFieldName.setBounds(510, 11, 150, 25);
		contentPane.add(textFieldName);

		JLabel lblName = new JLabel("Name : \r\n");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(389, 11, 90, 25);
		contentPane.add(lblName);

		JLabel lblRating = new JLabel("Rating : \r\n");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRating.setBounds(389, 57, 90, 25);
		contentPane.add(lblRating);

		JLabel lblCalories = new JLabel("Calories :");
		lblCalories.setForeground(Color.WHITE);
		lblCalories.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCalories.setBounds(389, 103, 90, 25);
		contentPane.add(lblCalories);

		JLabel lblProteins = new JLabel("Proteins : \r\n");
		lblProteins.setForeground(Color.WHITE);
		lblProteins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProteins.setBounds(389, 149, 90, 25);
		contentPane.add(lblProteins);

		JLabel lblFats = new JLabel("Fats : \r\n");
		lblFats.setForeground(Color.WHITE);
		lblFats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFats.setBounds(389, 195, 90, 25);
		contentPane.add(lblFats);

		JLabel lblSodium = new JLabel("Sodium : \r\n");
		lblSodium.setForeground(Color.WHITE);
		lblSodium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSodium.setBounds(389, 241, 90, 25);
		contentPane.add(lblSodium);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(389, 287, 90, 25);
		contentPane.add(lblPrice);

		JScrollPane scrollPaneCart = new JScrollPane();
		scrollPaneCart.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPaneCart.getViewport().setBackground(new Color(245, 174, 24));
		scrollPaneCart.setBounds(716, 0, 370, 533);
		contentPane.add(scrollPaneCart);

		tableCart = new JTable();
		tableCart.setForeground(Color.WHITE);
		tableCart.getTableHeader().setBackground(new Color(245, 174, 24));
		tableCart.getTableHeader().setForeground(new Color(55, 41, 2));
		tableCart.setBackground(new Color(243, 190, 148));
		tableCart.getTableHeader().setReorderingAllowed(false);
		tableCart.setAutoCreateRowSorter(true);
		tableCart.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneCart.setViewportView(tableCart);

		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setForeground(Color.WHITE);
		btnAddToCart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAddToCart.setFocusPainted(false);
		btnAddToCart.setBackground(new Color(255, 51, 0));
		btnAddToCart.setBounds(389, 360, 113, 44);
		contentPane.add(btnAddToCart);

		btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setForeground(Color.WHITE);
		btnRemoveFromCart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRemoveFromCart.setFocusPainted(false);
		btnRemoveFromCart.setBackground(new Color(255, 51, 0));
		btnRemoveFromCart.setBounds(556, 360, 150, 44);
		contentPane.add(btnRemoveFromCart);

		btnFilterOut = new JButton("Filter out");
		btnFilterOut.setForeground(Color.WHITE);
		btnFilterOut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnFilterOut.setFocusPainted(false);
		btnFilterOut.setBackground(new Color(255, 51, 0));
		btnFilterOut.setBounds(389, 440, 113, 44);
		contentPane.add(btnFilterOut);

		btnCommand = new JButton("Order Cart");
		btnCommand.setForeground(Color.WHITE);
		btnCommand.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCommand.setFocusPainted(false);
		btnCommand.setBackground(new Color(255, 51, 0));
		btnCommand.setBounds(556, 440, 150, 44);
		contentPane.add(btnCommand);

		comboBoxRating = new JComboBox<>();
		comboBoxRating.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-1", "1-2", "2-3", "3-4", "4-5", "5>"}));
		comboBoxRating.setForeground(Color.WHITE);
		comboBoxRating.setBackground(new Color(0, 102, 153));
		comboBoxRating.setBounds(510, 47, 150, 25);
		contentPane.add(comboBoxRating);

		comboBoxCalories = new JComboBox<>();
		comboBoxCalories.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-50", "50-100", "100-500", "500-1000", "1000>"}));
		comboBoxCalories.setForeground(Color.WHITE);
		comboBoxCalories.setBackground(new Color(0, 102, 153));
		comboBoxCalories.setBounds(510, 106, 150, 25);
		contentPane.add(comboBoxCalories);

		comboBoxProteins = new JComboBox<>();
		comboBoxProteins.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-25", "25-50", "50-75", "75-100", "100-500", "500>"}));
		comboBoxProteins.setForeground(Color.WHITE);
		comboBoxProteins.setBackground(new Color(0, 102, 153));
		comboBoxProteins.setBounds(510, 152, 150, 25);
		contentPane.add(comboBoxProteins);

		comboBoxFats = new JComboBox<>();
		comboBoxFats.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-50", "50-100", "100-500", "500-1000", "1000>"}));
		comboBoxFats.setForeground(Color.WHITE);
		comboBoxFats.setBackground(new Color(0, 102, 153));
		comboBoxFats.setBounds(510, 198, 150, 25);
		contentPane.add(comboBoxFats);

		comboBoxSodium = new JComboBox<>();
		comboBoxSodium.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-100", "100-500", "500-1000", "1000-5000", "5000>"}));
		comboBoxSodium.setForeground(Color.WHITE);
		comboBoxSodium.setBackground(new Color(0, 102, 153));
		comboBoxSodium.setBounds(510, 244, 150, 25);
		contentPane.add(comboBoxSodium);

		comboBoxPrice = new JComboBox<>();
		comboBoxPrice.setModel(new DefaultComboBoxModel<>(new String[] {"No choice","0-10", "10-20", "20-30", "30-40", "40-50", "50-60", "60-70", "70-80", "80-90", "90-100","100>"}));
		comboBoxPrice.setForeground(Color.WHITE);
		comboBoxPrice.setBackground(new Color(0, 102, 153));
		comboBoxPrice.setBounds(510, 290, 150, 25);
		contentPane.add(comboBoxPrice);
	}


	//Table getters
	public JTable getTableProducts() {
		return tableProducts;
	}

	public JTable getTableCart() {
		return tableCart;
	}

	//Button getters
	public JButton getBtnAddToCart() {
		return btnAddToCart;
	}

	public JButton getBtnRemoveFromCart() {
		return btnRemoveFromCart;
	}

	public JButton getBtnCommand() {
		return btnCommand;
	}

	public JButton getBtnFilterOut() {
		return btnFilterOut;
	}

	//Combobox getters
	public JComboBox<String> getComboBoxProteins() {
		return comboBoxProteins;
	}

	public JComboBox<String> getComboBoxFats() {
		return comboBoxFats;
	}

	public JComboBox<String> getComboBoxSodium() {
		return comboBoxSodium;
	}

	public JComboBox<String> getComboBoxPrice() {
		return comboBoxPrice;
	}

	public JComboBox<String> getComboBoxCalories() {
		return comboBoxCalories;
	}

	public JComboBox<String> getComboBoxRating() {
		return comboBoxRating;
	}

	//TextField getters

	public JTextField getTextFieldName() {
		return textFieldName;
	}
}
