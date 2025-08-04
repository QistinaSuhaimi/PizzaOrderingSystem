import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Breads extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnPizza;
	private JButton btnBread;
	private JButton btnDessertSide;
	private JButton btnDrinks;
	private JLabel lblHeader;
	private JButton btnMain;
	private JButton btnCart;
	private JLabel lblCheesystix;
	private JLabel lblCinnastix;
	private JLabel lblGarlicTwisty;
	private JLabel lblBreadstix;
	private JLabel back;
	private JPanel panel_2;
	private JLabel lblPrice;
	private JLabel lblCalories;
	private JLabel lblCheese;
	private JPanel panel_3;
	private JLabel lblPepperoniPizza_1;
	private JLabel lblPricekrw;
	private JLabel lblCaloriesPer;
	private JPanel panel_4;
	private JLabel lblSuperSupremePizza;
	private JLabel lblPricekrw_1;
	private JLabel lblCaloriesPer_1;
	private JPanel panel_5;
	private JLabel lblPotatoPizza_1;
	private JLabel lblPricekrw_2;
	private JLabel lblCaloriesPer_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Breads frame = new Breads();
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
	public Breads() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 658, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnPizza = new JButton("Pizza");
		btnPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza frame = new Pizza();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPizza.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPizza.setBackground(Color.ORANGE);
		btnPizza.setBounds(113, 45, 81, 21);
		panel.add(btnPizza);
		
		btnBread = new JButton("Breads");
		btnBread.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBread.setBackground(new Color(255, 200, 0));
		btnBread.setBounds(196, 45, 87, 21);
		btnBread.setEnabled(false);
		panel.add(btnBread);
		
		btnDessertSide = new JButton("Desserts and Sides");
		btnDessertSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesertSides frame = new DesertSides();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDessertSide.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDessertSide.setBackground(new Color(255, 200, 0));
		btnDessertSide.setBounds(286, 45, 168, 21);
		panel.add(btnDessertSide);
		
		lblHeader = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/header.png")).getImage();
		Image newImage5 = img5.getScaledInstance(658, 89, Image.SCALE_DEFAULT);
		
		btnDrinks = new JButton("Drinks");
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drinks frame = new Drinks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDrinks.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDrinks.setBackground(Color.ORANGE);
		btnDrinks.setBounds(458, 45, 81, 21);
		panel.add(btnDrinks);
		
		btnMain = new JButton("");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnMain.setBackground(Color.WHITE);
		Image img6 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		Image newImage6 = img6.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnMain.setIcon(new ImageIcon(newImage6));
		btnMain.setBounds(0, 0, 40, 40);
		panel.add(btnMain);
		
		btnCart = new JButton("");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderPage frame = new OrderPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCart.setBackground(Color.WHITE);
		Image img7 = new ImageIcon(this.getClass().getResource("/cart.png")).getImage();
		Image newImage7 = img7.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		btnCart.setIcon(new ImageIcon(newImage7));
		btnCart.setBounds(597, 0, 61, 66);
		panel.add(btnCart);
		
		lblHeader.setIcon(new ImageIcon(newImage5));
		lblHeader.setBounds(0, 0, 658, 89);
		panel.add(lblHeader);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 91, 658, 340);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblCheesystix = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/cheesystix.png")).getImage();
		Image newImage1 = img1.getScaledInstance(109, 85, Image.SCALE_DEFAULT);
		lblCheesystix.setIcon(new ImageIcon(newImage1));
		lblCheesystix.setBounds(44, 26, 109, 85);
		panel_1.add(lblCheesystix);
		
		lblCinnastix = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/cinnastix.png")).getImage();
		Image newImage2 = img2.getScaledInstance(109, 85, Image.SCALE_DEFAULT);
		lblCinnastix.setIcon(new ImageIcon(newImage2));
		lblCinnastix.setBounds(44, 118, 109, 85);
		panel_1.add(lblCinnastix);
		
		lblGarlicTwisty = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/garlicTwisty.png")).getImage();
		Image newImage3 = img3.getScaledInstance(110, 55, Image.SCALE_DEFAULT);
		lblGarlicTwisty.setIcon(new ImageIcon(newImage3));
		lblGarlicTwisty.setBounds(44, 212, 109, 85);
		panel_1.add(lblGarlicTwisty);
		
		lblBreadstix = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/breadstix.png")).getImage();
		Image newImage4 = img4.getScaledInstance(109, 85, Image.SCALE_DEFAULT);
		lblBreadstix.setIcon(new ImageIcon(newImage4));
		lblBreadstix.setBounds(316, 26, 109, 85);
		panel_1.add(lblBreadstix);
		
		back = new JLabel("");
		Image img8 = new ImageIcon(this.getClass().getResource("/backgroun.png")).getImage();
		Image newImage8 = img8.getScaledInstance(658, 440, Image.SCALE_DEFAULT);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Display ingredients as a message dialog
		        String ingredients = "Cheese blend(mozarella, cheddar), Garlic butter, Italian seasoning";
		        JOptionPane.showMessageDialog(panel_2, "Ingredients Used:\n" + ingredients);
			}
		});
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(163, 35, 143, 61);
		panel_1.add(panel_2);
		
		lblCheese = new JLabel("Cheesystix");
		lblCheese.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(lblCheese);
		
		lblPrice = new JLabel("Price: 7,000krw");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(lblPrice);
		
		lblCalories = new JLabel("200 calories per serving");
		lblCalories.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCalories.setBackground(new Color(240, 240, 240));
		panel_2.add(lblCalories);
		
		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Display ingredients as a message dialog
		        String ingredients = "Butter, Cinnamon sugar mixture, Cream cheese icing for dipping";
		        JOptionPane.showMessageDialog(panel_2, "Ingredients Used:\n" + ingredients);
			}
		});
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(163, 128, 143, 61);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		lblPepperoniPizza_1 = new JLabel("Cinnastix");
		lblPepperoniPizza_1.setBounds(46, 10, 60, 13);
		lblPepperoniPizza_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_3.add(lblPepperoniPizza_1);
		
		lblPricekrw = new JLabel("Price: 6,000krw");
		lblPricekrw.setBounds(31, 23, 81, 13);
		lblPricekrw.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_3.add(lblPricekrw);
		
		lblCaloriesPer = new JLabel("250 calories per serving");
		lblCaloriesPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaloriesPer.setBounds(0, 41, 143, 13);
		lblCaloriesPer.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCaloriesPer.setBackground(SystemColor.menu);
		panel_3.add(lblCaloriesPer);
		
		panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Display ingredients as a message dialog
		        String ingredients = "Parmesan cheese, Garlic butter, Italian seasoning";
		        JOptionPane.showMessageDialog(panel_2, "Ingredients Used:\n" + ingredients);
			}
		});
		panel_4.setBackground(Color.ORANGE);
		panel_4.setBounds(163, 222, 143, 61);
		panel_1.add(panel_4);
		
		lblSuperSupremePizza = new JLabel("Garlic Twisty Bread");
		lblSuperSupremePizza.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_4.add(lblSuperSupremePizza);
		
		lblPricekrw_1 = new JLabel("Price: 8,000krw");
		lblPricekrw_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_4.add(lblPricekrw_1);
		
		lblCaloriesPer_1 = new JLabel("300 calories per serving");
		lblCaloriesPer_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCaloriesPer_1.setBackground(SystemColor.menu);
		panel_4.add(lblCaloriesPer_1);
		
		panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Display ingredients as a message dialog
		        String ingredients = "Parmesan cheese, Garlic butter, Italian seasoning";
		        JOptionPane.showMessageDialog(panel_2, "Ingredients Used:\n" + ingredients);
			}
		});
		panel_5.setBackground(Color.ORANGE);
		panel_5.setBounds(435, 35, 143, 61);
		panel_1.add(panel_5);
		
		lblPotatoPizza_1 = new JLabel("       Breadstix        ");
		lblPotatoPizza_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_5.add(lblPotatoPizza_1);
		
		lblPricekrw_2 = new JLabel("Price: 5,000krw");
		lblPricekrw_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_5.add(lblPricekrw_2);
		
		lblCaloriesPer_2 = new JLabel("250 calories per serving");
		lblCaloriesPer_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCaloriesPer_2.setBackground(SystemColor.menu);
		panel_5.add(lblCaloriesPer_2);
		back.setIcon(new ImageIcon(newImage8));
		back.setBackground(new Color(0, 0, 0));
		back.setBounds(0, 0, 658, 440);
		panel_1.add(back);
	}

}
