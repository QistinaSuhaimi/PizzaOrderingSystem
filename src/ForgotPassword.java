import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPhoneNumber;
	private JLabel lblNewPassword;
	private JButton btnUpdate;
	private JLabel lblConfirmNewPass;
	private JTextField textID;
	private JTextField textPhoneNumber;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JLabel lblNewLabel;
	private JButton btnCancel;
	private JButton btnBack;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(47, 125, 158, 13);
		contentPane.add(lblUsername);
		
		lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(47, 170, 158, 13);
		contentPane.add(lblPhoneNumber);
		
		lblNewPassword = new JLabel("New Password: ");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(47, 205, 158, 31);
		contentPane.add(lblNewPassword);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String filePath = "data.txt"; // Path to the text file
		        String usernameToUpdate = textID.getText(); // Username of the user to update
		        String phoneNumber = textPhoneNumber.getText(); // New phone number to set
		        String newPassword = newPasswordField.getText(); // New password to set
		        String cNewPassword = confirmPasswordField.getText();
		        
		        RandomAccessFile file = null;
		        try {		        	

		            file = new RandomAccessFile(filePath, "rw");
		            
		            String line;
		            long filePointer = 0;		            
		            LinkedList<Boolean> conditions = new LinkedList();
		            boolean userFound = false;
			        boolean passwordUpdated = false;
			        
		            // Read each line in the file
			        while ((line = file.readLine()) != null) {
			            String[] tokens = line.split(": ");
			            
			            if (tokens.length >= 2) {
			            	if (tokens[0].equals("Phone Number") && tokens[1].equals(phoneNumber)) {
			                    conditions.add(true);
			                }
			                if (tokens[0].equals("Username") && tokens[1].equals(usernameToUpdate)) {
			                    conditions.add(true);
			                }
			            }			        
			        
			            if (conditions.size() == 2) {
				            if (newPassword.equals(cNewPassword)) {
				            	file.setLength(filePointer);
				            	file.seek(file.length());
				            	file.writeBytes("Username: " + usernameToUpdate + System.lineSeparator());
				            	file.writeBytes("Password: " + newPassword + System.lineSeparator());
				                userFound = true;
				                passwordUpdated = true;
				            }
				        }
			            if (line.startsWith("Password:") && !passwordUpdated && conditions.size() == 2) {
			            	 String existingPassword = tokens[1]; // Get the existing password from the text file
			                 if (existingPassword.equals(newPassword)) {
			                     // Skip the previous password for the specific user
			                     continue;
			                 } else {
			                     // Handle the case when the current password does not match the existing password
			                     break;
			                 }
			            }
			            filePointer = file.getFilePointer();
			        }
			        
			        if (userFound) {
			        	JOptionPane.showMessageDialog(null, "Password updated successfully!", "Success",JOptionPane.INFORMATION_MESSAGE); // success window will pop-up
			        	LoginPage frame = new LoginPage();
						frame.setVisible(true);
						dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Either\n"
		                		+ "Username or Phone Number Details are not match!\nor\n"
		                		+ "Password and Confirm Password Details are not match!", "Warning", JOptionPane.WARNING_MESSAGE);
			        	
		                
		            }		

		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } finally {
		            if (file != null) {
		                try {
		                    file.close();
		                } catch (IOException e1) {
		                    e1.printStackTrace();
		                }
		            }
		        }
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/updatePass.png")).getImage();
		Image newImage4 = img4.getScaledInstance(43, 36, Image.SCALE_DEFAULT);
		btnUpdate.setIcon(new ImageIcon(newImage4));
		btnUpdate.setBounds(418, 340, 121, 45);
		contentPane.add(btnUpdate);
		
		lblConfirmNewPass = new JLabel("Confirm New Password: ");
		lblConfirmNewPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmNewPass.setForeground(Color.WHITE);
		lblConfirmNewPass.setBounds(47, 258, 244, 21);
		contentPane.add(lblConfirmNewPass);
		
		textID = new JTextField();
		textID.setBounds(292, 124, 222, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(292, 169, 222, 19);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(292, 213, 222, 19);
		contentPane.add(newPasswordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(292, 258, 222, 19);
		contentPane.add(confirmPasswordField);
		
		lblNewLabel = new JLabel("UPDATE PASSWORD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 41, 277, 45);
		contentPane.add(lblNewLabel);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textID.setText("");
				textPhoneNumber.setText("");
				newPasswordField.setText("");
				confirmPasswordField.setText("");
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		Image newImage2 = img2.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnCancel.setIcon(new ImageIcon(newImage2));
		btnCancel.setBounds(292, 340, 116, 45);
		contentPane.add(btnCancel);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage frame = new LoginPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setForeground(Color.WHITE);
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		Image newImage1 = img1.getScaledInstance(36, 36, Image.SCALE_DEFAULT);
		btnBack.setIcon(new ImageIcon(newImage1));
		btnBack.setBounds(0, 0, 85, 40);
		contentPane.add(btnBack);
		
		background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pizzaWall.png")).getImage();
		Image newImage = img.getScaledInstance(601, 439, Image.SCALE_DEFAULT);
		background.setIcon(new ImageIcon(newImage));
		background.setBounds(0, 0, 601, 439);
		contentPane.add(background);
	}
}



