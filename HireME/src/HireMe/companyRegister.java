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
import java.sql.ResultSetMetaData;
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

public class companyRegister extends JFrame {

	private JPanel contentPane;
	private JTextField fullNameValue;
	private JTextField emailValue;
	private JTextField contactPersonValue;
	private JTextField mobileNoValue;
	private JTextField passwordValue;
//	private JTextField contactPersonValue;
	public static String userType="";
	private JTextField confirmPasswordValue;
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
					companyRegister frame = new companyRegister();
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
	public companyRegister() {
		setTitle("New Company Register - Hire!ME");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 345, 645);
		
//		contentPane.setSize(345,345);
		
		JLabel errorMessage_1 = new JLabel("Passwords do not match!");
		errorMessage_1.setBounds(95, 472, 549, 14);
		errorMessage_1.setForeground(Color.WHITE);
		
		JLabel errorMessage_2 = new JLabel("Some fields are empty! Please verify and re-submit!");
		errorMessage_2.setBounds(95, 472, 549, 14);
		errorMessage_2.setForeground(Color.WHITE);
		
		JLabel successMessage_1 = new JLabel(userType+" Registered Successfully!");
		successMessage_1.setBounds(95, 472, 549, 14);
		successMessage_1.setForeground(Color.WHITE);
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!confirmPasswordValue.getText().equals(passwordValue.getText())) {
					System.out.println("Passwords do not match!");
					contentPane.add(errorMessage_1);
					contentPane.remove(errorMessage_2);
					contentPane.remove(successMessage_1);
					errorMessage_1.setForeground(Color.RED);
					errorMessage_2.setForeground(Color.WHITE);
				}
				else if(fullNameValue.getText().isEmpty() || emailValue.getText().isEmpty() || contactPersonValue.getText().isEmpty() ||mobileNoValue.getText().isEmpty() || passwordValue.getText().isEmpty() ) {
					contentPane.add(errorMessage_2);
					contentPane.remove(errorMessage_1);
					contentPane.remove(successMessage_1);
					errorMessage_1.setForeground(Color.WHITE);
					errorMessage_2.setForeground(Color.RED);
				}
				else {
					int CompanyID=-1;
					contentPane.remove(errorMessage_1);
					contentPane.remove(errorMessage_2);
					contentPane.add(successMessage_1);
					errorMessage_1.setForeground(Color.WHITE);
					errorMessage_2.setForeground(Color.WHITE);
					successMessage_1.setForeground(new Color(0,117,0));
					
					if(userType.equals("Company")) {
						String DB_URL = "jdbc:mysql://localhost/firstTry";
						String USER = "root";
						String PASS = "root";
						ArrayList<String> mobilUser = new ArrayList<String>();
						try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						         ) {		      
						            System.out.println("Inserting records into the table...");
						            String sql= "INSERT INTO companyInfo (companyName, companyEMail, companyMobile, companyContactPersonName, companyPassword) VALUES (?,?,?,?,?);";
//						            "INSERT INTO Registration VALUES (?,?,?,?);";
						    		PreparedStatement st= conn.prepareStatement(sql);
						            st.setString(1, fullNameValue.getText());
						            st.setString(2,emailValue.getText());
						            st.setString(3,mobileNoValue.getText());
						            st.setString(4,contactPersonValue.getText());
						            st.setString(5,passwordValue.getText());
						            st.executeUpdate();
						            
//						            ResultSet rs=st.executeQuery("select * from companyInfo");
//						            ResultSetMetaData rsmd = rs.getMetaData();
//						            int columnsNumber = rsmd.getColumnCount();
//						            while (rs.next()) {
//						            	System.out.println(rs.getString(4));
//						            }
						            Statement stmt = conn.createStatement();
						            String QUERY = "SELECT companyID FROM companyInfo";
						            ResultSet rs = stmt.executeQuery(QUERY);
						            String sqlaa = "SELECT companyID FROM companyInfo" +" WHERE (companyName = '"+fullNameValue.getText()+"' and companyMobile = '"+mobileNoValue.getText()+"') and (companyEMail = '"+emailValue.getText()+"' and companyContactPersonName = '"+contactPersonValue.getText()+"') and companyPassword = '"+passwordValue.getText()+"'";
						            System.out.println("sqlaa"+sqlaa);
						            rs = stmt.executeQuery(sqlaa);
						            while(rs.next()){
						            	System.out.print("ID: " + rs.getInt("companyID"));
						            	CompanyID=rs.getInt("companyID");
//						            	System.out.print(", Age: " + rs.getInt("age"));
//						            	System.out.print(", First: " + rs.getString("first"));
//						            	System.out.println(", Last: " + rs.getString("last"));
						                 }
						            JOptionPane.showMessageDialog(contentPane, "Your ID is "+CompanyID+"! Please save and use it to login further!");

//						            while (stGETID.next()) {
//						            	System.out.println(rs.getString(1));
//						            }
//						            while (rs.next()) {          
//						            	for(int i = 1 ; i <= columnsNumber; i++){
//						                  System.out.print(rs.getString(i) + " ");}
//						              System.out.println();}
						            
//						            ResultSet rs=st.executeQuery("select * from companyInfo");
////						            ResultSet rs=st.executeQuery("select * from Registration");  
//						            while(rs.next())  
//						            	System.out.println(rs.getInt(4));  
						            } catch (SQLException errorSQL) {
						            	errorSQL.printStackTrace();
						            	}
						}
				}
			}
		});
		signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setBackground(new Color(54, 63, 175));
		signUpBtn.setBounds(395, 539, 283, 38);
		contentPane.add(signUpBtn);
		
		fullNameValue = new JTextField();
		fullNameValue.setBackground(new Color(242, 243, 255));
		fullNameValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		fullNameValue.setBounds(395, 108, 283, 35);
		contentPane.add(fullNameValue);
		fullNameValue.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(395, 141, 283, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("COMPANY E-MAIL");
		lblNewLabel.setBounds(395, 160, 174, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COMPANY NAME");
		lblNewLabel_1.setBounds(395, 83, 174, 14);
		contentPane.add(lblNewLabel_1);
		
		emailValue = new JTextField();
		emailValue.setColumns(10);
		emailValue.setBackground(new Color(242, 243, 255));
		emailValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		emailValue.setBounds(395, 185, 283, 35);
		contentPane.add(emailValue);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(395, 218, 283, 2);
		contentPane.add(separator_1);

		
		JLabel lblMobileNumber = new JLabel("CONTACT PERSON NAME");
		lblMobileNumber.setBounds(395, 237, 174, 14);
		contentPane.add(lblMobileNumber);
		
		contactPersonValue = new JTextField();
		contactPersonValue.setColumns(10);
		contactPersonValue.setBounds(395, 262, 283, 35);
		contactPersonValue.setBackground(new Color(242, 243, 255));
		contactPersonValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		contentPane.add(contactPersonValue);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(395, 295, 283, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblPassword = new JLabel("MOBILE NUMBER");
		lblPassword.setBounds(395, 314, 104, 14);
		contentPane.add(lblPassword);
		
		mobileNoValue = new JTextField();
		mobileNoValue.setColumns(10);
		mobileNoValue.setBounds(395, 339, 283, 35);
		mobileNoValue.setBackground(new Color(242, 243, 255));
		mobileNoValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		contentPane.add(mobileNoValue);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(395, 372, 283, 2);
		contentPane.add(separator_1_1_1);
		
		JLabel lblPassword_1 = new JLabel("PASSWORD");
		lblPassword_1.setBounds(395, 391, 134, 14);
		contentPane.add(lblPassword_1);
		
		passwordValue = new JTextField();
		passwordValue.setColumns(10);
		passwordValue.setBounds(395, 416, 283, 35);
		passwordValue.setBackground(new Color(242, 243, 255));
		passwordValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		contentPane.add(passwordValue);
		
		
//		JLabel contactPersonNameLabel = new JLabel("CONTACT PERSON NAME");
//		lblPassword_1.setBounds(395, 591, 134, 14);
//		contentPane.add(lblPassword_1);
//		
//		contactPersonValue = new JTextField();
//		contactPersonValue.setColumns(10);
//		contactPersonValue.setBounds(395, 616, 283, 35);
//		contactPersonValue.setBackground(new Color(242, 243, 255));
//		contactPersonValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
//		contentPane.add(contactPersonValue);
		
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(395, 449, 283, 2);
		contentPane.add(separator_1_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NEW "+userType.toUpperCase()+" REGISTER - HIRE!ME");
		lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(392, 35, 283, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblPassword_1_1 = new JLabel("CONFIRM PASSWORD");
		lblPassword_1_1.setBounds(395, 468, 134, 14);
		contentPane.add(lblPassword_1_1);
		
		confirmPasswordValue = new JTextField();
		confirmPasswordValue.setColumns(10);
		confirmPasswordValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		confirmPasswordValue.setBackground(new Color(242, 243, 255));
		confirmPasswordValue.setBounds(395, 493, 283, 35);
		contentPane.add(confirmPasswordValue);
		
		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(395, 526, 283, 2);
		contentPane.add(separator_1_1_1_1_1);
		contentPane.add(panel);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\Hire!ME (1).png"));
		lblNewLabel_2.setBounds(-264, -45, 1400, 1130);
		panel.add(lblNewLabel_2);
		panel.setLayout(null);
		setSize(750,655);
	}
}
