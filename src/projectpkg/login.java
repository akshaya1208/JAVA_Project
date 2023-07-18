package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	//JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(106, 106, 106));
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setFont(new Font("Segoe Script", Font.PLAIN, 11));
		btnNewButton_1.setForeground(SystemColor.desktop);
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.setBounds(393, 275, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new registration().setvisible(true);
			frame.setVisible(false);
		}
	});
		
		
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Segoe Script", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setBounds(526, 275, 89, 23);
		
		frame.getContentPane().add(btnNewButton);
		
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblNewLabel.setBounds(452, 86, 190, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(379, 132, 103, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(379, 172, 103, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(526, 138, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(526, 176, 134, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
//		JLabel lblNewLabel_3 = new JLabel("User Type");
//		lblNewLabel_3.setForeground(Color.WHITE);
//		lblNewLabel_3.setFont(new Font("Segoe Script", Font.PLAIN, 16));
//		lblNewLabel_3.setBounds(379, 211, 120, 34);
//		frame.getContentPane().add(lblNewLabel_3);
//		
		//String str[]= {"Select","Admin","User"};
		// comboBox = new JComboBox(str);
		//comboBox.setBounds(526, 218, 134, 22);
		//frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\Login.jpg"));
		lblNewLabel_4.setBounds(0, 0, 710, 506);
		frame.getContentPane().add(lblNewLabel_4);
		frame.setBounds(100, 100, 726, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
					Statement stmt=con.createStatement();
					//String usertype=comboBox.getSelectedItem().toString();
					//System.out.println(usertype);
					
					
				//	if(usertype.equals("User"))
					//{
						String query="select * from users where UNAME='"+textField.getText()+"' and UPASS='"+textField_1.getText()+"'";
						System.out.println(query);
						ResultSet rs=stmt.executeQuery(query);
						if(rs.next())
						{
							//System.out.println(rs.getInt("USERID"));
						
//							User_page obj=new User_page(rs.getInt("USERID"));
//							obj.setVisible(true);
							new User_page(rs.getInt("USERID")).setVisible(true);
							frame.setVisible(false);
							
						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,"Pls check username and password");
//						}
					//}
					//if(usertype.equals("Admin"))
					//{
						if(textField.getText().equals("Admin") && textField_1.getText().equals("Admin"))
						{
						System.out.println("haii");
						new adminpage().setVisible(true);
						frame.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Login succesfully done");
						}
					}
				//}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

