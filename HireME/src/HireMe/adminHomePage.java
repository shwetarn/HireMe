package HireMe;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class adminHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static ArrayList<ArrayList<Object>> userData=new ArrayList<ArrayList<Object>>();
	public static void setUserData(ArrayList<ArrayList<Object>> givenuserData) {
		userData=givenuserData;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminHomePage frame = new adminHomePage();
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
	public adminHomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shweta.rn\\Downloads\\Hire!ME (7).png"));
		setTitle("Admin - Hire!ME");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println("userData"+userData);
		int xIDValue=41;
		int currYValue=144;
		int xNameValue=241;
		int xPhoneValue=441;
		int xEMailValue=641;
		int xTypaValue=841;
		int xPersonValue=1041;
		currYValue=currYValue-30;
		for(int i=0;i<userData.size();i++) {
			currYValue=currYValue+50;
			ArrayList<Object> temp=new ArrayList<Object>();
			temp=userData.get(i);
//			String labelName=temp.get(i)+""+currYValue;
			
			JLabel tempNameLabel = new JLabel(temp.get(1)+"");
			tempNameLabel.setBounds(xNameValue, currYValue, 200, 50);
			tempNameLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempNameLabel);
			
			JLabel tempEMialLabel = new JLabel(temp.get(3)+"");
			tempEMialLabel.setBounds(xEMailValue, currYValue, 200, 50);
			tempEMialLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempEMialLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempEMialLabel);
			
			JLabel tempPhoneLabel = new JLabel(temp.get(2)+"");
			tempPhoneLabel.setBounds(xPhoneValue, currYValue, 200, 50);
			tempPhoneLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempPhoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempPhoneLabel);
			
			JLabel tempTypeLabel = new JLabel(temp.get(4)+"");
			tempTypeLabel.setBounds(xTypaValue, currYValue, 200, 50);
			tempTypeLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempTypeLabel);
			
			JLabel tempPersonLabel = new JLabel(temp.get(5)+"");
			tempPersonLabel.setBounds(xPersonValue, currYValue, 200, 50);
			tempPersonLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempPersonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempPersonLabel);
			
			JLabel tempIDLabel = new JLabel(temp.get(0)+"");
			tempIDLabel.setBounds(xIDValue, currYValue, 200, 50);
			tempIDLabel.setBackground(Color.black);
			tempIDLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
			tempIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			contentPane.add(tempIDLabel);
			
//			JLabel tempPhoneLabel = new JLabel(temp.get(2)+"");
//			tempPhoneLabel.setBounds(xPhoneValue, currYValue, 102, 14);
//			contentPane.add(tempPhoneLabel);
			
		}
		JLabel lblNewLabel = new JLabel("USER LIST - HIRE!ME");
		lblNewLabel.setForeground(new Color(54, 63, 175));
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
		lblNewLabel.setBounds(500, 36, 277, 14);
		contentPane.add(lblNewLabel);
		
		JButton deleteUser = new JButton("DELETE USER");
		deleteUser.setForeground(Color.red);
		deleteUser.setBackground(new Color(242, 243, 255));
		deleteUser.setBorder(BorderFactory.createLineBorder(new Color(242, 243, 255)));
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("hg");
				String userType = JOptionPane.showInputDialog("Enter User Type. 1 for Applicant, 2 for Company");
				String userID = JOptionPane.showInputDialog("Enter User ID");
				System.out.println("ID"+userID);
				ArrayList<Object> temp=new ArrayList<Object>();
				temp.add(userType);
				temp.add(userID);
				JDBCconnection conn=new JDBCconnection();
				conn.applicantLogin(temp,"deleteUserFromAdmin");
				dispose();
			}
		});
		deleteUser.setBounds(330, 60, 202, 23);
		contentPane.add(deleteUser);
		
		JButton deleteUser1 = new JButton("COMMUNITY WALL");
		deleteUser1.setForeground(new Color(54, 63, 175));
		deleteUser1.setBackground(new Color(242, 243, 255));
		deleteUser1.setBorder(BorderFactory.createLineBorder(new Color(242, 243, 255)));
		deleteUser1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("communityWallBtn");
				communityWall communitywall=new communityWall();
				communitywall.userID=1+"";
				communitywall.userType="Admin";
				communitywall.userName="test";
				communitywall.main(null);
				dispose();
			}
		});
		deleteUser1.setBounds(710, 60, 202, 23);
		contentPane.add(deleteUser1);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(xIDValue, 125, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setBounds(xNameValue, 125, 102, 14);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("User Phone");
		lblNewLabel_1_1_1.setBounds(xPhoneValue, 125, 102, 14);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("User E-Mail");
		lblNewLabel_1_1_2.setBounds(xEMailValue, 125, 102, 14);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setBounds(xTypaValue, 125, 150, 14);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Person Name");
		lblNewLabel_4.setBounds(xPersonValue, 125, 150, 14);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\ezgif.com-video-to-gif (1).gif"));
		lblNewLabel_2.setBounds(780, 150, 500, 500);
		contentPane.add(lblNewLabel_2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
