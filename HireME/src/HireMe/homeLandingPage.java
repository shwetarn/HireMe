package HireMe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homeLandingPage extends JFrame {

	private JPanel contentPane;
	public static String titleBox="";
	public static Boolean buttonClicked=false;
	private JTextField userIDInput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeLandingPage frame = new homeLandingPage();
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
	public homeLandingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Get wings to your dreams here.....");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(108, 411, 572, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("ME");
		lblNewLabel_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 99));
		lblNewLabel_1_1.setBounds(83, 275, 300, 110);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("HIRE!");
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 99));
		lblNewLabel_1.setBounds(83, 165, 300, 110);
		contentPane.add(lblNewLabel_1);
		JPanel panel = new JPanel();
		panel.setBackground((new Color(56, 120, 211, 100)));
		panel.setForeground(Color.white);
		panel.setBounds(690, 100, 400, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
//		panel.add(lblNewLabel_3);
		panel.setOpaque(false);
		
		JLabel lblNewLabel_3 = new JLabel(titleBox);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(0, 30, 400, 30);
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnNewButtonR = new JButton("LOGIN AS COMPANY");
		btnNewButtonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleBox=btnNewButtonR.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				buttonClicked=true;
			}
		});
		btnNewButtonR.setBackground(new Color(255, 255, 255));
		btnNewButtonR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered");
//				if(!buttonClicked)
//				{
					titleBox=btnNewButtonR.getLabel();
					lblNewLabel_3.setText(titleBox);
					panel.add(lblNewLabel_3);
					panel.setOpaque(true);
//				}
//				panel.add(lblNewLabel_3);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
				if(!buttonClicked)
				{
					titleBox="";
					lblNewLabel_3.setText(titleBox);
					panel.remove(lblNewLabel_3);
					panel.setOpaque(false);
				}
//				panel.remove(lblNewLabel_3);
			}
		});
		btnNewButtonR.setBounds(296, 500, 200, 23);
		contentPane.add(btnNewButtonR);
		
		JButton btnNewButton = new JButton("LOGIN AS APPLICANT");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				titleBox=btnNewButton.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				
				
				//User ID
				userIDInput = new JTextField();
				userIDInput.setBounds(50, 120, 300, 40);
				userIDInput.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.white));
				userIDInput.setForeground(Color.white);
				userIDInput.setBackground((new Color(0, 0, 0, 100)));
				userIDInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
				userIDInput.setOpaque(false);
				panel.add(userIDInput);
				userIDInput.setColumns(10);
				
				JLabel userIDLabel = new JLabel("APPLICANT ID");
				userIDLabel.setBounds(50, 100, 132, 14);
				userIDLabel.setForeground(Color.white);
				panel.add(userIDLabel);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!buttonClicked)
				{
					titleBox="";
					lblNewLabel_3.setText(titleBox);
					panel.remove(lblNewLabel_3);
					panel.setOpaque(false);
				}
//				panel.remove(lblNewLabel_3);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleBox=btnNewButton.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				buttonClicked=true;
			}
		});
		btnNewButton.setBounds(86, 500, 200, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButtonR_1 = new JButton("REGISTER AS COMPANY");
		btnNewButtonR_1.setBackground(Color.WHITE);
		btnNewButtonR_1.setBounds(296, 530, 200, 23);
		btnNewButtonR_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				titleBox=btnNewButtonR_1.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
				if(!buttonClicked)
				{
					titleBox="";
					lblNewLabel_3.setText(titleBox);
					panel.remove(lblNewLabel_3);
					panel.setOpaque(false);
				}
//				panel.remove(lblNewLabel_3);
			}
		});
		btnNewButtonR_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleBox=btnNewButtonR_1.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				buttonClicked=true;
			}
		});
		contentPane.add(btnNewButtonR_1);
		
		JButton btnRegisterAsApplicant = new JButton("REGISTER AS APPLICANT");
		btnRegisterAsApplicant.setBackground(Color.WHITE);
		btnRegisterAsApplicant.setBounds(86, 530, 200, 23);
		btnRegisterAsApplicant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered");
				titleBox=btnRegisterAsApplicant.getLabel();
				
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				
				panel.setOpaque(true);
//				panel.add(lblNewLabel_3);
//				panel.setBackground((new Color(213, 134, 145, 123)));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
				if(!buttonClicked)
				{
					titleBox="";
					lblNewLabel_3.setText(titleBox);
					panel.remove(lblNewLabel_3);
					panel.setOpaque(false);
				}
			}
		});
		btnRegisterAsApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleBox=btnRegisterAsApplicant.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				buttonClicked=true;
			}
		});
		contentPane.add(btnRegisterAsApplicant);
		
		JButton btnLoginAsAdmin = new JButton("LOGIN AS ADMIN");
		btnLoginAsAdmin.setBackground(Color.WHITE);
		btnLoginAsAdmin.setBounds(186, 560, 200, 23);
		btnLoginAsAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				titleBox=btnLoginAsAdmin.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
				if(!buttonClicked)
				{
					titleBox="";
					lblNewLabel_3.setText(titleBox);
					panel.remove(lblNewLabel_3);
					panel.setOpaque(false);
				}
//				panel.remove(lblNewLabel_3);
			}
		});
		btnLoginAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleBox=btnLoginAsAdmin.getLabel();
				lblNewLabel_3.setText(titleBox);
				panel.add(lblNewLabel_3);
				panel.setOpaque(true);
				buttonClicked=true;
			}
		});
		contentPane.add(btnLoginAsAdmin);
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\Untitled design (10).gif"));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
	}
}
