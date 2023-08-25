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

public class CompanyHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static String jobID="";
	public static void main(String[] args) {
		ArrayList<Object> tempSend=new ArrayList<Object>();
		tempSend.add(userID);
		JDBCconnection appTemp=new JDBCconnection();
		appTemp.applicantLogin(tempSend,"jobPostedDetails");
		appTemp.applicantLogin(tempSend,"companyDetails");
		System.out.println("companyInfo"+companyInfo);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyHomePage frame = new CompanyHomePage();
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
	public static String userID;
	public static ArrayList<ArrayList<Object>> jobVacancy=new ArrayList<ArrayList<Object>>();
	public static ArrayList<Object> companyInfo=new ArrayList<Object>();
	public static void setuserID(String givenuserID) {
		userID=givenuserID;
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

	
	public CompanyHomePage() {
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
		
		companyInfo.add("0");
		companyInfo.add("0");
		companyInfo.add("0");
		companyInfo.add("0");
		companyInfo.add("0");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 900);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\resize-1692897170709877064Untitleddesign.png"));
		lblNewLabel_4.setBounds(126, 29, 100, 100);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Company ID: "+userID);
		lblNewLabel_5.setBounds(30, 205, 250, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Company Name: "+companyInfo.get(1));
		lblNewLabel_5_1.setBounds(30, 251, 250, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Company E-Mail: "+companyInfo.get(2));
		lblNewLabel_5_1_1.setBounds(30, 297, 250, 14);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Company Mobile: "+companyInfo.get(3));
		lblNewLabel_5_1_1_1.setBounds(30, 343, 250, 14);
		panel.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Contact Person Name: "+companyInfo.get(4));
		lblNewLabel_5_1_1_1_1.setBounds(30, 390, 250, 14);
		panel.add(lblNewLabel_5_1_1_1_1);
		
		JButton btnNewButton = new JButton("Add New Vacancy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String jobTitle = JOptionPane.showInputDialog("Job Title");
		        System.out.println("jobTitle"+jobTitle);
		        
		        String vacancyType = JOptionPane.showInputDialog("Vacancy Type");
		        System.out.println("vacancyType"+vacancyType);
		        
		        String dateOfJoining = JOptionPane.showInputDialog("Date of Joining");
		        System.out.println("vacancyType"+dateOfJoining);
		        
		        ArrayList<Object> temp=new ArrayList<Object>();
		        temp.add(jobTitle);
		        temp.add(userID);
		        temp.add(vacancyType);
		        temp.add(dateOfJoining);
		        temp.add(0);
		        JDBCconnection appTemp=new JDBCconnection();
		        appTemp.applicantLogin(temp,"addNewJobVacancy");
		        dispose();
		        
			}
		});
		btnNewButton.setBounds(30, 436, 234, 23);
		
		JButton deleteVacancyBtn = new JButton("Delete Vacancy");
		deleteVacancyBtn.setBounds(30, 470, 234, 23);
		deleteVacancyBtn.setBackground(Color.RED);
		deleteVacancyBtn.setForeground(Color.WHITE);
		deleteVacancyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> tempSend=new ArrayList<Object>();
				String jobID = JOptionPane.showInputDialog("Enter Job ID");
				tempSend.add(jobID);
				System.out.println("jobID=temp.get(0);"+jobID);
		        JDBCconnection appTemp=new JDBCconnection();
		        appTemp.applicantLogin(tempSend,"deleteJobVacancy");
		        jobID="";
		        dispose();
			}
			
		});
		panel.add(deleteVacancyBtn);
		panel.add(btnNewButton);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("PAST JOB OPENINGS FOR YOUR COMPANY");
		lblNewLabel_1.setBounds(500, 40, 681, 17);
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
//		ArrayList<ArrayList<Object>> jobVacancy=new ArrayList<ArrayList<Object>>();
//		String DB_URL = "jdbc:mysql://localhost/firstTry";
//		String USER = "root";
//		String PASS = "root";
		
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
		int ApplyBtnWidth=200;
		int ApplyBtnHeight=23;
		
		int currDeleteBtnYValue=77;
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
			
			String jobID=temp.get(0)+"";
			JLabel lblNewLabel_3_1_1 = new JLabel("Job ID: "+jobID);
			lblNewLabel_3_1_1.setBounds(currCompNameXValue, currCompNameYValue, CompNameWidth, CompNameHeight);
			panel_1.add(lblNewLabel_3_1_1);
			
			String applicantCout = temp.get(5)+"";
			JLabel lblNewLabel_3_1_1_a = new JLabel("Applicant Count: "+applicantCout);
			lblNewLabel_3_1_1_a.setBounds(currApplyBtnXValue, currApplyBtnYValue, ApplyBtnWidth, ApplyBtnHeight);
			lblNewLabel_3_1_1_a.setForeground(new Color(54,63,175));
			lblNewLabel_3_1_1_a.setBackground(Color.WHITE);
			panel_1.add(lblNewLabel_3_1_1_a);
			
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
	}
}