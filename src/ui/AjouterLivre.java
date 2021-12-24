package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.IBiblio;
import beans.Livre;

import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AjouterLivre extends JFrame {

	private JPanel contentPane;
	private JTextField isbnField;
	private JTextField titreField;
	private JTextField editeurField;
	private JTextField auteurField;

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
	public AjouterLivre() {
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
		JLabel lblNewLabel = new JLabel("Ajouter Un Livre");
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
		
		JLabel lblVerfierLexistanceDe = new JLabel("Ajouter un Nouveau Livre");
		lblVerfierLexistanceDe.setForeground(new Color(240, 255, 255));
		lblVerfierLexistanceDe.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblVerfierLexistanceDe.setBounds(343, 57, 153, 32);
		contentPane.add(lblVerfierLexistanceDe);
		
		JLabel lblCin = new JLabel("ISBN");
		lblCin.setForeground(new Color(240, 255, 255));
		lblCin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCin.setBounds(235, 96, 55, 32);
		contentPane.add(lblCin);
		
		isbnField = new JTextField();
		isbnField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		isbnField.setBackground(new Color(255, 255, 204));
		isbnField.setForeground(new Color(0, 0, 0));
		isbnField.setBounds(353, 96, 159, 32);
		contentPane.add(isbnField);
		isbnField.setColumns(10);
		
		titreField = new JTextField();
		titreField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		titreField.setBackground(new Color(255, 255, 204));
		titreField.setForeground(new Color(0, 0, 0));
		titreField.setColumns(10);
		titreField.setBounds(353, 150, 159, 32);
		contentPane.add(titreField);
		
		JLabel lblCategorie = new JLabel("Editeur");
		lblCategorie.setForeground(new Color(240, 255, 255));
		lblCategorie.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCategorie.setBounds(235, 197, 86, 32);
		contentPane.add(lblCategorie);
		
	
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setForeground(new Color(240, 255, 255));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTitre.setBounds(235, 154, 55, 32);
		contentPane.add(lblTitre);
		
		editeurField = new JTextField();
		editeurField.setForeground(Color.BLACK);
		editeurField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		editeurField.setColumns(10);
		editeurField.setBackground(new Color(255, 255, 204));
		editeurField.setBounds(353, 196, 159, 34);
		contentPane.add(editeurField);
		
		auteurField = new JTextField();
		auteurField.setForeground(Color.BLACK);
		auteurField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		auteurField.setColumns(10);
		auteurField.setBackground(new Color(255, 255, 204));
		auteurField.setBounds(353, 253, 159, 32);
		contentPane.add(auteurField);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setForeground(new Color(240, 255, 255));
		lblAuteur.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAuteur.setBounds(235, 253, 86, 32);
		contentPane.add(lblAuteur);
		
		JButton catalogueBtn_1_1 = new JButton("Ajouter Livre");
		catalogueBtn_1_1.setForeground(Color.WHITE);
		catalogueBtn_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn_1_1.setBackground(new Color(153, 0, 255));
		catalogueBtn_1_1.setActionCommand("Login");
		catalogueBtn_1_1.setBounds(10, 275, 153, 42);
		contentPane.add(catalogueBtn_1_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int isbn = Integer.valueOf(isbnField.getText());
				 String title = titreField.getText();
				 String auteur = auteurField.getText();
				 String editeur =  editeurField.getText();
				 System.out.println(isbn);
				 System.out.println(title);
				 System.out.println(auteur);
				 System.out.println(editeur);

				 
				 try {
					 IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					 Livre livre = new Livre(isbn, title, auteur, editeur);
					 stub.AddBook(livre);
					 
					 
					 JOptionPane.showMessageDialog(null,
							    "Livre Add successfully",
							    "Success",
							    JOptionPane.WARNING_MESSAGE);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBackground(new Color(153, 51, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(353, 296, 159, 32);
		contentPane.add(btnNewButton);
	}
}
