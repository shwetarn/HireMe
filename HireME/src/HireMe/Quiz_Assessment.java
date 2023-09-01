package HireMe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Quiz_Assessment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static ArrayList<ArrayList<Object>> quizQuestions=new ArrayList<ArrayList<Object>>();
	public static String jobID=19+"";
	public static String userID;
	public static String companyID;
	public static int counterMarks=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz_Assessment frame = new Quiz_Assessment();
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
	public Quiz_Assessment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(242, 243, 255));
		setContentPane(contentPane);
		
		JPanel textgrid = new JPanel();
		
		GridLayout gl=new GridLayout(100,100);
		textgrid.setLayout(gl);
		
//		test.setForeground(new Color(128, 128, 128));
//		test.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		
		String DB_URL = "jdbc:mysql://localhost/firstTry";
		String USER = "root";
		String PASS = "root"; 
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			Statement stmt = conn.createStatement();
			
			String QUERY = "SELECT * FROM availableVacancy";
            ResultSet rs = stmt.executeQuery(QUERY);
            String sqlaa = "SELECT * FROM availableVacancy where ID="+jobID+";";
            System.out.println("sqlaa"+sqlaa);
            rs = stmt.executeQuery(sqlaa);
            if(rs.next())
            {
            	rs = stmt.executeQuery(sqlaa);
            	while(rs.next()){
            		String answerOne=rs.getString("answerOne");
            		String answerTwo=rs.getString("answerTwo");;
            		String answerThree=rs.getString("answerThree");
            		String answerFour=rs.getString("answerFour");
            		String answerFive=rs.getString("answerFive");
            		
            		JLabel spacelINETop = new JLabel("     ");
            		textgrid.add(spacelINETop);
            		
            		JLabel spacelINET = new JLabel("     ANSWER THE QUESTIONS GIVEN BELOW AND SUBMIT     ");
            		spacelINET.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(spacelINET);
            		
            		JLabel spacelINETop1 = new JLabel("     ");
            		textgrid.add(spacelINETop1);
            		
            		JLabel spacelINE1 = new JLabel("     ");
            		textgrid.add(spacelINE1);
            		
            		JLabel quest1 = new JLabel("     "+"Question 1: "+rs.getString("questionOne")+"     ");
            		quest1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(quest1);
            		
            		String[] optionOne = rs.getString("optionsOne").split(",");
            		JRadioButton rb1,rb2;    
            		rb1=new JRadioButton(optionOne[0]);    
            		rb1.setBounds(100,50,100,30);      
            		rb2=new JRadioButton(optionOne[1]);    
            		rb2.setBounds(100,100,100,30);    
            		ButtonGroup bg=new ButtonGroup();    
            		bg.add(rb1);bg.add(rb2);
            		rb1.setOpaque(false);
            		rb2.setOpaque(false);
            		textgrid.add(rb1);
            		textgrid.add(rb2);
            		
            		JLabel spacelINE2 = new JLabel("     ");
            		textgrid.add(spacelINE2);
            		
            		JLabel quest2 = new JLabel("     "+"Question 2: "+rs.getString("questionTwo")+"     ");
            		quest2.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(quest2);
            		String[] optionTwo = rs.getString("optionsTwo").split(",");
            		JRadioButton o21,o22;    
            		o21=new JRadioButton(optionTwo[0]);    
            		o21.setBounds(100,50,100,30);      
            		o22=new JRadioButton(optionTwo[1]);    
            		o22.setBounds(100,100,100,30);    
            		ButtonGroup back2=new ButtonGroup();    
            		back2.add(o21);back2.add(o22);
            		o21.setOpaque(false);
            		o22.setOpaque(false);
            		textgrid.add(o21);
            		textgrid.add(o22);
            		
            		JLabel spacelINE3 = new JLabel("     ");
            		textgrid.add(spacelINE3);
            		
            		JLabel quest3 = new JLabel("     "+"Question 3:  "+rs.getString("questionThree")+"     ");
            		quest3.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(quest3);
            		String[] optionThree = rs.getString("optionsThree").split(",");
            		JRadioButton o31,o32;    
            		o31=new JRadioButton(optionThree[0]);    
            		o31.setBounds(100,50,100,30);      
            		o32=new JRadioButton(optionThree[1]);    
            		o32.setBounds(100,100,100,30);    
            		ButtonGroup back3=new ButtonGroup();    
            		back3.add(o31);back2.add(o32);
            		o31.setOpaque(false);
            		o32.setOpaque(false);
            		textgrid.add(o31);
            		textgrid.add(o32);
            		
            		JLabel spacelINE4 = new JLabel("     ");
            		textgrid.add(spacelINE4);
            		
            		JLabel quest4 = new JLabel("     "+"Question 4:  "+rs.getString("questionFour")+"     ");
            		quest4.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(quest4);
            		String[] optionFour = rs.getString("optionsFour").split(",");
            		JRadioButton o41,o42;    
            		o41=new JRadioButton(optionFour[0]);    
            		o41.setBounds(100,50,100,30);      
            		o42=new JRadioButton(optionFour[1]);    
            		o42.setBounds(100,100,100,30);    
            		ButtonGroup back4=new ButtonGroup();    
            		back4.add(o41);back4.add(o42);
            		o41.setOpaque(false);
            		o42.setOpaque(false);
            		textgrid.add(o41);
            		textgrid.add(o42);

            		JLabel spacelINE5 = new JLabel("     ");
            		textgrid.add(spacelINE5);
            		
            		JLabel quest5 = new JLabel("     "+"Question 5:  "+rs.getString("questionFive")+"     ");
            		quest5.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
            		textgrid.add(quest5);
            		String[] optionFive = rs.getString("optionsFive").split(",");
            		JRadioButton o51,o52;    
            		o51=new JRadioButton(optionFive[0]);    
            		o51.setBounds(100,50,100,30);      
            		o52=new JRadioButton(optionFive[1]);    
            		o52.setBounds(100,100,100,30);    
            		ButtonGroup back5=new ButtonGroup();    
            		back5.add(o51);back5.add(o52);
            		o51.setOpaque(false);
            		o52.setOpaque(false);
            		textgrid.add(o51);
            		textgrid.add(o52);
            		
            		JLabel spacelINE = new JLabel("     ");
            		textgrid.add(spacelINE);
            		JButton submitAssessment=new JButton("Submit Assessment");    
            		submitAssessment.setBounds(100,100,100, 40);
            		submitAssessment.setBackground(new Color(56, 120, 211, 100));
            		submitAssessment.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				if(rb1.isSelected() && answerOne.equals("1"))
            					counterMarks=counterMarks+1;
            				else if (rb2.isSelected() && answerOne.equals("2"))
        					counterMarks=counterMarks+1;
            				
            				if(o21.isSelected() && answerTwo.equals("1"))
            					counterMarks=counterMarks+1;
            				else if (o22.isSelected() && answerTwo.equals("2"))
        					counterMarks=counterMarks+1;
            				
            				if(o31.isSelected() && answerThree.equals("1"))
            					counterMarks=counterMarks+1;
            				else if (o32.isSelected() && answerThree.equals("2"))
        					counterMarks=counterMarks+1;
            				
            				if(o41.isSelected() && answerFour.equals("1"))
            					counterMarks=counterMarks+1;
            				else if (o42.isSelected() && answerFour.equals("2"))
        					counterMarks=counterMarks+1;
            				
            				if(o51.isSelected() && answerFive.equals("1"))
            					counterMarks=counterMarks+1;
            				else if (o52.isSelected() && answerFive.equals("2"))
        					counterMarks=counterMarks+1;
            				
            				System.out.println("counterMarks "+counterMarks);
            				ArrayList<Object> temp=new ArrayList<Object>();
				            	temp.add("Applied");
				            	temp.add(jobID);
				            	temp.add(userID);
				            	temp.add(companyID);
				            	temp.add(0+"");
				            	temp.add(counterMarks+"");
				            	JDBCconnection jdbc_co = new JDBCconnection();
				            	jdbc_co.applicantLogin(temp, "addNewApplication");
            				
            			}
            		});
            		textgrid.add(submitAssessment);
            		JLabel spaceLine = new JLabel("\n");
            		spaceLine.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(spaceLine);
            		dispose();
            		
            		
                 }
            }
    		conn.close();	
		} catch (SQLException errorSQL) {
		}
		
		
		JScrollPane jp=new JScrollPane(textgrid,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		jp.setSize(100, 100);
//		jp.setViewportView(panel);
		jp.setBounds(0,80,1280,570);
		jp.setOpaque(false);
		textgrid.setBackground(new Color(56, 120, 211, 5));
		textgrid.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.BLACK));
		jp.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.BLACK));
		contentPane.add(jp);		
		JLabel lblNewLabel_1 = new JLabel("ASSESSMENT");
		lblNewLabel_1.setBounds(0, 40, 1350, 17);
		lblNewLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
		lblNewLabel_1.setForeground(new Color(54, 63, 175));
		lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\quiz-Page.gif"));
		lblNewLabel.setBounds(0, -30, 1280, 720);
		contentPane.add(lblNewLabel);
		
	}
}
