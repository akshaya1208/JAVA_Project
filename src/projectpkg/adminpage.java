package projectpkg;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class adminpage {

	private JFrame frame;
	private JTextField textField_name;
	int showtype=0;
	private JTable table;
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		new adminpage();
//	EventQueue.invokeLater(new Runnable() {
//	public void run() {
//		try {
//			adminpage window = new adminpage();
//			window.frame.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//			}
//		}
//	});
	}

	/**
	* Create the application.
	*/
	public adminpage() {
		initialize();
	}
	
	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	JButton btnNewButton_1 = new JButton("show all movies");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");

				Statement stmt=con.createStatement();
				String query="select mid,mname,tname from movies";
				ResultSet rs=stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
	});
	btnNewButton_1.setBounds(34, 312, 85, 21);
	frame.getContentPane().add(btnNewButton_1);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(144, 309, 348, 131);
	frame.getContentPane().add(scrollPane_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane_1.setViewportView(scrollPane);
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Sl No", "Movie Name", "Theatre Name"
		}
	));
	scrollPane.setViewportView(table);
		
		

	JLabel lblNewLabel = new JLabel("Enter the name of the movie");
	lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	lblNewLabel.setBounds(61, 119, 210, 25);
	frame.getContentPane().add(lblNewLabel);
	
	textField_name = new JTextField();
	textField_name.setBounds(324, 123, 182, 22);
	frame.getContentPane().add(textField_name);
	textField_name.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Enter the name of the theatre");
	lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(61, 155, 217, 25);
	frame.getContentPane().add(lblNewLabel_1);
	
	
	JLabel lblNewLabel_3 = new JLabel("Admin Centre");
	lblNewLabel_3.setForeground(new Color(0, 0, 0));
	lblNewLabel_3.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
	lblNewLabel_3.setBounds(21, 33, 209, 75);
	frame.getContentPane().add(lblNewLabel_3);
	
	String str[]= {"Select","PVR Cinemas","Aries Plex","New Theatre","IMAX","Cinepolis","Central Theatre","Universe"};
	JComboBox comboBox_thea = new JComboBox(str);
	comboBox_thea.setBounds(324, 156, 182, 22);
	frame.getContentPane().add(comboBox_thea);

	
//	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("4.00pm");
//	rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//	rdbtnNewRadioButton_2.setBounds(496, 357, 103, 21);
//	frame.getContentPane().add(rdbtnNewRadioButton_2);
	
//	JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("6.30pm");
//	rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
//	rdbtnNewRadioButton_3.setBounds(631, 357, 103, 21);
//	frame.getContentPane().add(rdbtnNewRadioButton_3);
	
//	JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("10.00pm");
//	rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
//	rdbtnNewRadioButton_4.setBounds(554, 399, 103, 21);
//	frame.getContentPane().add(rdbtnNewRadioButton_4);

	JButton btnNewButton = new JButton("SUBMIT");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","msc");
				Statement stmt=con.createStatement();
				String query2="Select count(MID) from movies";
				ResultSet rscount=stmt.executeQuery(query2);
				rscount.next();
				System.out.println(rscount.getInt(1));
				int mid=rscount.getInt(1)+1;
				String query="insert into movies values('"+mid+"','"+comboBox_thea.getSelectedItem().toString()+"','"+textField_name.getText()+"')";
				System.out.println(query);
				int result=stmt.executeUpdate(query);
				if(result!=0)
				{
					JOptionPane.showMessageDialog(null,"Data saved successfully");
				}else
				{
					JOptionPane.showMessageDialog(null,"Data saved not successfully");
				}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	});
	btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
	btnNewButton.setBounds(235, 211, 116, 29);
	frame.getContentPane().add(btnNewButton);
	
	String s2[]= {"11.00 am , 2.00 pm ,6.00 pm , 8.00 pm , 11.00 pm"};
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\SREEKUTTAN\\Downloads\\Adminpage.jpg"));
	lblNewLabel_4.setBounds(0, 0, 615, 453);
	frame.getContentPane().add(lblNewLabel_4);
	

	
	frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

