import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import java.sql.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ArrayList<User> userList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginScreen() {
		initUserList();
		
		setResizable(false);
		setTitle("Login ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 15));
		textField.setBounds(176, 29, 180, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 32, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 68, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Cambria", Font.PLAIN, 15));
		passwordField.setBounds(176, 65, 180, 25);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(String.copyValueOf(passwordField.getPassword()).isEmpty() || textField.getText().isEmpty())
// Notify User of empty input field
					System.out.println("Empty Input Field");
				else
				{
					for(User user: userList)
						if(user.getUsername().equals(textField.getText()) && user.getPassword().equals(String.copyValueOf(passwordField.getPassword())))
// Instantiate and show AssetScreen here
						{
							System.out.println("In with clearance level " + user.getClearance());
							DBConnection DBcon = new DBConnection();
							Connection con = DBcon.open();
							DBcon.executeUpdate(con, "insert into actionlog values('',);");
							DBcon.close();
						}
						else
// Notify User of wrong Username/Password
							System.out.println("Username or Password is wrong.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 16));
		btnNewButton.setBounds(113, 115, 170, 35);
		contentPane.add(btnNewButton);
	}
	
	private void initUserList(){
		userList = new ArrayList<User>();
		
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select * from UserAccount;");
		DBcon.close();
		try{
			rs.first();
			while(!rs.isAfterLast()){
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
				rs.next();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
