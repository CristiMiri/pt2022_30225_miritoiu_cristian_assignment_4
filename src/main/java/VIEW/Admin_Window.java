package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class Admin_Window extends JFrame {

	private JPanel contentPane;
	private JTable tableProducts;
	private JButton btnEditProduct;
	private JButton btnCreateMenu;
	private JButton btnReports;
	private JButton btnDeleteProduct;
	private JButton btnCreateProduct;
	private JButton btnImportProducts;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Window frame = new Admin_Window();
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
	public Admin_Window() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 400, 549);
		contentPane.add(scrollPane);
		
		tableProducts = new JTable();
		tableProducts.setForeground(Color.WHITE);
		tableProducts.getTableHeader().setBackground(new Color(245, 174, 24));
		tableProducts.getTableHeader().setForeground(new Color(55, 41, 2));
		tableProducts.setBackground(new Color(243, 190, 148));
		tableProducts.getTableHeader().setReorderingAllowed(false);
		tableProducts.setAutoCreateRowSorter(true);
		tableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tableProducts);

		btnImportProducts = new JButton("Import Products\r\n");
		btnImportProducts.setForeground(Color.WHITE);
		btnImportProducts.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnImportProducts.setFocusPainted(false);
		btnImportProducts.setBackground(new Color(255, 51, 0));
		btnImportProducts.setBounds(470, 43, 150, 44);
		contentPane.add(btnImportProducts);

		btnCreateProduct = new JButton("Create Product");
		btnCreateProduct.setForeground(Color.WHITE);
		btnCreateProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCreateProduct.setFocusPainted(false);
		btnCreateProduct.setBackground(new Color(255, 51, 0));
		btnCreateProduct.setBounds(470, 130, 150, 44);
		contentPane.add(btnCreateProduct);

		btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.setForeground(Color.WHITE);
		btnDeleteProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDeleteProduct.setFocusPainted(false);
		btnDeleteProduct.setBackground(new Color(255, 51, 0));
		btnDeleteProduct.setBounds(470, 217, 150, 44);
		contentPane.add(btnDeleteProduct);
		
		btnEditProduct = new JButton("Edit Product");
		btnEditProduct.setForeground(Color.WHITE);
		btnEditProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEditProduct.setFocusPainted(false);
		btnEditProduct.setBackground(new Color(255, 51, 0));
		btnEditProduct.setBounds(470, 304, 150, 44);
		contentPane.add(btnEditProduct);
		
		btnCreateMenu = new JButton("Create Menu");
		btnCreateMenu.setForeground(Color.WHITE);
		btnCreateMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCreateMenu.setFocusPainted(false);
		btnCreateMenu.setBackground(new Color(255, 51, 0));
		btnCreateMenu.setBounds(470, 391, 150, 44);
		contentPane.add(btnCreateMenu);
		
		btnReports = new JButton("Reports");
		btnReports.setForeground(Color.WHITE);
		btnReports.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReports.setFocusPainted(false);
		btnReports.setBackground(new Color(255, 51, 0));
		btnReports.setBounds(470, 478, 150, 44);
		contentPane.add(btnReports);
	}

	public JTable getTableProducts() {
		return tableProducts;
	}

	public JButton getBtnDeleteProduct() {
		return btnDeleteProduct;
	}

	public JButton getBtnEditProduct() {
		return btnEditProduct;
	}

	public JButton getBtnCreateMenu() {
		return btnCreateMenu;
	}

	public JButton getBtnReports() {
		return btnReports;
	}

	public JButton getBtnCreateProduct() {
		return btnCreateProduct;
	}

	public JButton getBtnImportProducts() {
		return btnImportProducts;
	}
}
