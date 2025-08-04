import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingWorker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.Font;

public class OrderPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblOrderNow;
	private JLabel lblName;
	private JLabel lblMobileNumber;
	private JTextField textName;
	private JTextField textMobileNumber;
	private JLabel lblCategory;
	private JComboBox comboBox;
	private JLabel lblMenu;
	private JTable tableSearch;
	private JTextField textMenu;
	private JLabel lblQty;
	private JLabel lblPrice;
	private JTextField textPrice;
	private JSpinner spinner;
	private JLabel lblSum;
	private JTextField textSum;
	private JButton btnClear;
	private JButton btnAdd;
	private JTable table_1;
	private JLabel lblTotal;
	private JLabel lblTotalPrice;
	private JButton btnCheckOut;
	private JButton btnBack;
	private JLabel lblBack;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPage frame = new OrderPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private int calculateTotalPrice(String selectedMenu, int selectedQty) {
        // logic for calculating the total price based on the selected menu and quantity
        int menuPrice = getMenuPrice(selectedMenu); //a method to retrieve the price of a menu item
        return menuPrice * selectedQty;
    }

    private int getMenuPrice(String menuName) {
    	// Define a Map to store the menu prices
		Map<String, Integer> menuPrices = new HashMap<>();

		// Populate the menuPrices map with menu items and their prices
		menuPrices.put("Cheese Pizza", 10000);
		menuPrices.put("Pepperoni Pizza", 12000);
		menuPrices.put("Super Supreme Pizza", 15000);
		menuPrices.put("Beef Cheddar Pizza", 14000);
		menuPrices.put("Potato Pizza", 13000);
		menuPrices.put("BreadStix", 5000);
		menuPrices.put("CinnaStix", 6000);
		menuPrices.put("Garlic Twisty Bread", 8000);
		menuPrices.put("CheesyStix", 7000);
		menuPrices.put("Chocolate Lava Cake", 8000);
		menuPrices.put("Blueberry Cheesecake", 9000);
		menuPrices.put("Onion Rings", 4000);
		menuPrices.put("Potato Wedges", 4000);
		menuPrices.put("Mineral Water", 1000);
		menuPrices.put("Pepsi", 2000);
		menuPrices.put("Pepsi Black", 2000);
		menuPrices.put("Ice Tea Lemon", 2000);
		menuPrices.put("Twister Orange", 2000);
		// Retrieve the price of the menu item based on the provided menuName
	    Integer price = menuPrices.get(menuName);
	    if (price != null) {
	        return price;
	    } else {
	        // Handle the case when the menuName is not found in the map
	        throw new IllegalArgumentException("Invalid menu item: " + menuName);
	    }
    }
    
	// Create a SwingWorker subclass for updating the tableSearch
	class UpdateTableWorker extends SwingWorker<DefaultTableModel, Void> {
	    private String selectedCategory;

	    public UpdateTableWorker(String selectedCategory) {
	        this.selectedCategory = selectedCategory;
	    }

	    @Override
	    protected DefaultTableModel doInBackground() throws Exception {
	        // Perform the time-consuming task of updating the tableSearch
	        DefaultTableModel model = updateTableSearch(selectedCategory);
	        return model;
	    }

	    @Override
	    protected void done() {
	        try {
	            // Update the tableSearch when the task is completed
	            DefaultTableModel model = get();
	            tableSearch.setModel(model);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	// Create a SwingWorker subclass for calculating the total price
	class CalculateTotalPriceWorker extends SwingWorker<Integer, Void> {
	    private String selectedMenu;
	    private int selectedQty;

	    public CalculateTotalPriceWorker(String selectedMenu, int selectedQty) {
	        this.selectedMenu = selectedMenu;
	        this.selectedQty = selectedQty;
	    }

	    @Override
	    protected Integer doInBackground() throws Exception {
	        // Perform the time-consuming task of calculating the total price
	        int totalPrice = calculateTotalPrice(selectedMenu, selectedQty);
	        return totalPrice;
	    }

	    @Override
	    protected void done() {
	        try {
	            // Update the textSum field when the task is completed
	            int totalPrice = get();
	            textSum.setText(String.valueOf(totalPrice));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	/**
	 * Create the frame.
	 */
	public OrderPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblOrderNow = new JLabel("ORDER NOW!");
		lblOrderNow.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblOrderNow.setForeground(Color.WHITE);
		lblOrderNow.setBounds(182, -3, 204, 43);
		contentPane.add(lblOrderNow);

		lblName = new JLabel("Name: ");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblName.setBounds(22, 53, 45, 13);
		contentPane.add(lblName);

		lblMobileNumber = new JLabel("Mobile Number: ");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMobileNumber.setForeground(Color.YELLOW);
		lblMobileNumber.setBounds(22, 76, 106, 13);
		contentPane.add(lblMobileNumber);

		textName = new JTextField();
		textName.setBounds(127, 50, 147, 19);
		contentPane.add(textName);
		textName.setColumns(10);

		textMobileNumber = new JTextField();
		textMobileNumber.setBounds(127, 73, 147, 19);
		contentPane.add(textMobileNumber);
		textMobileNumber.setColumns(10);

		lblCategory = new JLabel("Category: ");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCategory.setBounds(22, 119, 77, 13);
		contentPane.add(lblCategory);

		comboBox = new JComboBox();
		// Add available categories to the combo box
		comboBox.addItem("Pizza");
		comboBox.addItem("Breads");
		comboBox.addItem("Desserts and Sides");
		comboBox.addItem("Drinks");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the selected category
				String selectedCategory = (String) comboBox.getSelectedItem();
				
				// Create an instance of UpdateTableWorker and execute it
	            UpdateTableWorker worker = new UpdateTableWorker(selectedCategory);
	            worker.execute();
			}
		});
		comboBox.setBounds(127, 115, 147, 21);
		contentPane.add(comboBox);

		lblMenu = new JLabel("Menu: ");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMenu.setBounds(295, 53, 77, 13);
		contentPane.add(lblMenu);

		tableSearch = new JTable();
		tableSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tableSearch.getSelectedRow();
				int menuColumnIndex = 1; // Assuming menu column is at index 1

				if (selectedRow != -1) {
					String selectedMenu = tableSearch.getValueAt(selectedRow, menuColumnIndex).toString();
					textMenu.setText(selectedMenu);
				}
			}
		});
		tableSearch.setBounds(127, 168, 147, 201);
		contentPane.add(tableSearch);

