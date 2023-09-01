package HireMe;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class communityWall extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String userID="";
	public static String userType="";
	public static String userName="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					communityWall frame = new communityWall();
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
	public communityWall() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shweta.rn\\Downloads\\Hire!ME (7).png"));
		setTitle("Community Wall - Hire!ME");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		JLabel lblNewLabel = new JLabel("COMMUNITY WALL - HIRE!ME");
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(54, 63, 175));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds((screenSize.width-250)/2, 36, 250, 18);
		contentPane.add(lblNewLabel);
//		contentPane.add(panel);


//		contentPane.add(jp);
		
		JPanel textgrid = new JPanel();

//		textgrid.setLayout(null);
		GridLayout gl=new GridLayout(100,100);
		textgrid.setLayout(gl);
		int xcount=0;
		int ycount=0;
		JLabel test = new JLabel("");
		test.setForeground(new Color(128, 128, 128));
		test.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		textgrid.add(test);
		textgrid.setBackground(new Color(242, 243, 255));
		String DB_URL = "jdbc:mysql://localhost/firstTry";
		String USER = "root";
		String PASS = "root"; 
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			Statement stmt = conn.createStatement();
			String QUERY = "SELECT * FROM communityWall";
            ResultSet rs = stmt.executeQuery(QUERY);
            String sqlaa = "SELECT * FROM communityWall;";
            System.out.println("sqlaa"+sqlaa);
            rs = stmt.executeQuery(sqlaa);
            if(rs.next())
            {
            	rs = stmt.executeQuery(sqlaa);
            	while(rs.next()){
            		JLabel userIDt = new JLabel("     "+"Posted by: "+rs.getString("userName"));
            		userIDt.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(userIDt);
            		
            		JLabel userTypea = new JLabel("     "+"User Type: "+rs.getString("UserType"));
//            		testab.setForeground(new Color(128, 128, 128));
            		userTypea.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(userTypea);
            		
            		JLabel Content = new JLabel("     "+"Content:  "+rs.getString("Content")+"     ");
            		Content.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(Content);
            		String star="*";
//            		String star = new String(Character.toChars(11088));
            		int rating=rs.getInt("RatingFeedback");
            		String strRating="";
            		for(int i=0;i<rating;i++)
            			strRating=strRating+star+" ";
            		System.out.println(strRating);
//            		if(rating>0 && rating<=1)
//            			strRating="⭐";
//            		else if(rating>1 && rating<=2)
//            			strRating="⭐ ⭐";
//            		else if(rating>2 && rating<=3)
//            			strRating="⭐ ⭐ ⭐";
//            		else if(rating>3 && rating<=4)
//            			strRating="★ ★ ★ ★";
//            		else if(rating>4)
//            			strRating="⭐ ⭐ ⭐ ⭐ ⭐";
            		
            		JLabel ratingStar = new JLabel("     "+"Rating:  "+strRating+" --> "+rs.getInt("RatingFeedback")+"/5     ");
            		ratingStar.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(ratingStar);
            		System.out.println("rs.getString(\"UserID\")"+rs.getString("UserID"));
            		System.out.println("userID"+userID);
            		
            		if(rs.getString("UserID").equals(userID+"") || userType.equals("Admin")) {
            			JButton deletePostBtnt = new JButton("Delete Post ID "+rs.getString("PostID"));
            			deletePostBtnt.setForeground(Color.red);
            			deletePostBtnt.setBackground(new Color(242, 243, 255));
            			textgrid.add(deletePostBtnt);
            			deletePostBtnt.addActionListener(new ActionListener() {
            				public void actionPerformed(ActionEvent e) {
            					String postIDstr=deletePostBtnt.getLabel();
            					System.out.println("postIDstr  "+postIDstr);
            					String postID;
            					if(postIDstr.length()==17)
            						postID=postIDstr.charAt(15)+""+postIDstr.charAt(16)+"";
            					else
            						postID=postIDstr.charAt(postIDstr.length()-1)+"";
            					System.out.println("postIDpostID"+postID);
            					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            					         ) {
            			            String sql= "delete from communityWall where PostID = ?;";
//            			            "INSERT INTO Registration VALUES (?,?,?,?);";
            			    		PreparedStatement st= conn.prepareStatement(sql);
            			            st.setString(1, postID);
            			            System.out.println("st"+st);
            			            st.executeUpdate();
            			            conn.close();
            			            dispose();
            					} catch (SQLException errorSQL) {
            		            	errorSQL.printStackTrace();
            		            	}
            				}
            			});
            		}
//            			System.out.println("jsdgfjsfg");
//            			JButton deletePostBtnt = new JButton("X Delete Post");
//            			deletePostBtnt.setForeground(Color.red);
//            			deletePostBtnt.setBackground(new Color(242, 243, 255));
//            			textgrid.add(deletePostBtnt);
//            		}
            		
            		JLabel spaceLine = new JLabel("\n");
            		spaceLine.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
            		textgrid.add(spaceLine);
                 }
            }
			conn.close();	
	} catch (SQLException errorSQL) {
	}
		
		
//		JPanel panel = new JPanel();
//		panel.setBounds(100, 36, 200, 200);
		
//		panel.setForeground(new Color(54,63,175));
//		panel.setBackground(new Color(242, 243, 255));
//		panel.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
//		panel.setBackground(new Color(242, 243, 255));
//		panel.setLayout(null);
//		panel.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
//		textgrid.add(panel);
//		contentPane.add(panel);
		
//		for(int i=1;i<1001;i++)
//			{
//			JLabel tesabt = new JLabel("COMMUNITY WALL - HIRE!ME");
//			tesabt.setBounds(0,ycount+100,100,100);
//			textgrid.add(tesabt);
//			}
//			textgrid.add(new JTextField(String.valueOf(i),4));
//		contentPane.add(panel);
		
		JScrollPane jp=new JScrollPane(textgrid,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		jp.setSize(100, 100);
//		jp.setViewportView(panel);
		jp.setBounds(300,100,900,500);
		
		contentPane.add(jp);
		JButton btnNewButton = new JButton("+ Add a Post");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("userID"+userID);
				System.out.println("userType"+userType);
				String contentGiven = JOptionPane.showInputDialog("What do you want to say?");
				String ratingFeedbackGiven = JOptionPane.showInputDialog("Please rate on 5");
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         ) {
					System.out.println("Inserting records into the table...");
		            String sql= "INSERT INTO communityWall (UserType, UserID, Content, RatingFeedback,userName) VALUES (?,?,?,?,?);";
//		            "INSERT INTO Registration VALUES (?,?,?,?);";
		    		PreparedStatement st= conn.prepareStatement(sql);
		            st.setString(1, userType);
		            st.setString(2,userID+"");
		            st.setString(3,contentGiven);
		            st.setString(4,ratingFeedbackGiven);
		            st.setString(5,userName);
		            st.executeUpdate();
		            conn.close();
		            dispose();
				} catch (SQLException errorSQL) {
	            	errorSQL.printStackTrace();
	            	}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setBounds(59, 126, 189, 23);
		contentPane.add(btnNewButton);
		
//		JButton deletePostBtn = new JButton("X Delete a Post");
//		deletePostBtn.setForeground(Color.red);
//		deletePostBtn.setBackground(new Color(242, 243, 255));
//		deletePostBtn.setBounds(59, 166, 189, 23);
//		contentPane.add(deletePostBtn);
		
		
		setSize(screenSize.width,screenSize.height);
	}
}
