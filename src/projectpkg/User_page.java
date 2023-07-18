package projectpkg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class User_page {
	JLabel lblNewLabel_4,lblNewLabel_the,lblNewLabel_time,lblNewLabel,lblNewLabel_6,lblNewLabel_7,lblNewLabel_5,lblNewLabel_9,lblNewLabel_8;
	JComboBox comboBox,comboBox_1,comboBox_show;
	static int uid;
	Panel panel_fist,panel1;
	private JFrame frame;
	private JLabel lblNewLabel_1,lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_page window = new User_page(uid);
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
	public User_page(int i) {
		uid=i;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		 
		 btnNewButton = new JButton("Show booking");
		 btnNewButton.setBackground(SystemColor.activeCaption);
		 btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.out.print("haii show booking");
		 		panel_fist.setVisible(true);
		 		panel1.setVisible(false);
		 		try {
		 			
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
					Statement stmt=con.createStatement();

					String query="Select MNAME from movies";
					System.out.println();
					ResultSet rsmname=stmt.executeQuery(query);
					while(rsmname.next())
					{
					
						comboBox.addItem(rsmname.getString(1));
						
					}
					
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
		 	}
		 });
		 btnNewButton.setBounds(87, 312, 122, 21);
		 frame.getContentPane().add(btnNewButton);
		
