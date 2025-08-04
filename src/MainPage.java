import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblWelcome;
	private JButton btnMenu;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Label for "Welcome to Pizza Paradise!"
		lblWelcome = new JLabel("WELCOME TO PIZZA PARADISE!");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(136, 75, 334, 67);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome);
		
		// Button for accessing the menu
		btnMenu = new JButton("MENU");
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(Color.BLACK);
		btnMenu.setBounds(199, 152, 210, 45);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza frame = new Pizza();
				frame.setVisible(true);
				dispose();
				
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/menu.png")).getImage();
		Image newImage1 = img1.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnMenu.setIcon(new ImageIcon(newImage1));
		contentPane.add(btnMenu);
		
		// Button for member login
		btnLogin = new JButton("MEMBER LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(199, 207, 210, 45);
		btnLogin.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent e) {
			LoginPage frame = new LoginPage();
			frame.setVisible(true);
			dispose();
			
		}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		Image newImage2 = img2.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnLogin.setIcon(new ImageIcon(newImage2));
		contentPane.add(btnLogin);
		
		// Button for member registration
		btnRegister = new JButton(" REGISTER AS MEMBER");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRegister.setBackground(Color.BLACK);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage frame = new RegisterPage();
				frame.setVisible(true);
				dispose();
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/register.png")).getImage();
		Image newImage3 = img3.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnRegister.setIcon(new ImageIcon(newImage3));
		btnRegister.setBounds(170, 262, 259, 45);
		contentPane.add(btnRegister);
		
		background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pizzaWall.png")).getImage();
		Image newImage = img.getScaledInstance(601, 439, Image.SCALE_DEFAULT);
		background.setIcon(new ImageIcon(newImage));
		background.setBounds(0, 0, 601, 439);
		contentPane.add(background);
		
	}
}
