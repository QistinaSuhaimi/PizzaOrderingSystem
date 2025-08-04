import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblID;
	private JLabel lblPassword;
	private JTextField IDField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnCancel;
	private JButton btnBack;
	private JLabel background;
	private JLabel lblLogin;
	private JLabel lblforgotPass;
	private boolean isLoggedIn = false;

	/**
	 * Launch the application.
	 */
	public static void loginScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Label for "forgot password?" option
		lblforgotPass = new JLabel("forgot password?");
		lblforgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//open forgot password frame
				ForgotPassword frame = new ForgotPassword();
				frame.setVisible(true);
				dispose();
			}
		});
		lblforgotPass.setForeground(Color.WHITE);
		lblforgotPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblforgotPass.setBounds(238, 343, 129, 13);
		contentPane.add(lblforgotPass);
		
		// Label for "Username"
		lblID = new JLabel("Username:");
		lblID.setBackground(Color.BLACK);
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblID.setBounds(234, 100, 133, 21);
		contentPane.add(lblID);
		
		// Label for "Password"
		lblPassword = new JLabel("Password: ");
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(238, 184, 117, 21);
		contentPane.add(lblPassword);
		
		// Text field for entering username
		IDField = new JTextField();
		IDField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDField.setBounds(234, 141, 188, 23);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		// Password field for entering password
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(238, 228, 188, 23);
		contentPane.add(passwordField);
		
		// Button for login
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileInputStream fileReader = new FileInputStream("data.txt");
					String password = new String(passwordField.getPassword()); //convert password from character to String
					LinkedList<Boolean> conditions = new LinkedList();
					Boolean validCredentials = false;
					//^ this is local variable so it will reset the conditions itself
					Scanner buffer = new Scanner(fileReader);
					while(buffer.hasNext()) {
						String line = buffer.nextLine();
						String tokens[] = line.split(": ");
						if (tokens.length >= 2) {
				            if (tokens[0].equals("Username") && tokens[1].equals(IDField.getText())) {
				                conditions.add(true);
				            }
				            if (tokens[0].equals("Password") && tokens[1].equals(password)) {
				                conditions.add(true);
				            }
				        }
					if(conditions.size()==2) {
						validCredentials = true;
						break;
					}
					
					}
				    buffer.close();
				    if (validCredentials) {
				    	UserSession.setLoggedIn(true);
				    	//open pizza frame
				        Pizza frame = new Pizza();
				        frame.setVisible(true);
				        dispose();
			        }else {
						JOptionPane.showMessageDialog(LoginPage.this, "Incorrect Username or Password");
					}
					
				} catch (FileNotFoundException e1) {
					//If data.txt file is not found, open registerPage frame
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		Image newImage3 = img3.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnLogin.setIcon(new ImageIcon(newImage3));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(238, 292, 129, 41);
		contentPane.add(btnLogin);
		
		// Button for canceling login process
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear the text fields
				IDField.setText("");
				passwordField.setText("");
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		Image newImage2 = img2.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnCancel.setIcon(new ImageIcon(newImage2));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(378, 292, 129, 41);
		contentPane.add(btnCancel);
		
		// Button for going back to the MainPage
		btnBack = new JButton("");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//open mainPage frame
				MainPage frame = new MainPage();
				frame.setVisible(true);
				dispose();
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		Image newImage1 = img1.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnBack.setIcon(new ImageIcon(newImage1));
		btnBack.setBounds(0, 0, 64, 41);
		contentPane.add(btnBack);
		
		// Label for "LOGIN"
		lblLogin = new JLabel("LOGIN");
		lblLogin.setBackground(Color.BLACK);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLogin.setBounds(234, 50, 144, 40);
		contentPane.add(lblLogin);
		
		// Background image
		background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pizzaWall.png")).getImage();
		Image newImage = img.getScaledInstance(601, 439, Image.SCALE_DEFAULT);
		background.setIcon(new ImageIcon(newImage));
		background.setBounds(0, 0, 601, 439);
		contentPane.add(background);
	}
}
