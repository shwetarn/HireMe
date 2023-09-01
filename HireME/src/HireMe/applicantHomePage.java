package HireMe;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class applicantHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicantHomePage frame = new applicantHomePage();
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
	public static int userID;
	public static String userName;
	public static void setuserID(int givenuserID, String givenuserName) {
		userID=givenuserID;
		userName=givenuserName;
	}
	
	   public static JPanel createPanel() {
		      JPanel panel = new JPanel();
		      panel.setLayout(new GridLayout(10, 4, 10, 10));
		      for (int i=0; i < 10; i++) {
		         for (int j=0; j < 4; j++) {
		            JLabel label = new JLabel("label " + i + ", " + j);
		            label.setFont(new Font("Arial", Font.PLAIN, 20));
		            panel.add(label);
		         }
		      }
		      return panel;
		   }

	
	public applicantHomePage() {
		setTitle("Hire!ME");
//		setResizable(false);
//		getAutoscrolls(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
//		ScrollPane scp=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
//		scp.setLayout(new FlowLayout());
//		scp.setBounds(428, 78, 600, 550);
//		JPanel paanel = new JPanel();
//		paanel.setBounds(0, 0, 10, 50);
//		paanel.setBackground(new Color(192, 192, 192));
//		scp.add(paanel);
//		
//		JPanel paanel1 = new JPanel();
//		paanel1.setBounds(100, 100, 10, 50);
//		paanel1.setBackground(new Color(192, 192, 192));
//		scp.add(paanel1);
//		contentPane.add(scp);

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 900);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Apply for a vacancy");
		btnNewButton.setBounds(80, 153, 200, 23);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(54,63,175));
		btnNewButton.setForeground(Color.WHITE);
		
		JButton communityWallBtn = new JButton("Community Wall");
		communityWallBtn.setBounds(80, 253, 200, 23);
		panel.add(communityWallBtn);
		communityWallBtn.setBackground(new Color(192, 192, 192));
		communityWallBtn.setForeground(new Color(54,63,175));
		
		communityWallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("communityWallBtn");
				communityWall communitywall=new communityWall();
				communitywall.userID=userID+"";
				communitywall.userType="Applicant";
				communitywall.userName=userName;
				communitywall.main(null);
				}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jobID = JOptionPane.showInputDialog("Enter Job ID");
				JDBCconnection conn=new JDBCconnection();
				ArrayList<Object> tempJobID=new ArrayList<Object>();
				tempJobID.add(jobID);
				int score=0;
				Quiz_Assessment quiz=new Quiz_Assessment();
				quiz.jobID=jobID;
				quiz.userID=userID+"";
				try(Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/firstTry", "root", "root");) {
					Statement stmt = connect.createStatement();
					String QUERY = "SELECT * FROM availableVacancy;";
					ResultSet rs = stmt.executeQuery(QUERY);
					String sqlaa = "select * from availableVacancy where ID="+jobID+";";
					System.out.println("sqlaa"+sqlaa);
					rs = stmt.executeQuery(sqlaa);
					if(rs.next())
					{
						rs = stmt.executeQuery(sqlaa);
						while(rs.next()){
							quiz.companyID=rs.getInt("companyID")+"";
		                }
		           }
					quiz.main(null);
					conn.applicantLogin(tempJobID, "applyJobCount");
					dispose();
				connect.close();
			} catch (SQLException errorSQL) {
			}
//				JOptionPane.showMessageDialog(contentPane, "You have applied successfully for the role!");
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("JOB RESULTS FOR YOUR PROFILE");
		lblNewLabel_1.setBounds(500, 40, 281, 17);
		lblNewLabel_1.setForeground(new Color(54, 63, 175));
		lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(242, 243, 255));
//		panel_1.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
//		panel_1.setBounds(440, 101, 600, 150);
//		contentPane.add(panel_1);
//		panel_1.setLayout(null);
		
//		JLabel lblNewLabel_2 = new JLabel("Java Dev");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		lblNewLabel_2.setBounds(10, 11, 400, 14);
//		panel_1.add(lblNewLabel_2);
		
//		JLabel lblNewLabel_3 = new JLabel("Joining Date: ");
//		lblNewLabel_3.setBounds(10, 51, 500, 18);
//		panel_1.add(lblNewLabel_3);
		
//		JLabel lblNewLabel_3_1 = new JLabel("Employement Type: ");
//		lblNewLabel_3_1.setBounds(10, 80, 500, 18);
//		panel_1.add(lblNewLabel_3_1);
		
//		JLabel lblNewLabel_3_1_1 = new JLabel("Company Name: ");
//		lblNewLabel_3_1_1.setBounds(10, 109, 500, 18);
//		panel_1.add(lblNewLabel_3_1_1);
		
