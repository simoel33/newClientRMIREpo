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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField cinField;
	private JTable table;
	private String cin;
	private User u ;
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
	
	 public void setUser(User user) {
	    	
	    	this.u = new User("", "", "", "");
	    	
	    }
	 
	public AdminPanel() {
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
		JLabel lblNewLabel = new JLabel("Bienvenue Admin");
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
		
		JLabel lblVerfierLexistanceDe = new JLabel("Verfier l'existance de l'usager");
		lblVerfierLexistanceDe.setForeground(new Color(240, 255, 255));
		lblVerfierLexistanceDe.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblVerfierLexistanceDe.setBounds(343, 57, 153, 32);
		contentPane.add(lblVerfierLexistanceDe);
		
		cinField = new JTextField();
		cinField.setBackground(new Color(255, 255, 204));
		cinField.setBounds(351, 88, 113, 26);
		contentPane.add(cinField);
		cinField.setColumns(10);
		
		JButton btnNewButton = new JButton("Verefier");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cin = cinField.getText();
				  
				try {
					IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					  u= (User)stub.findUserById(cin);
					 if (u == null) {
						 
						 JOptionPane.showMessageDialog(null,
								    "User Not Found !! or Cin Not Exist.",
								    "Warnning",
								    JOptionPane.WARNING_MESSAGE);

					}
					 JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBackground(new Color(148, 0, 211));
						scrollPane.setBounds(189, 128, 485, 222);
						contentPane.add(scrollPane);
						
					 String[] columnNames = {"ID",
				                "Categorie",
				                "Nom Complet",
				                "Adress",
				                "Supprimer",
				                };
						
						Object[][] data = {
							    {u.getId(),u.getCategory(), u.getName(), u.getAdress(),"delete"},
							   
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
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(153, 51, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(474, 87, 89, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblCin = new JLabel("CIN:");
		lblCin.setForeground(new Color(240, 255, 255));
		lblCin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCin.setBounds(303, 85, 30, 32);
		contentPane.add(lblCin);
		
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
		catalogueBtn_1_1.setBounds(10, 275, 153, 42);
		contentPane.add(catalogueBtn_1_1);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete User
				try {
					IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					stub.deleteUser(cin);
					setUser(u);
					
					 JOptionPane.showMessageDialog(null,
							    "User Deleted successfully",
							    "Success",
							    JOptionPane.OK_OPTION);
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		deleteBtn.setBackground(new Color(153, 51, 255));
		deleteBtn.setBounds(573, 86, 89, 28);
		contentPane.add(deleteBtn);
		
		
		
		
	}
}
