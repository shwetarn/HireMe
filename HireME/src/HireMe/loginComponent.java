package HireMe;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class loginComponent extends JFrame {

	private JPanel contentPane;
	private JTextField IDValue;
	private JTextField passwordValue;
//	private JTextField contactPersonValue;
	public static String userType="";
	public static int ApplicantID=-1;
	public static void setUserType(String typeUser) {
		userType=typeUser;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginComponent frame = new loginComponent();
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
	public loginComponent() {
		setTitle("Login - Hire!ME");
		JDBCconnection connectionJDBC=new JDBCconnection();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
//		contentPane.setSize(345,345);
		
		JLabel errorMessage_1 = new JLabel(userType+"ID or Password is incorrect! Please verify and re-enter.");
		errorMessage_1.setBounds(50, 240, 549, 14);
		errorMessage_1.setForeground(Color.WHITE);
		
		JLabel errorMessage_2 = new JLabel("Some fields are empty! Please verify and re-submit!");
		errorMessage_2.setBounds(50, 240, 549, 14);
		errorMessage_2.setForeground(Color.WHITE);
		
//		JLabel successMessage_1 = new JLabel(userType+" Registered Successfully!");
//		successMessage_1.setBounds(395, 472, 549, 14);
//		successMessage_1.setForeground(Color.WHITE);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IDValue.getText().isEmpty() || passwordValue.getText().isEmpty()) {
					contentPane.add(errorMessage_2);
					contentPane.remove(errorMessage_1);
					errorMessage_1.setForeground(Color.WHITE);
					errorMessage_2.setForeground(Color.RED);
				}
				else {
					if(userType.equals("Applicant"))
					{
						ArrayList<Object> givenData=new ArrayList<Object>();
						givenData.add(IDValue.getText());
						givenData.add(passwordValue.getText());
						boolean connectionestablished = connectionJDBC.applicantLogin(givenData,"applicantLogin");
						if(!connectionestablished) {
							contentPane.remove(errorMessage_2);
							contentPane.add(errorMessage_1);
							errorMessage_1.setForeground(Color.RED);
							errorMessage_2.setForeground(Color.WHITE);
						}
//						String DB_URL = "jdbc:mysql://localhost/firstTry";
//						String USER = "root";
//						String PASS = "root";
//						try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//						         ) {
//							Statement stmt = conn.createStatement();
//				            String QUERY = "SELECT applicantID FROM applicantInfo";
//				            ResultSet rs = stmt.executeQuery(QUERY);
//				            String sqlaa = "SELECT * FROM applicantInfo" +" WHERE (applicantID = "+IDValue.getText()+" and applicantPassword = '"+passwordValue.getText()+"');";
//				            System.out.println("sqlaa"+sqlaa);
//				            rs = stmt.executeQuery(sqlaa);
//				            if(rs.next())
//				            {
//				            	System.out.println("rs.toString()"+rs.toString());
//				            	rs = stmt.executeQuery(sqlaa);
//				            	while(rs.next()){
//				            		System.out.println("rs.next(");
//				            		applicantHomePage hp=new applicantHomePage();
//				            		hp.setuserID(rs.getInt("applicantID"),rs.getString("applicantName"));
//				            		hp.main(null);
////				            		System.out.println("applicantID "+rs.getInt("applicantID"));
//				            		System.out.println("applicantEMail "+rs.getString("applicantEMail"));
//				            		}
//				            }
//				            else
//				            {
//				            	System.out.println("Empty");
//								contentPane.remove(errorMessage_2);
//								contentPane.add(errorMessage_1);
//								errorMessage_1.setForeground(Color.RED);
//								errorMessage_2.setForeground(Color.WHITE);
//				            }
//				            conn.close();
//				            } catch (SQLException errorSQL) {
//				            	errorSQL.printStackTrace();
//				            	}
					}
					else if(userType.equals("Company"))
					{
						System.out.println("Logged in as Company");
						ArrayList<Object> givenData=new ArrayList<Object>();
						givenData.add(IDValue.getText());
						givenData.add(passwordValue.getText());
						boolean connectionestablished = connectionJDBC.applicantLogin(givenData,"companyLogin");
						if(!connectionestablished) {
							contentPane.remove(errorMessage_2);
							contentPane.add(errorMessage_1);
							errorMessage_1.setForeground(Color.RED);
							errorMessage_2.setForeground(Color.WHITE);
						}
						else {
							CompanyHomePage comp=new CompanyHomePage();
							comp.setuserID(IDValue.getText());
							comp.main(null);
//							comp.setuserID(IDValue.getText(), "");
						}
//						String DB_URL = "jdbc:mysql://localhost/firstTry";
//						String USER = "root";
//						String PASS = "root";
					}
					else if(userType.equals("Admin")) {
						ArrayList<Object> givenData=new ArrayList<Object>();
						givenData.add(IDValue.getText());
						givenData.add(passwordValue.getText());
						boolean connectionestablished = connectionJDBC.applicantLogin(givenData,"adminLogin");
						
						if(!connectionestablished) {
							contentPane.remove(errorMessage_2);
							contentPane.add(errorMessage_1);
							errorMessage_1.setForeground(Color.RED);
							errorMessage_2.setForeground(Color.WHITE);
						}
						else {
//							adminHomePage admin=new adminHomePage();
//							admin.main(null);
						}
						
						System.out.println("Logged in as Admin");
//						String DB_URL = "jdbc:mysql://localhost/firstTry";
//						String USER = "root";
//						String PASS = "root";
//						try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//						         ) {
//							Statement stmt = conn.createStatement();
//				            String QUERY = "SELECT adminID FROM adminInfo";
//				            ResultSet rs = stmt.executeQuery(QUERY);
//				            String sqlaa = "SELECT * FROM adminInfo" +" WHERE (adminID = "+IDValue.getText()+" and adminPassword = '"+passwordValue.getText()+"');";
//				            System.out.println("sqlaa"+sqlaa);
//				            rs = stmt.executeQuery(sqlaa);
//				            if(rs.next())
//				            {
//				            	rs = stmt.executeQuery(sqlaa);
//				            	while(rs.next()){
//				            		System.out.println("ID: " + rs.getInt("adminID"));
//				            		System.out.println(rs.getString("adminEMail"));
//				                 }
//				            	conn.close();
//				            	adminHomePage adminHome=new adminHomePage();
//				            }
//				            else
//				            {
//				            	System.out.println("Empty");
//								contentPane.remove(errorMessage_2);
//								contentPane.add(errorMessage_1);
//								errorMessage_1.setForeground(Color.RED);
//								errorMessage_2.setForeground(Color.WHITE);
//				            }
//						} catch (SQLException errorSQL) {
//			            	errorSQL.printStackTrace();
//			            	}
//					}
//					successMessage_1.setForeground(new Color(0,117,0));
				}
				}
			}
		});
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(new Color(54, 63, 175));
		loginBtn.setBounds(50, 275, 283, 38);
		contentPane.add(loginBtn);
		
		IDValue = new JTextField();
		IDValue.setBackground(new Color(242, 243, 255));
		IDValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		IDValue.setBounds(50, 105, 283, 35);
		contentPane.add(IDValue);
		IDValue.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(50, 138, 283, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setBounds(50, 157, 174, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(userType.toUpperCase()+" ID");
		lblNewLabel_1.setBounds(50, 80, 174, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordValue = new JTextField();
		passwordValue.setColumns(10);
		passwordValue.setBackground(new Color(242, 243, 255));
		passwordValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		passwordValue.setBounds(50, 182, 283, 35);
		contentPane.add(passwordValue);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(50, 215, 283, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(userType.toUpperCase()+" LOGIN - HIRE!ME");
		lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(50, 32, 283, 14);
		contentPane.add(lblNewLabel_1_1);
		
		setSize(390,375);
	}
}
