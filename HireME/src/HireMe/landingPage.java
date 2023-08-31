package HireMe;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class landingPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					landingPage frame = new landingPage();
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
	public landingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 243, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(700, 40, 400, 400);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shweta.rn\\Downloads\\Untitled design (5).gif"));
		lblNewLabel_2.setBounds(0,0,400,400);
		panel.add(lblNewLabel_2);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INVEST YOUR TIME AT A WORTHY PLACE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(41, 40, 600, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblWeAreBuilding = new JLabel("WE ARE BUILDING THE PAGE.");
		lblWeAreBuilding.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWeAreBuilding.setBounds(41, 133, 600, 50);
		contentPane.add(lblWeAreBuilding);
		
		JLabel lblThankYouFor = new JLabel("THANK YOU FOR YOUR PATIENCE.");
		lblThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThankYouFor.setBounds(41, 194, 600, 50);
		contentPane.add(lblThankYouFor);
		
		JLabel lblComingSoon = new JLabel("COMING SOON...");
		lblComingSoon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComingSoon.setBounds(41, 400, 600, 50);
		contentPane.add(lblComingSoon);
	}
}
