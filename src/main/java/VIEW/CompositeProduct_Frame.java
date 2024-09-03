package VIEW;

import MODEL.CompositeProduct;
import MODEL.MenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class CompositeProduct_Frame extends JFrame {

	private JTable tableProducts;
	private JTextField textFieldName;
	private JTable tableList;
	private JButton btnAddToList;
	private JButton btnRemoveFromList;
	private JButton btnAction;
	private JTextField textFieldRating;
	private JTextField textFieldCalories;
	private JTextField textFieldProteins;
	private JTextField textFieldFats;
	private JTextField textFieldSodium;
	private JTextField textFieldPrice;
	private CompositeProduct item;
	/**
	 * Create the frame.
	 */
	public CompositeProduct_Frame() {
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
		textFieldName.setBounds(510, 20, 150, 25);
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

		tableList = new JTable();
		tableList.setForeground(Color.WHITE);
		tableList.getTableHeader().setBackground(new Color(245, 174, 24));
		tableList.getTableHeader().setForeground(new Color(55, 41, 2));
		tableList.setBackground(new Color(243, 190, 148));
		tableList.getTableHeader().setReorderingAllowed(false);
		tableList.setAutoCreateRowSorter(true);
		tableList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneCart.setViewportView(tableList);

		btnAddToList = new JButton("Add to List");
		btnAddToList.setForeground(Color.WHITE);
		btnAddToList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAddToList.setFocusPainted(false);
		btnAddToList.setBackground(new Color(255, 51, 0));
		btnAddToList.setBounds(468, 335, 150, 44);
		contentPane.add(btnAddToList);

		btnRemoveFromList = new JButton("Remove from List");
		btnRemoveFromList.setForeground(Color.WHITE);
		btnRemoveFromList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRemoveFromList.setFocusPainted(false);
		btnRemoveFromList.setBackground(new Color(255, 51, 0));
		btnRemoveFromList.setBounds(468, 399, 150, 44);
		contentPane.add(btnRemoveFromList);

		btnAction = new JButton("Create");
		btnAction.setForeground(Color.WHITE);
		btnAction.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAction.setFocusPainted(false);
		btnAction.setBackground(new Color(255, 51, 0));
		btnAction.setBounds(468, 463, 150, 44);
		contentPane.add(btnAction);

		textFieldRating = new JTextField();
		textFieldRating.setForeground(Color.WHITE);
		textFieldRating.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldRating.setColumns(10);
		textFieldRating.setBackground(new Color(0, 102, 153));
		textFieldRating.setBounds(510, 65, 150, 25);
		contentPane.add(textFieldRating);

		textFieldCalories = new JTextField();
		textFieldCalories.setForeground(Color.WHITE);
		textFieldCalories.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldCalories.setColumns(10);
		textFieldCalories.setBackground(new Color(0, 102, 153));
		textFieldCalories.setBounds(510, 110, 150, 25);
		contentPane.add(textFieldCalories);

		textFieldProteins = new JTextField();
		textFieldProteins.setForeground(Color.WHITE);
		textFieldProteins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldProteins.setColumns(10);
		textFieldProteins.setBackground(new Color(0, 102, 153));
		textFieldProteins.setBounds(510, 155, 150, 25);
		contentPane.add(textFieldProteins);

		textFieldFats = new JTextField();
		textFieldFats.setForeground(Color.WHITE);
		textFieldFats.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldFats.setColumns(10);
		textFieldFats.setBackground(new Color(0, 102, 153));
		textFieldFats.setBounds(510, 200, 150, 25);
		contentPane.add(textFieldFats);

		textFieldSodium = new JTextField();
		textFieldSodium.setForeground(Color.WHITE);
		textFieldSodium.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldSodium.setColumns(10);
		textFieldSodium.setBackground(new Color(0, 102, 153));
		textFieldSodium.setBounds(510, 245, 150, 25);
		contentPane.add(textFieldSodium);

		textFieldPrice = new JTextField();
		textFieldPrice.setForeground(Color.WHITE);
		textFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBackground(new Color(0, 102, 153));
		textFieldPrice.setBounds(510, 290, 150, 25);
		contentPane.add(textFieldPrice);
	}

	public void choise(MenuItem menuItem_edit)
	{
		textFieldName.setText(menuItem_edit.getTitle());
		textFieldRating.setText(String.valueOf(menuItem_edit.getRating()));
		textFieldCalories.setText(String.valueOf(menuItem_edit.getCalories()));
		textFieldProteins.setText(String.valueOf(menuItem_edit.getProteins()));
		textFieldFats.setText(String.valueOf(menuItem_edit.getFats()));
		textFieldSodium.setText(String.valueOf(menuItem_edit.getSodium()));
		textFieldPrice.setText(String.valueOf(menuItem_edit.getPrice()));
		btnAction.setText("Edit");
		item= (CompositeProduct) menuItem_edit;
	}
	//Table getters
	public JTable getTableProducts() {
		return tableProducts;
	}

	public JTable getTableList() {
		return tableList;
	}

	//Button getters

	public JButton getBtnAddToList() {
		return btnAddToList;
	}

	public JButton getBtnRemoveFromList() {
		return btnRemoveFromList;
	}

	public JButton getBtnAction() {
		return btnAction;
	}


	//TextField getters

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

	public CompositeProduct getItem() {
		return item;
	}
}