//	 	panel_fist.setVisible(false);
		
		 panel1=new Panel();
		 panel1.setBounds(229, 103, 357, 250);
		// panel1.setBackground(new Color(0, 0, 0,1));
		 frame.getContentPane().add(panel1);
		 panel1.setLayout(null);
		 panel1.setVisible(false);
		 
		 lblNewLabel_1 = new JLabel("Name");
		 lblNewLabel_1.setForeground(SystemColor.window);
		 lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		 lblNewLabel_1.setBounds(10, 27, 161, 25);
		 panel1.add(lblNewLabel_1);
		 
		 lblNewLabel_2 = new JLabel();
		 lblNewLabel_2.setBounds(181, 30, 166, 21);
		 lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		 panel1.add(lblNewLabel_2);
		 
		 lblNewLabel_8 = new JLabel("Phone Number");
		 lblNewLabel_8.setForeground(SystemColor.window);
		 lblNewLabel_8.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		 lblNewLabel_8.setBounds(10, 80, 143, 13);
		 panel1.add(lblNewLabel_8);
		 
		 lblNewLabel_9 = new JLabel();
		 lblNewLabel_9.setBounds(181, 77, 166, 21);
		 lblNewLabel_9.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		 panel1.add(lblNewLabel_9);
		 
		 lblNewLabel_7 = new JLabel("Email");
		 lblNewLabel_7.setForeground(SystemColor.window);
		 lblNewLabel_7.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		 lblNewLabel_7.setBounds(10, 121, 166, 13);
		 panel1.add(lblNewLabel_7);
		 
		 lblNewLabel_6 = new JLabel();
		 lblNewLabel_6.setBounds(181, 118, 166, 21);
		 lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		 panel1.add(lblNewLabel_6);
		 
		 JLabel lblNewLabel_3 = new JLabel("New label");
		 lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\panal.jpg"));
		 lblNewLabel_3.setBounds(0, 0, 367, 250);
		 panel1.add(lblNewLabel_3);
		 
		
		 
		 
		panel_fist = new Panel();
		panel_fist.setBounds(229, 103, 357, 250);
	//	panel_fist.setBackground(new Color(0, 0, 0,1));
		frame.getContentPane().add(panel_fist);
		panel_fist.setLayout(null);
		panel_fist.setVisible(false);
	 
		lblNewLabel = new JLabel("Select the movie");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 27, 161, 25);
		panel_fist.add(lblNewLabel);
		
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			comboBox_1.removeAllItems();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
					Statement stmt=con.createStatement();
					String query3="select tname from movies where mname='"+comboBox.getSelectedItem().toString()+"'";
					ResultSet rs=stmt.executeQuery(query3);
					while(rs.next())
					{
						System.out.println(rs.getString(1));
						comboBox_1.addItem(rs.getString(1));
					}
					
		 		}
		 		catch(Exception e3)
		 		{
		 			System.out.println(e3);
		 		}
		 		
		 	}
		 });
		 comboBox.setBounds(181, 30, 166, 21);
		 panel_fist.add(comboBox);
		 
		 
		 
		 
		  	lblNewLabel_the = new JLabel("Select the theatre");
		  	lblNewLabel_the.setForeground(Color.WHITE);
		  	lblNewLabel_the.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		  	lblNewLabel_the.setBounds(10, 80, 143, 13);
		  	panel_fist.add(lblNewLabel_the);
		  	
		  	comboBox_1 = new JComboBox();
		  	comboBox_1.setBounds(181, 77, 166, 21);
		  	panel_fist.add(comboBox_1);
		  	
		  	
		  	lblNewLabel_time = new JLabel("Select time of the show");
		  	lblNewLabel_time.setForeground(Color.WHITE);
		  	lblNewLabel_time.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		  	lblNewLabel_time.setBounds(10, 121, 166, 13);
		  	panel_fist.add(lblNewLabel_time);
		  	
		  	
		  	
		  	
		  	comboBox_show = new JComboBox();
		  	comboBox_show.setModel(new DefaultComboBoxModel(new String[] {"10.00", "11.00", "1.00", "3.00", "7.00", "10.00", "11.00"}));
		  	comboBox_show.setBounds(181, 118, 166, 21);
		  	panel_fist.add(comboBox_show);
		  	
		  	JButton btnNewButton_1 = new JButton("Book");
		  	btnNewButton_1.addActionListener(new ActionListener() {
		  		public void actionPerformed(ActionEvent e) {
		  			try
		  			{
		  		 			
		  					Class.forName("oracle.jdbc.driver.OracleDriver");
		  					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
		  					Statement stmt=con.createStatement();
		  					ResultSet rs=stmt.executeQuery("select max(BID) from booking");
		  					rs.next();
		  					System.out.println(rs.getInt(1));
		  					int bid=rs.getInt(1)+1;
		  					String query="insert into booking values('"+bid+"','"+comboBox_show.getSelectedItem().toString()+"','"+comboBox_1.getSelectedItem().toString()+"','"+comboBox.getSelectedItem().toString()+"','"+comboBox_show.getSelectedItem().toString()+"')";
		  					System.out.println(query);
		  					int result=stmt.executeUpdate(query);
		  					if(result!=0)
		  					{
		  						JOptionPane.showMessageDialog(null,"Movie booked");
		  						User_page ur=new User_page(uid);
		  						ur.setVisible(true);
		  						frame.setVisible(false);
		  					}
		  					else
		  					{
		  						JOptionPane.showMessageDialog(null,"Movie not booked");
		  					}
		  			}
		  					catch(Exception e1)
		  					{
		  						System.out.print(e1);
		  					}
		  			
		  		}
		  	});
		  	btnNewButton_1.setBounds(136, 182, 85, 21);
		  	panel_fist.add(btnNewButton_1);
		  	//panel_fist.add(lblNewLabel_3);
		  	
		  	 JLabel lblNewLabel_11 = new JLabel("New label");
		  	 lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\panal.jpg"));
		  	 lblNewLabel_11.setBounds(0, 0, 357, 240);
		  	 panel_fist.add(lblNewLabel_11);
		btnNewButton_2 = new JButton("View details");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		btnNewButton_2.setBounds(87, 343, 122, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		lblNewLabel_4 = new JLabel("BOOK YOUR SHOW");
	 	lblNewLabel_4.setForeground(Color.WHITE);
	 	lblNewLabel_4.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
	 	lblNewLabel_4.setBounds(266, 30, 419, 67);
	 	frame.getContentPane().add(lblNewLabel_4);
	 	//lblNewLabel_4.setVisible(false);
	 	
	 	lblNewLabel_5 = new JLabel("");
	 	lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\userspage.jpg"));
	 	lblNewLabel_5.setBounds(0, 0, 611, 393);
	 	frame.getContentPane().add(lblNewLabel_5);
			
			
			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("haii view details");
					panel_fist.setVisible(false);
					panel1.setVisible(true);
					
					try
					{
				 			
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
							Statement stmt=con.createStatement();
							String query="Select * from users where USERID='"+uid+"'";
							ResultSet rs=stmt.executeQuery(query);
							rs.next();
							System.out.println(rs.getString("PHNNO"));
							String ph=rs.getString(uid);
							lblNewLabel_2.setText(rs.getString("NAME"));
							lblNewLabel_9.setText(rs.getString("PHNNO"));
							lblNewLabel_6.setText(rs.getString("UMAIL"));
							
					}
					catch(Exception e3)
					{
						System.out.println(e3);
					}
					
					
					
					
				}
			});
			
			
			
			
			
			
			
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}