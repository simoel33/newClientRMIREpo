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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import app.IBiblio;
import beans.Livre;
import beans.User;

public class EmprunterLivre extends JFrame {

	private JPanel contentPane;
	private JTextField cinField;

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
	public EmprunterLivre() {
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
		JLabel lblNewLabel = new JLabel("Emprunter Un Livre");
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
		
		JLabel lblVerfierLexistanceDe = new JLabel("Emprunter un Livre");
		lblVerfierLexistanceDe.setForeground(new Color(240, 255, 255));
		lblVerfierLexistanceDe.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblVerfierLexistanceDe.setBounds(343, 57, 153, 32);
		contentPane.add(lblVerfierLexistanceDe);
		
		JLabel lblCin = new JLabel("CIN:");
		lblCin.setForeground(new Color(240, 255, 255));
		lblCin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCin.setBounds(199, 118, 30, 32);
		contentPane.add(lblCin);
		
		cinField = new JTextField();
		cinField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cinField.setBackground(new Color(255, 255, 204));
		cinField.setForeground(new Color(0, 0, 0));
		cinField.setBounds(214, 161, 134, 32);
		contentPane.add(cinField);
		cinField.setColumns(10);
		
		JLabel lblNomComplet = new JLabel("Livre");
		lblNomComplet.setForeground(new Color(240, 255, 255));
		lblNomComplet.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomComplet.setBounds(377, 118, 86, 32);
		contentPane.add(lblNomComplet);
		
		JComboBox LivreOption = new JComboBox();
		LivreOption.setForeground(new Color(153, 51, 255));
		LivreOption.setBackground(new Color(255, 255, 204));
		LivreOption.setBounds(377, 161, 134, 33);
		LivreOption.addItem("----------");
		
		// list of livres
		try {
			IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
			List<Livre> listLivre =  stub.getBooks();
			for (Livre livre : listLivre) {
				LivreOption.addItem(livre.getIsbn());
			
				System.out.println(livre.getTitle());
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane.add(LivreOption);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(240, 255, 255));
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDate.setBounds(554, 122, 30, 25);
		contentPane.add(lblDate);
		
		JDateChooser dateRetourField = new JDateChooser();
		dateRetourField.setBounds(554, 161, 110, 32);
		dateRetourField.setForeground(new Color(153, 51, 255));
		contentPane.add(dateRetourField);
		
		JButton emprunterBtn = new JButton("Emprunter");
		emprunterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String cin = cinField.getText();
			int livre = (int)LivreOption.getSelectedItem();
			Date date = dateRetourField.getMaxSelectableDate();
			String dt = date.getYear()+"-"+date.getMonth()+"-"+date.getDay();
			
			try {
				IBiblio stub  = (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
					
					  User userSearch = stub.findUserById(cin); Livre livreToSearch =
					  stub.findBookById(livre);
					  
					  if(userSearch != null && livreToSearch!=null) {
					  userSearch.setId(cin); 
					  livreToSearch.setIsbn(livre);
					  stub.Emprunter(livreToSearch, userSearch,"2022-01-15");
					  //
					  JOptionPane.showMessageDialog(null, "Livre Add successfully", "Success",
					  JOptionPane.OK_OPTION); 
					  }else {
						  JOptionPane.showMessageDialog(null, "Eroor in the process", "Warnning",
								  JOptionPane.WARNING_MESSAGE); 
					  }
					 
			
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		emprunterBtn.setBackground(new Color(153, 51, 255));
		emprunterBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		emprunterBtn.setForeground(new Color(255, 255, 255));
		emprunterBtn.setBounds(306, 222, 291, 31);
		contentPane.add(emprunterBtn);
		
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
