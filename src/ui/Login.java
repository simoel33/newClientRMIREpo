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
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;

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
	public Login() {
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
		JLabel lblNewLabel = new JLabel("Login a votre Librairie");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBounds(191, 11, 410, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		panel_1.setBounds(179, 64, 10, 276);
		contentPane.add(panel_1);
		JButton loginBtn = new JButton("Login");
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
				UserInfos userInfos = new UserInfos();
				userInfos.setVisible(true);
			}
		});
		registerBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		registerBtn.setForeground(new Color(255, 255, 255));
		registerBtn.setBackground(new Color(153, 0, 255));
		registerBtn.setActionCommand("Login");
		registerBtn.setBounds(10, 151, 153, 42);
		contentPane.add(registerBtn);
		
		JButton catalogueBtn = new JButton("Catalogue");
		catalogueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Catalogue catalogue = new Catalogue();
				catalogue.setVisible(true);
			}
		});
		catalogueBtn.setForeground(new Color(255, 255, 255));
		catalogueBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn.setBackground(new Color(153, 0, 255));
		catalogueBtn.setActionCommand("Login");
		catalogueBtn.setBounds(10, 213, 153, 42);
		contentPane.add(catalogueBtn);
		
		loginField = new JTextField();
		loginField.setBackground(new Color(255, 255, 204));
		loginField.setBounds(368, 138, 189, 32);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		JButton loginToYourAccountBtn = new JButton("Login");
		loginToYourAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel adminPanel = new AdminPanel();
				adminPanel.setVisible(true);
			}
		});
		loginToYourAccountBtn.setBackground(new Color(153, 51, 255));
		loginToYourAccountBtn.setBounds(368, 257, 189, 34);
		contentPane.add(loginToYourAccountBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(253, 147, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(253, 211, 75, 23);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 204));
		passwordField.setBounds(368, 199, 189, 35);
		contentPane.add(passwordField);
		
		JButton catalogueBtn_1_1 = new JButton("Ajouter Livre");
		catalogueBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterLivre ajouterLivre = new AjouterLivre();
				ajouterLivre.setVisible(true);
			}
		});
		catalogueBtn_1_1.setForeground(Color.WHITE);
		catalogueBtn_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn_1_1.setBackground(new Color(153, 0, 255));
		catalogueBtn_1_1.setActionCommand("Login");
		catalogueBtn_1_1.setBounds(10, 279, 153, 42);
		contentPane.add(catalogueBtn_1_1);
	}
}
