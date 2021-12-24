package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	private JPanel contentPane;
    public static JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
    
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/layouts/biblioindex.jpg")));
		setBackground(new Color(65, 105, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(0, 54, 674, 10);
		contentPane.add(panel);
		// comment
		JLabel lblNewLabel = new JLabel("Bienvenue a votre Librairie");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBounds(169, 11, 410, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		panel_1.setBounds(179, 64, 10, 276);
		contentPane.add(panel_1);
		JButton loginBtn = new JButton("Login");
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginInterface = new Login();
				loginInterface.setVisible(true);
			}
		});
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		loginBtn.setBackground(new Color(153, 0, 255));
		loginBtn.setActionCommand("Login");
		loginBtn.setBounds(10, 92, 153, 42);
		contentPane.add(loginBtn);
		
		JButton registerBtn = new JButton("Inscription");
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfos userInfos = new UserInfos();
				userInfos.setVisible(true);
				//Home.class.dispose();
				frame.dispose();
				
			}
		});
		registerBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		registerBtn.setForeground(new Color(255, 255, 255));
		registerBtn.setBackground(new Color(153, 0, 255));
		registerBtn.setActionCommand("Login");
		registerBtn.setBounds(10, 151, 153, 42);
		contentPane.add(registerBtn);
		
		JButton catalogueBtn = new JButton("Emprunter");
		catalogueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprunterLivre empruneter = new EmprunterLivre();
				empruneter.setVisible(true);
			}
		});
		catalogueBtn.setForeground(new Color(255, 255, 255));
		catalogueBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn.setBackground(new Color(153, 0, 255));
		catalogueBtn.setActionCommand("Login");
		catalogueBtn.setBounds(10, 213, 153, 42);
		contentPane.add(catalogueBtn);
		
		JButton catalogueBtn_1 = new JButton("Catalogue");
		catalogueBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Catalogue catalogue = new Catalogue();
				catalogue.setVisible(true);
			}
		});
		catalogueBtn_1.setForeground(Color.WHITE);
		catalogueBtn_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn_1.setBackground(new Color(153, 0, 255));
		catalogueBtn_1.setActionCommand("Login");
		catalogueBtn_1.setBounds(10, 273, 153, 42);
		contentPane.add(catalogueBtn_1);
		
		JButton registerBtn_1 = new JButton("");
		registerBtn_1.setIcon(new ImageIcon(Home.class.getResource("/layouts/biblioindex.jpg")));
		registerBtn_1.setForeground(Color.WHITE);
		registerBtn_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		registerBtn_1.setBackground(new Color(153, 0, 255));
		registerBtn_1.setActionCommand("Login");
		registerBtn_1.setBounds(199, 75, 475, 265);
		contentPane.add(registerBtn_1);
	}
}
