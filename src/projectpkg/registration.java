package projectpkg;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class registration {

	private JFrame frame;
	private JTextField textField_place;
	private JTextField textField_mail;
	private JTextField textField_phone;
	private JTextField textField_username;
	private JPasswordField textField_pwd;
	private JTextField textField_name;
	private JPasswordField textField_cpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					registration window = new registration();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enroll");
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 33));
		lblNewLabel.setBounds(242, 29, 276, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(161, 96, 69, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email ID");
		lblNewLabel_3.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(161, 169, 94, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile Number");
		lblNewLabel_4.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(161, 199, 149, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Place");
		lblNewLabel_5.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(161, 133, 99, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_place = new JTextField();
		textField_place.setBounds(335, 137, 132, 19);
		frame.getContentPane().add(textField_place);
		textField_place.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(161, 236, 109, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(161, 266, 109, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Confirm Password");
		lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		lblNewLabel_7.setBounds(161, 293, 183, 32);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(335, 169, 132, 19);
		frame.getContentPane().add(textField_mail);
		textField_mail.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(335, 203, 132, 19);
		frame.getContentPane().add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setBounds(335, 236, 132, 19);
		frame.getContentPane().add(textField_username);
		textField_username.setColumns(10);
		
		textField_pwd = new JPasswordField();
		textField_pwd.setBounds(335, 270, 132, 19);
		frame.getContentPane().add(textField_pwd);
		textField_pwd.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setBounds(335, 100, 132, 19);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		textField_cpass = new JPasswordField();
		textField_cpass.setBounds(335, 300, 132, 19);
		frame.getContentPane().add(textField_cpass);
		textField_cpass.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		btnNewButton.setBounds(237, 346, 115, 26);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select max(userid) from users");
					rs.next();
					System.out.println(rs.getInt(1));
					int uid=rs.getInt(1)+1;
					if(textField_cpass.getText().equals(textField_pwd.getText()))
					{
						String str="insert into users values('"+uid+"','"+textField_name.getText()+"','"+textField_pwd .getText()+"','"+textField_mail.getText()+"','"+textField_phone.getText()+"','"+textField_place.getText()+"','"+textField_username.getText()+"')";
						System.out.println(str);
						int a=stmt.executeUpdate(str);
						if(a!=0)
						{
							JOptionPane.showMessageDialog(null,"Data saved successfully");
							new login().setVisible(true);
							frame.setVisible(false);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Data not saved successfully");
						}
					}else
					{
						JOptionPane.showMessageDialog(null,"Password does not match");
					}
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\Registration.jpg"));
		lblNewLabel_8.setBounds(0, 0, 628, 565);
		frame.getContentPane().add(lblNewLabel_8);
		frame.setVisible(true);
	}

	public void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