//		JButton applyNowButton = new JButton("Apply Now");
//		applyNowButton.setBounds(390, 49, 100, 23);
//		applyNowButton.setBackground(new Color(54,63,175));
//		applyNowButton.setForeground(Color.WHITE);
//		panel_1.add(applyNowButton);
		
		
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(50, 30, 300, 50);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        contentPane.add(scrollPane);
//        contentPane.setContentPane(contentPane);
		ArrayList<ArrayList<Object>> jobVacancy=new ArrayList<ArrayList<Object>>();
		String DB_URL = "jdbc:mysql://localhost/firstTry";
		String USER = "root";
		String PASS = "root";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			
			Statement stmt = conn.createStatement();
			String QUERY = "SELECT * FROM availableVacancy;";
			ResultSet rs = stmt.executeQuery(QUERY);
			String sqlaa = "SELECT * FROM availableVacancy;";
			System.out.println("sqlaa"+sqlaa);
			rs = stmt.executeQuery(sqlaa);
			if(rs.next())
			{
				rs = stmt.executeQuery(sqlaa);
				while(rs.next()){
					ArrayList<Object> temp=new ArrayList<Object>();
					temp.add(rs.getInt(1));
					temp.add(rs.getString(2));
					temp.add(rs.getInt(3));
					temp.add(rs.getString(4));
					temp.add(rs.getString(5));
					temp.add(rs.getInt(6));
					System.out.println("temp "+temp);
					jobVacancy.add(temp);
                }
           }
           conn.close();
		} catch (SQLException errorSQL) {
       	errorSQL.printStackTrace();
       	}
		
		int currBoxXValue=440;
		int currBoxYValue=101;
		int boxWidth=600;
		int boxHeight=150;
		
		int currjobNameXValue=10;
		int currjobNameYValue=11;
		int jobWidth=500;
		int jobHeight=18;
		
		int currDateXValue=10;
		int currDateYValue=51;
		int dateWidth=500;
		int dateHeight=18;
		
		int currEmpXValue=10;
		int currEmpYValue=80;
		int EmpWidth=500;
		int EmpHeight=18;
		
		int currCompNameXValue=10;
		int currCompNameYValue=109;
		int CompNameWidth=500;
		int CompNameHeight=18;
		
		int currApplyBtnXValue=390;
		int currApplyBtnYValue=49;
		int ApplyBtnWidth=100;
		int ApplyBtnHeight=23;
		
		for(int i=0;i<jobVacancy.size();i++) {
			ArrayList<Object> temp=new ArrayList<Object>();
			temp=jobVacancy.get(i);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(242, 243, 255));
			panel_1.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
			panel_1.setBounds(currBoxXValue, currBoxYValue, boxWidth, boxHeight);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel(temp.get(1)+"");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(currjobNameXValue, currjobNameYValue, jobWidth, jobHeight);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Joining Date: "+temp.get(4));
			lblNewLabel_3.setBounds(currDateXValue, currDateYValue, dateWidth, dateHeight);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("Employement Type: "+temp.get(3));
			lblNewLabel_3_1.setBounds(currEmpXValue, currEmpYValue, EmpWidth, EmpHeight);
			panel_1.add(lblNewLabel_3_1);
			
			String CompanyName=temp.get(2)+"";
			JLabel lblNewLabel_3_1_1 = new JLabel("Company Name: "+CompanyName);
			lblNewLabel_3_1_1.setBounds(currCompNameXValue, currCompNameYValue, CompNameWidth, CompNameHeight);
			panel_1.add(lblNewLabel_3_1_1);
			
			String jobID = temp.get(0)+"";
			JLabel lblNewLabel_3_1_1_a = new JLabel("Job ID: "+jobID);
			lblNewLabel_3_1_1_a.setBounds(currApplyBtnXValue, currApplyBtnYValue, ApplyBtnWidth, ApplyBtnHeight);
			lblNewLabel_3_1_1_a.setForeground(new Color(54,63,175));
			lblNewLabel_3_1_1_a.setBackground(Color.WHITE);
			panel_1.add(lblNewLabel_3_1_1_a);
			
//			JButton applyNowButton = new JButton("Apply Now");
//			applyNowButton.setBounds(currApplyBtnXValue, currApplyBtnYValue, ApplyBtnWidth, ApplyBtnHeight);
//			applyNowButton.setBackground(new Color(54,63,175));
//			applyNowButton.setForeground(Color.WHITE);
//			
//			applyNowButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(contentPane, "You have applied successfully for the role!");
//				}
//			});
			
//			panel_1.add(applyNowButton);
			
			
			currBoxYValue=currBoxYValue+174;
//			currjobNameYValue=currBoxYValue-190;
//			currDateYValue=currDateYValue+131;
//			currEmpYValue=currEmpYValue+131;
//			currCompNameYValue=currCompNameYValue+131;
//			currApplyBtnYValue=currApplyBtnYValue+131;
		}
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(780, 100, 500, 500);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\resize-16928559681016278379HireME5.png"));
		contentPane.add(lblNewLabel);
		setSize(900,500);
		Toolkit tk=Toolkit.getDefaultToolkit(); //Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); //Get the Screen resolution of our device.
		setSize(screenSize.width,screenSize.height);

	}
}
