package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.Client;
import Be.Rochez.Classes.Verification;
import Be.Rochez.DAO.ClientDAO;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.PersonneDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class InscriptionClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblPassword;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblDateNaissance;
	private JLabel lblCompteBancaire;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateNaissance;
	private JTextField txtCompteBancaire;
	private JPasswordField passwordField;
	private JLabel lblErreur;
	
	private Client monClient;
	private ClientDAO clientDAO;
	private JPanel panel;
	private JLabel label;
	private JButton btnRetour;
	private JButton btnValider;
	

	/**
	 * Create the frame.
	 */
	public InscriptionClient() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBounds(new Rectangle(50, 50, 600, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setForeground(Color.WHITE);
		lblPseudo.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		txtPseudo = new JTextField();
		txtPseudo.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		
		lblNom = new JLabel("Nom");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPrenom.setForeground(Color.WHITE);
		
		lblDateNaissance = new JLabel("Date de naissance");
		lblDateNaissance.setForeground(Color.WHITE);
		lblDateNaissance.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		lblCompteBancaire = new JLabel("Compte bancaire");
		lblCompteBancaire.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCompteBancaire.setForeground(Color.WHITE);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setColumns(10);
		
		txtCompteBancaire = new JTextField();
		txtCompteBancaire.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(JJ/MM/AAAA)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		lblErreur = new JLabel("");
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setForeground(Color.ORANGE);
		lblErreur.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		label = new JLabel("Modification du Profil");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);

		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 585, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
					.addComponent(btnRetour)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnValider)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(btnValider)
						.addComponent(btnRetour))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrenom)
								.addComponent(lblPseudo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1))
								.addComponent(lblCompteBancaire, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCompteBancaire)
								.addComponent(txtDateNaissance)
								.addComponent(txtPrenom, Alignment.TRAILING)
								.addComponent(txtNom)
								.addComponent(passwordField)
								.addComponent(txtPseudo, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(lblErreur, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(352, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErreur)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPseudo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPseudo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCompteBancaire, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCompteBancaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(158))
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnRetour)
		{
			this.dispose();
	        Accueil fen = new Accueil();
		}
		if(arg0.getSource() == btnValider)
		{
			clientDAO = new ClientDAO(ConnexionDAO.getInstance());
			//Test si les champs sont vides
			if(!txtNom.getText().equals("") && !txtPrenom.getText().equals("") && !txtDateNaissance.getText().equals("") && !txtPseudo.getText().equals("") && !passwordField.getText().equals("") && !txtCompteBancaire.getText().equals(""))
			{
				//test si le pseudo existe déja
				if(clientDAO.TestPseudo(txtPseudo.getText().trim()))
				{
					lblErreur.setText("Ce login existe déja. Choissisez en un autre !");
				}
				//test si le nom est bien composé de lettre
				else if(!Verification.IsString(txtNom.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie du nom !");
				}
				//test si le prenom est bien composé de lettre
				else if(!Verification.IsString(txtPrenom.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie du prenom !");
				}
				//test si la date de naissance a le bon format
				else if(!Verification.IsDate(txtDateNaissance.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie de la date !");
				}
				//test si le compte bancaire est bien composé de chiffre
				else if(!Verification.IsNumeric(txtCompteBancaire.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie du compte Bancaire !");
				}
				//si tout est correct
				else
				{
					monClient = new Client(txtNom.getText().trim(), txtPrenom.getText().trim(), txtDateNaissance.getText(), txtPseudo.getText().trim(), passwordField.getText(), Integer.parseInt(txtCompteBancaire.getText().trim()));
					clientDAO.create(monClient);
					PersonneDAO personneDAO = new PersonneDAO(ConnexionDAO.getInstance());
					personneDAO.MAJDateNaissance();
					personneDAO.MAJCalculAge();
					//Passage à l'acceuil
					this.dispose();
			        Accueil fen = new Accueil();
				}
			}
			else
			{
				lblErreur.setText("Un ou plusieurs champs est vide. Vérifiez vos saisies !");
			}
		}
	} 
}
