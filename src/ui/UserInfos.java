package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.IBiblio;
import beans.User;

import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class UserInfos extends JFrame {

	private JPanel contentPane;
	private JTextField cinField;
	private JTextField nomField;

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
	public UserInfos() {
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
		JLabel lblNewLabel = new JLabel("Ajouter Un Usager");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBounds(214, 11, 410, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		panel_1.setBounds(179, 64, 10, 276);
		contentPane.add(panel_1);
		
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
		registerBtn.setBounds(10, 75, 153, 42);
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
		catalogueBtn.setBounds(10, 144, 153, 42);
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
		catalogueBtn_1.setBounds(10, 211, 153, 42);
		contentPane.add(catalogueBtn_1);
		
		JLabel lblVerfierLexistanceDe = new JLabel("Ajouter un Nouveau Usager");
		lblVerfierLexistanceDe.setForeground(new Color(240, 255, 255));
		lblVerfierLexistanceDe.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblVerfierLexistanceDe.setBounds(343, 57, 153, 32);
		contentPane.add(lblVerfierLexistanceDe);
		
		JLabel lblCin = new JLabel("CIN:");
		lblCin.setForeground(new Color(240, 255, 255));
		lblCin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCin.setBounds(235, 96, 30, 32);
		contentPane.add(lblCin);
		
		cinField = new JTextField();
		cinField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cinField.setBackground(new Color(255, 255, 204));
		cinField.setForeground(new Color(0, 0, 0));
		cinField.setBounds(353, 96, 159, 32);
		contentPane.add(cinField);
		cinField.setColumns(10);
		
		nomField = new JTextField();
		nomField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nomField.setBackground(new Color(255, 255, 204));
		nomField.setForeground(new Color(0, 0, 0));
		nomField.setColumns(10);
		nomField.setBounds(353, 152, 159, 32);
		contentPane.add(nomField);
		
		JLabel lblNomComplet = new JLabel("Nom Complet");
		lblNomComplet.setForeground(new Color(240, 255, 255));
		lblNomComplet.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomComplet.setBounds(235, 150, 86, 32);
		contentPane.add(lblNomComplet);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setForeground(new Color(240, 255, 255));
		lblCategorie.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCategorie.setBounds(235, 211, 86, 32);
		contentPane.add(lblCategorie);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(153, 51, 255));
		comboBox.setBackground(new Color(255, 255, 204));
		comboBox.setBounds(353, 211, 159, 33);
		comboBox.addItem("----------");
		comboBox.addItem("Etudiant");
		comboBox.addItem("Professeur");
		contentPane.add(comboBox);
		
		JButton addBtn = new JButton("Ajouter");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cin = cinField.getText();
				String nom = nomField.getText();
				String categorie = (String)comboBox.getSelectedItem();
				String address = "Streat " + Math.random()*101+1;
				User user = new User(cin, nom, categorie, address);
				
				 try {
					IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					stub.inserUser(user);
					
					 JOptionPane.showMessageDialog(null,
							    "Livre Add successfully",
							    "Success",
							    JOptionPane.WARNING_MESSAGE);
					 // empty Field
					 cin="";
					 nom = "";
					 categorie="";
				} catch (Exception e1) {

					e1.printStackTrace();
				} 
				
			}
		});
		addBtn.setBackground(new Color(153, 51, 255));
		addBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBounds(353, 261, 159, 32);
		contentPane.add(addBtn);
		
	
		
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
		catalogueBtn_1_1.setBounds(10, 280, 153, 42);
		contentPane.add(catalogueBtn_1_1);
	}
}
