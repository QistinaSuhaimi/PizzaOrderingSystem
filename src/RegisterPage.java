import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class RegisterPage extends JFrame {

	// private JPanel contentPane;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmPassword;
	private JTextField textFieldPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPanel.setBounds(0, 0, 601, 431);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			// Cancel button
			JButton btnCancel = new JButton("Cancel");
			btnCancel = new JButton("Cancel");
			btnCancel.setBackground(Color.WHITE);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Clear the input fields when the cancel button is clicked
					textFieldName.setText("");
					textFieldPhoneNumber.setText("");
					textFieldUserName.setText("");
					textFieldPassword.setText("");
					textFieldConfirmPassword.setText("");
				}
			});
			Image img2 = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
			Image newImage2 = img2.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
			btnCancel.setIcon(new ImageIcon(newImage2));
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnCancel.setBounds(279, 347, 133, 39);
			contentPanel.add(btnCancel);
		}
		{
			// Register button
			JButton btnRegister = new JButton("Register");
			btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnRegister.setBackground(Color.WHITE);
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						FileOutputStream fileWrite = new FileOutputStream("data.txt", true); // append to the file
						PrintWriter buffer = new PrintWriter(fileWrite);
						String phoneNumber = textFieldPhoneNumber.getText();
						// Define the regex pattern for phone number format
						String phoneRegex = "^\\d{2} \\d{4}-\\d{4}$";
						Pattern phonePattern = Pattern.compile(phoneRegex);
						Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
						LinkedList<Boolean> conditions = new LinkedList();
						ArrayList<String> errorList = new ArrayList<>(); // store error messages in an array

						if (phoneMatcher.matches()) {
							conditions.add(true);
						} else {
							// Phone number format is incorrect
							errorList.add("Invalid phone number format. Please enter in the format '10 2158-0222'."); // add
																														// message
																														// in
																														// array
						}

						if (textFieldPassword.getText().equals(textFieldConfirmPassword.getText())) {
							conditions.add(true);
						} else {
							errorList.add("Password and Confirm Password Details are not match!");
						}
						if (conditions.size() == 2) {
							buffer.println("Full Name: " + textFieldName.getText());
							buffer.println("Phone Number: " + phoneNumber);
							buffer.println("Username: " + textFieldUserName.getText());
							buffer.println("Password: " + textFieldPassword.getText() + "\n");
							JOptionPane.showMessageDialog(RegisterPage.this, "You are registered, thank you!");
							//open loginPage frame
							LoginPage dialog = new LoginPage();
							dialog.setVisible(true);
							// Clear the input fields for the next registration
							textFieldName.setText("");
							textFieldPhoneNumber.setText("");
							textFieldUserName.setText("");
							textFieldPassword.setText("");
							textFieldConfirmPassword.setText("");

							textFieldName.requestFocus(); // Set focus to the name field

							dispose();
						} else {/* else there will be pop up listing errors */
							String errorMessage = "<html><ul>";
							for (String error : errorList) {
								errorMessage += "<li>" + error + "</li>";
							}
							errorMessage += "</ul></html>";
							JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);// error
																													// window
																													// will
																													// pop-up
							errorList.clear();
						}
						buffer.close();
						fileWrite.close();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			Image img3 = new ImageIcon(this.getClass().getResource("/register.png")).getImage();
			Image newImage3 = img3.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
			btnRegister.setIcon(new ImageIcon(newImage3));
			btnRegister.setBounds(433, 349, 158, 39);
			contentPanel.add(btnRegister);
		}
		{
			JLabel lblName = new JLabel("Full Name");
			lblName.setForeground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblName.setBounds(5, 83, 211, 39);
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(215, 93, 381, 19);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setForeground(Color.WHITE);
			lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPhoneNumber.setBounds(5, 132, 211, 39);
			contentPanel.add(lblPhoneNumber);
		}
		{
			textFieldPhoneNumber = new JTextField();
			textFieldPhoneNumber.setBounds(215, 142, 381, 19);
			contentPanel.add(textFieldPhoneNumber);
			textFieldPhoneNumber.setColumns(10);
		}
		{
			JLabel lblUserName = new JLabel("Username");
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUserName.setForeground(Color.WHITE);
			lblUserName.setBounds(5, 183, 211, 39);
			contentPanel.add(lblUserName);
		}
		{
			textFieldUserName = new JTextField();
			textFieldUserName.setBounds(215, 193, 381, 19);
			contentPanel.add(textFieldUserName);
			textFieldUserName.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPassword.setBounds(5, 239, 211, 39);
			contentPanel.add(lblPassword);
		}
		{
			textFieldPassword = new JPasswordField();
			textFieldPassword.setBounds(215, 249, 381, 19);
			textFieldPassword.setColumns(10);
			contentPanel.add(textFieldPassword);
		}
		{
			JLabel lblConfirmPassword = new JLabel("Confirm Password");
			lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblConfirmPassword.setForeground(Color.RED);
			lblConfirmPassword.setBounds(5, 293, 200, 39);
			contentPanel.add(lblConfirmPassword);
		}
		{
			textFieldConfirmPassword = new JPasswordField();
			textFieldConfirmPassword.setBounds(215, 303, 381, 19);
			textFieldConfirmPassword.setColumns(10);
			contentPanel.add(textFieldConfirmPassword);
		}
		{
			JLabel lblRegister = new JLabel("REGISTER AS MEMBER");
			lblRegister.setForeground(Color.WHITE);
			lblRegister.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegister.setBounds(87, 28, 381, 45);
			contentPanel.add(lblRegister);
		}
		{
			JButton btnBack = new JButton("");
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
			contentPanel.add(btnBack);
		}
		{
			JLabel background = new JLabel("");
			background = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/pizzaWall.png")).getImage();
			Image newImage = img.getScaledInstance(601, 439, Image.SCALE_DEFAULT);
			background.setIcon(new ImageIcon(newImage));
			background.setBounds(0, 0, 601, 439);
			contentPanel.add(background);			
		}
	}

}
