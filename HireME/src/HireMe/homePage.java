package HireMe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Panel;

public class homePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
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
	public homePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton registerApplicant = new JButton("Register as an Applicant");
		registerApplicant.setForeground(new Color(54,63,175));
		registerApplicant.setBackground(new Color(242, 243, 255));
		registerApplicant.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
		registerApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applicantRegister lo=new applicantRegister();
				lo.setUserType("Applicant");
				lo.main(null);
			}
		});
		registerApplicant.setBounds(280, 202, 202, 23);
		contentPane.add(registerApplicant);
		
		JButton registerCompany = new JButton("Register as a Company");
		registerCompany.setForeground(new Color(54,63,175));
		registerCompany.setBackground(new Color(242, 243, 255));
		registerCompany.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
		registerCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companyRegister lo=new companyRegister();
				lo.setUserType("Company");
				lo.main(null);
			}
		});
		registerCompany.setBounds(280, 253, 202, 23);
		contentPane.add(registerCompany);
		
		JButton loginApplicant = new JButton("Login as an Applicant");
		loginApplicant.setForeground(new Color(54,63,175));
		loginApplicant.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
		loginApplicant.setBackground(new Color(242, 243, 255));
		loginApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginComponent loginComp=new loginComponent();
				loginComp.setUserType("Applicant");
				loginComp.main(null);
			}
		});
		loginApplicant.setBounds(58, 202, 202, 23);
		contentPane.add(loginApplicant);
		
		JButton loginCompany = new JButton("Login as a Company");
		loginCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginComponent loginComp=new loginComponent();
				loginComp.setUserType("Company");
				loginComp.main(null);
			}
		});
		loginCompany.setForeground(new Color(54,63,175));
		loginCompany.setBackground(new Color(242, 243, 255));
		loginCompany.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
		loginCompany.setBounds(58, 253, 202, 23);
		contentPane.add(loginCompany);
		
		JButton loginAdmin = new JButton("Login as an Admin");
		loginAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginComponent loginComp=new loginComponent();
				loginComp.setUserType("Admin");
				loginComp.main(null);
			}
		});
		loginAdmin.setForeground(new Color(54,63,175));
		loginAdmin.setBackground(new Color(242, 243, 255));
		loginAdmin.setBounds(159, 304, 202, 23);
		loginAdmin.setBorder(BorderFactory.createLineBorder(new Color(54,63,175)));
		contentPane.add(loginAdmin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\resize-16927836831459327357HireME.png"));
		lblNewLabel.setBounds(142, 0, 250, 250);
		contentPane.add(lblNewLabel);
		setSize(540,400);
		setResizable(false);
//		Panel panel = new Panel();
//		panel.setBackground(new Color(1,1,1,1));
//		panel.setBounds(116, 70, 230, 287);
//		contentPane.add(panel);
//		setSize(500,500);
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\resize-16927731181707712889welding676401280.jpg"));
//		lblNewLabel.setBounds(0, 0, 500, 500);
//		contentPane.add(lblNewLabel);
	}
}