//		// Populate the tableSearch with all the menu items initially
//		DefaultTableModel initialTableModel = updateTableSearch("All"); // Pass "All" as the selected category
//		tableSearch.setModel(initialTableModel);

		textMenu = new JTextField();
		textMenu.setColumns(10);
		textMenu.setBounds(348, 50, 147, 19);
		contentPane.add(textMenu);

		lblQty = new JLabel("Qty: ");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(296, 90, 45, 13);
		contentPane.add(lblQty);

		lblPrice = new JLabel("Price: ");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPrice.setBounds(396, 90, 57, 13);
		contentPane.add(lblPrice);

		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(433, 87, 62, 19);
		contentPane.add(textPrice);

//		String[] spinnerValues = {"0", "1", "2", "3", "4", "5"}; // Include all non-negative numbers you want to allow
//
//		SpinnerListModel spinnerModel = new SpinnerListModel(spinnerValues);
//		SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // Set initial value to 0 and minimum value to 0
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedRow = tableSearch.getSelectedRow();
//		        int priceColumnIndex = 2; // Assuming price column is at index 2

				if (selectedRow != -1) {
					String selectedMenu = tableSearch.getValueAt(selectedRow, 1).toString();
	                int selectedQty = (int) spinner.getValue();
	                
					// Create an instance of CalculateTotalPriceWorker and execute it
	                CalculateTotalPriceWorker worker = new CalculateTotalPriceWorker(selectedMenu, selectedQty);
	                worker.execute();
	                
					// Update the textMenu and totalPrice fields
					textMenu.setText(selectedMenu);
					int menuPrice = getMenuPrice(selectedMenu);
					textPrice.setText(String.valueOf(menuPrice));
//					textSum.setText(String.valueOf(totalPrice));
				}
			}
		});
		spinner.setBounds(348, 87, 38, 20);
		contentPane.add(spinner);

		lblSum = new JLabel("Sum: ");
		lblSum.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSum.setForeground(Color.WHITE);
		lblSum.setBounds(295, 119, 57, 13);
		contentPane.add(lblSum);

		textSum = new JTextField();
		textSum.setColumns(10);
		textSum.setBounds(348, 116, 147, 19);
		contentPane.add(textSum);

		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMenu.setText("");
				spinner.setValue(0);
				textPrice.setText("");
				textSum.setText("");
			}
		});
		btnClear.setBounds(509, 86, 70, 21);
		contentPane.add(btnClear);

		// Initialize the table with columns
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Menu");
		model.addColumn("Quantity");
		model.addColumn("Total Price");
		
		table_1 = new JTable(model);
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				int totalPrice = 0;

				// Iterate over the rows of the table_1
				for (int i = 0; i < table_1.getRowCount(); i++) {
					// Get the total price from each row (assuming it is stored in the third column)
					int rowTotalPrice = (int) table_1.getValueAt(i, 2);
					// Sum up the total prices
					totalPrice += rowTotalPrice;
				}

				// Update the lblTotalPrice with the calculated total price
				lblTotalPrice.setText(String.valueOf(totalPrice));

		        // Call updateButtonState to update the button state
		       // updateButtonState();

			}
		});
		table_1.setBounds(295, 168, 284, 199);
		contentPane.add(table_1);
		// Adjust the column widths
		TableColumnModel columnModel = table_1.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(189); // Set the preferred width for the number column
		columnModel.getColumn(1).setPreferredWidth(35); // Set the preferred width for the menu column
		columnModel.getColumn(2).setPreferredWidth(60);

		// Add button ActionListener
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the selected menu and its price
				String selectedMenu = textMenu.getText();
				int menuPrice = Integer.parseInt(textPrice.getText());

				// Get the quantity from the spinner
				int quantity = (int) spinner.getValue();

				// Calculate the total price for the selected menu and quantity
				int totalPrice = menuPrice * quantity;

				// Add the selected menu, quantity, and total price to the table
				model.addRow(new Object[] { selectedMenu, quantity, totalPrice });

				textMenu.setText("");
				spinner.setValue(0);
				textPrice.setText("");
				textSum.setText("");
			}
		});

		btnAdd.setBounds(509, 115, 70, 21);
		contentPane.add(btnAdd);

		lblTotal = new JLabel("Total: KRW");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(433, 382, 62, 13);
		contentPane.add(lblTotal);

		lblTotalPrice = new JLabel("0000");
		lblTotalPrice.setForeground(Color.WHITE);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotalPrice.setBounds(509, 382, 70, 13);
		contentPane.add(lblTotalPrice);

		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBackground(Color.WHITE);
		btnCheckOut.setEnabled(false);
		// Check if the user is logged in
		if (UserSession.isLoggedIn()) {
			// User is logged in, disable the name and phone number fields
			textName.setEnabled(false);
			textMobileNumber.setEnabled(false);
			btnCheckOut.setEnabled(true);
		} else {
			// User is not logged in, enable the name and phone number fields
			textName.setEnabled(true);
			textMobileNumber.setEnabled(true);
		}
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mobileNumber = textMobileNumber.getText().trim();
				String phoneRegex = "^\\d{2} \\d{4}-\\d{4}$";
				Pattern phonePattern = Pattern.compile(phoneRegex);
				Matcher phoneMatcher = phonePattern.matcher(mobileNumber);
				if (!UserSession.isLoggedIn()) {
					if (phoneMatcher.matches()) {
						JOptionPane.showMessageDialog(OrderPage.this,
								"We've got your order and it's being processed.");
						// Clear the table after successful checkout
		                DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		                tableModel.setRowCount(0); // Remove all rows from the table          
					} else {
						// Phone number format is incorrect
						JOptionPane.showMessageDialog(OrderPage.this,
								"Invalid phone number format. Please enter in the format '10 2158-0222'.");
					}
				}else {
					JOptionPane.showMessageDialog(OrderPage.this,
							"We've got your order and it's being processed.");
					// Clear the table after successful checkout
	                DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
	                tableModel.setRowCount(0); // Remove all rows from the table
	            
				}

			}
		});
		btnCheckOut.setBounds(473, 405, 106, 21);
		contentPane.add(btnCheckOut);

		DocumentListener documentListener = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateButtonState();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateButtonState();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateButtonState();
			}

			private void updateButtonState() {
				String name = textName.getText().trim();
				String mobileNumber = textMobileNumber.getText().trim();
				boolean isFieldsEmpty = name.isEmpty() || mobileNumber.isEmpty();

				// Check if the table data is filled
				boolean isTableFilled = isTableFilled(table_1);

				if (UserSession.isLoggedIn() || !isFieldsEmpty && isTableFilled) {
					btnCheckOut.setEnabled(true);
				} else {
					btnCheckOut.setEnabled(false);
				}
			}
		};
		textName.getDocument().addDocumentListener(documentListener);
		textMobileNumber.getDocument().addDocumentListener(documentListener);
		
		btnBack = new JButton("");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setVisible(true);
				dispose();
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		Image newImage6 = img6.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnBack.setIcon(new ImageIcon(newImage6));
		btnBack.setBounds(0, 0, 40, 40);
		contentPane.add(btnBack);

		lblBack = new JLabel("");
		lblBack.setBackground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/pizzaWall.png")).getImage();
		Image newImage = img.getScaledInstance(601, 439, Image.SCALE_DEFAULT);
		
		btnLogout = new JButton("");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(OrderPage.this,"Thank you for having Pizza Paradise!");
				UserSession.setLoggedIn(false);
				MainPage frame = new MainPage();
				frame.setVisible(true);
				dispose();
			}
		});
		Image img7 = new ImageIcon(this.getClass().getResource("/logOut.png")).getImage();
		Image newImage7 = img7.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnLogout.setIcon(new ImageIcon(newImage7));
		btnLogout.setBounds(551, 0, 40, 50);
		contentPane.add(btnLogout);
		
		lblBack.setIcon(new ImageIcon(newImage));
		lblBack.setBounds(0, 0, 612, 431);
		contentPane.add(lblBack);
	}

	// Method to update the tableSearch based on the selected category
	private DefaultTableModel updateTableSearch(String selectedCategory) {
		// Perform the necessary logic to fetch data for the selected category
		// and update the tableSearch accordingly

		// Example code to update the tableSearch with dummy data
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Number");
		model.addColumn("Menu");
		// Add rows of data to the model based on the selected category
		if (selectedCategory.equals("Pizza")) {
			model.addRow(new Object[] { "1", "Cheese Pizza" });
			model.addRow(new Object[] { "2", "Pepperoni Pizza" });
			model.addRow(new Object[] { "3", "Super Supreme Pizza" });
			model.addRow(new Object[] { "4", "Beef Cheddar Pizza" });
			model.addRow(new Object[] { "5", "Potato Pizza" });
		} else if (selectedCategory.equals("Breads")) {
			model.addRow(new Object[] { "6", "BreadStix" });
			model.addRow(new Object[] { "7", "CinnaStix" });
			model.addRow(new Object[] { "8", "Garlic Twisty Bread" });
			model.addRow(new Object[] { "9", "CheezyStix" });
		} else if (selectedCategory.equals("Desserts and Sides")) {
			model.addRow(new Object[] { "10", "Chocolate Lava Cake" });
			model.addRow(new Object[] { "11", "Blueberry Cheesecake" });
			model.addRow(new Object[] { "12", "Onion Rings" });
			model.addRow(new Object[] { "13", "Potato Wedges" });
		} else if (selectedCategory.equals("Drinks")) {
			model.addRow(new Object[] { "14", "Mineral Water" });
			model.addRow(new Object[] { "15", "Pepsi" });
			model.addRow(new Object[] { "16", "Pepsi Black" });
			model.addRow(new Object[] { "17", "Ice Tea Lemon" });
			model.addRow(new Object[] { "18", "Twister Orange" });
		}
		tableSearch.setModel(model);
		// Adjust the column widths
		TableColumnModel columnModel = tableSearch.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(25); // Set the preferred width for the number column
		columnModel.getColumn(1).setPreferredWidth(122); // Set the preferred width for the menu column

		return model; // Return the updated table model
	}

	// Method to check if the table is filled
	private boolean isTableFilled(JTable table_1) {
		// Get the table model
		TableModel model = table_1.getModel();

		// Check if any cell in the table is empty
		for (int row = 0; row < model.getRowCount(); row++) {
			for (int col = 0; col < model.getColumnCount(); col++) {
				Object value = model.getValueAt(row, col);
				if (value == null || value.toString().isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}
}
