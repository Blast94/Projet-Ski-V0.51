package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.DAO.ClientDAO;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.MoniteurDAO;

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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Accueil extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JButton btnConnexion;
	private JButton btnInscription;
	private JRadioButton rbClient;
	private JRadioButton rbMoniteur;
	private ButtonGroup bg;
	private JButton btnQuitter;
	JLabel lblErreur;
	
	private ClientDAO c;
	private MoniteurDAO m;

	/**
	 * Create the frame.
	 */
	public Accueil() {
		this.setTitle("Accueil");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPseudo.setForeground(Color.WHITE);
		lblPseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtLogin = new JTextField();
		lblPseudo.setLabelFor(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setLabelFor(txtPassword);
		txtPassword.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		
		btnConnexion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel = new JLabel("            Bienvenue au Domaine du Chalet 260m");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(707, Short.MAX_VALUE)
					.addComponent(btnQuitter)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(112)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnQuitter)
					.addContainerGap())
		);
		
		rbClient = new JRadioButton("Client");
		rbClient.setSelected(true);
		rbClient.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		rbClient.setForeground(Color.WHITE);
		rbClient.setBackground(Color.DARK_GRAY);
		
		rbMoniteur = new JRadioButton("Moniteur");
		rbMoniteur.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		rbMoniteur.setBackground(Color.DARK_GRAY);
		rbMoniteur.setForeground(Color.WHITE);
		
		bg = new ButtonGroup();
		bg.add(rbClient);
		bg.add(rbMoniteur);
		
		btnInscription = new JButton("Inscription");
		
		btnInscription.addActionListener(this);
		
		lblErreur = new JLabel("");
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setForeground(Color.ORANGE);
		lblErreur.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnInscription)
							.addPreferredGap(ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
							.addComponent(lblPseudo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblErreur, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rbClient)
						.addComponent(rbMoniteur))
					.addGap(18)
					.addComponent(btnConnexion)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rbClient)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rbMoniteur))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPseudo)
								.addComponent(lblPassword)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInscription))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblErreur))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnConnexion)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
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
			//Si on veut se connecter en tant que client
			if(rbClient.isSelected())
			{
				c = new ClientDAO(ConnexionDAO.getInstance());
				int monIdClient = c.ConnexionClient(txtLogin.getText().trim(), txtPassword.getText()); 
				if(monIdClient == -1)
				{
					lblErreur.setText("Mot de passe incorrecte !");
				}
				else if(monIdClient == -2)
				{
					lblErreur.setText("Le login n'existe pas !");
				}
				else if(monIdClient == -3)
				{
					lblErreur.setText("Erreur lors de la tentative de connexion !");
				}
				else
				{
					this.dispose();
					MenuClient fen = new MenuClient(monIdClient);
				}
			}
			//Si on veut se connecter en tant que moniteur
			else if(rbMoniteur.isSelected())
			{
				m = new MoniteurDAO(ConnexionDAO.getInstance());
				int monIdMoniteur = m.ConnexionMoniteur(txtLogin.getText().trim(), txtPassword.getText()); 
				if(monIdMoniteur == -1)
				{
					lblErreur.setText("Mot de passe incorrecte !");
				}
				else if(monIdMoniteur == -2)
				{
					lblErreur.setText("Le login n'exite pas !");
				}
				else if(monIdMoniteur == -3)
				{
					lblErreur.setText("Erreur lors de la connexion !");
				}
				else
				{
					this.dispose();
					MenuMoniteur fen = new MenuMoniteur(monIdMoniteur);
				}
			}
		}
		if(arg0.getSource() == btnQuitter)
		{
			this.dispose();
		}
	} 
}
