package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

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
import beans.User;

import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Catalogue extends JFrame {

	private JPanel contentPane;
	private JTextField isbnField;
	private JTable table;

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
	public Catalogue() {
		

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
		panel.setBounds(0, 54, 674, 10);
		panel.setBackground(new Color(148, 0, 211));
		contentPane.add(panel);
		// comment
		JLabel lblNewLabel = new JLabel("Catalogue");
		lblNewLabel.setBounds(280, 11, 233, 32);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(240, 255, 255));
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(179, 64, 10, 276);
		panel_1.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_1);
		
		JButton registerBtn = new JButton("Inscription");
		registerBtn.setBounds(10, 75, 153, 42);
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
		contentPane.add(registerBtn);
		
		JButton catalogueBtn = new JButton("Emprunter");
		catalogueBtn.setBounds(10, 144, 153, 42);
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
		contentPane.add(catalogueBtn);
		
		JButton catalogueBtn_1 = new JButton("Catalogue");
		catalogueBtn_1.setBounds(10, 211, 153, 42);
		catalogueBtn_1.setForeground(Color.WHITE);
		catalogueBtn_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		catalogueBtn_1.setBackground(new Color(153, 0, 255));
		catalogueBtn_1.setActionCommand("Login");
		contentPane.add(catalogueBtn_1);
		
		JLabel lblVerfierLexistanceDe = new JLabel("listes des livres");
		lblVerfierLexistanceDe.setBounds(360, 58, 153, 32);
		lblVerfierLexistanceDe.setForeground(new Color(240, 255, 255));
		lblVerfierLexistanceDe.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		contentPane.add(lblVerfierLexistanceDe);
		
		isbnField = new JTextField();
		isbnField.setBounds(412, 91, 113, 26);
		isbnField.setBackground(new Color(255, 255, 204));
		contentPane.add(isbnField);
		isbnField.setColumns(10);
		
		JButton chercherBtn = new JButton("Chercher");
		chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isbn =Integer.valueOf(isbnField.getText());
				 try {
					IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					 Livre u= (Livre)stub.findBookById(isbn);
					 if (u == null) {
						 JOptionPane.showMessageDialog(null,
								    "Book Not Found !! ",
								    "Warnning",
								    JOptionPane.WARNING_MESSAGE);

					}
					 JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBackground(new Color(148, 0, 211));
						scrollPane.setBounds(189, 128, 485, 222);
						contentPane.add(scrollPane);
						
						String[] columnNames = {"ISBN",
				                "Titre",
				                "Autteur",
				                "Editeur",
				                "Delete"};
						
						Object[][] data = {
							    {u.getIsbn(),u.getTitle(),u.getAuteur(), u.getEditeur(),"delete"},
							   
							};
						table = new JTable(data, columnNames);
						table.setBackground(new Color(148, 0, 211));
						scrollPane.setViewportView(table);
						scrollPane.setBackground(new Color(148, 0, 211));
						
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				
			}
		});
		chercherBtn.setBounds(535, 89, 89, 28);
		chercherBtn.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		chercherBtn.setBackground(new Color(153, 51, 255));
		chercherBtn.setForeground(new Color(255, 255, 255));
		contentPane.add(chercherBtn);
		
		JLabel lblCin = new JLabel("Chercher | auteur | editeur | emprunteur");
		lblCin.setBounds(189, 88, 213, 32);
		lblCin.setForeground(new Color(240, 255, 255));
		lblCin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblCin);
		
		JButton catalogueBtn_1_1 = new JButton("Ajouter Livre");
		catalogueBtn_1_1.setBounds(10, 275, 153, 42);
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
		contentPane.add(catalogueBtn_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 128, 485, 222);
		contentPane.add(scrollPane);
		
		
		
	
		
	
		
		
		
	}
}
