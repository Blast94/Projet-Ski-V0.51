package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.Client;
import Be.Rochez.Classes.Moniteur;
import Be.Rochez.Classes.Verification;
import Be.Rochez.DAO.ClientDAO;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.MoniteurDAO;
import Be.Rochez.DAO.PersonneDAO;

public class ModifProfilMoniteur extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblPassword;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblDateNaissance;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateNaissance;
	private JPasswordField passwordField;
	private JLabel lblErreur;
	private JButton btnValider;
	private JButton btnRetour;
	
	private Moniteur monMoniteur;
	private MoniteurDAO moniteurDAO;
	private int monIdMoniteur;
	/**
	 * Create the frame.
	 */
	public ModifProfilMoniteur(int id) {
		monIdMoniteur = id;
		
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
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(JJ/MM/AAAA)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		lblErreur = new JLabel("");
		lblErreur.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setForeground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("Modification du Profil");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		btnRetour = new JButton("Retour");
		
		btnValider = new JButton("Valider");
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
					.addGap(0)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrenom)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1))
								.addComponent(lblPseudo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtNom, Alignment.LEADING, 229, 229, 229)
										.addComponent(passwordField, Alignment.LEADING, 229, 229, 229)
										.addComponent(txtPseudo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
									.addGap(190))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtPrenom, Alignment.LEADING)
									.addComponent(txtDateNaissance, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addComponent(lblErreur, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblErreur)
					.addGap(55)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(92))
		);
		contentPane.setLayout(gl_contentPane);
		
		//remplissage avec les informations connues du moniteur
		moniteurDAO = new MoniteurDAO(ConnexionDAO.getInstance());
		monMoniteur = moniteurDAO.TrouverMoniteur(monIdMoniteur);
		try
		{
			txtNom.setText(monMoniteur.GetNom());
			txtPrenom.setText(monMoniteur.GetPrenom());
			txtDateNaissance.setText(monMoniteur.GetDateNaissance());
			txtPseudo.setText(monMoniteur.GetLogin());
		}
		catch(Exception e)
		{
		}
		btnRetour.addActionListener(this);
		btnValider.addActionListener(this);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnRetour)
		{
			this.dispose();
	        MenuMoniteur fen = new MenuMoniteur(monIdMoniteur);
		}
		if(arg0.getSource() == btnValider)
		{
			moniteurDAO = new MoniteurDAO(ConnexionDAO.getInstance());
			//test champs vide
			if(!txtNom.getText().equals("") && !txtPrenom.getText().equals("") && !txtDateNaissance.getText().equals("") && !txtPseudo.getText().equals("") && !passwordField.getText().equals(""))
			{
				//test nom correct
				if(!Verification.IsString(txtNom.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie du nom !");
				}
				//test prenom correct
				else if(!Verification.IsString(txtPrenom.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie du prenom !");
				}
				//test date de naissance correct
				else if(!Verification.IsDate(txtDateNaissance.getText().trim()))
				{
					lblErreur.setText("Erreur dans la saisie de la date !");
				}
				else
				{
					moniteurDAO = new MoniteurDAO(ConnexionDAO.getInstance());
					monMoniteur = new Moniteur(monIdMoniteur, txtNom.getText().trim(), txtPrenom.getText().trim(), txtDateNaissance.getText(), txtPseudo.getText().trim(), passwordField.getText());
					moniteurDAO.update(monMoniteur);
					PersonneDAO personneDAO = new PersonneDAO(ConnexionDAO.getInstance());
					personneDAO.MAJDateNaissance();
					personneDAO.MAJCalculAge();
					this.dispose();
			        MenuMoniteur fen = new MenuMoniteur(monIdMoniteur);
				}
			}
			else
			{
				lblErreur.setText("Un ou plusieurs champs est vide. V�rifiez vos saisies !");
			}
		}
	} 
}
