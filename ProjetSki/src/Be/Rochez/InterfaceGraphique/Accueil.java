package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.DAO.ClientDAO;
import Be.Rochez.DAO.ConnexionDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class Accueil extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JButton btnConnexion;
	private JButton btnInscription;
	
	private ClientDAO c;

	/**
	 * Create the frame.
	 */
	public Accueil() {
		this.setTitle("Accueil");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 400);
		this.getContentPane().setLayout(null);
		
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		this.contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPseudo.setForeground(Color.WHITE);
		lblPseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblPseudo);
		
		txtLogin = new JTextField();
		lblPseudo.setLabelFor(txtLogin);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setLabelFor(txtPassword);
		txtPassword.setColumns(10);
		panel.add(txtPassword);
		
		btnConnexion = new JButton("Connexion");
		
		btnConnexion.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnConnexion);
		
		btnInscription = new JButton("Inscription");
		
		panel.add(btnInscription);
		
		JLabel lblNewLabel = new JLabel("            Bienvenue au Domaine du Chalet 260m");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		this.contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		btnInscription.addActionListener(this);
		btnConnexion.addActionListener(this);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnInscription)
		{
			this.dispose();
	        InscriptionClient fen = new InscriptionClient();
		}
		if(arg0.getSource() == btnConnexion)
		{
			c = new ClientDAO(ConnexionDAO.getInstance());
			int monIdClient = c.ConnexionClient(txtLogin.getText().trim(), txtPassword.getText()); 
			if(monIdClient == -1)
			{
				System.out.println("Le mot de passe saisi est incorrect");
			}
			else if(monIdClient == -2)
			{
				System.out.println("Le login n'existe pas");
			}
			else if(monIdClient == -3)
			{
				System.out.println("Erreur lors de la connexion");
			}
			else
			{
				this.dispose();
				MenuClient fen = new MenuClient(monIdClient);
			}
			
		}
	} 

}
