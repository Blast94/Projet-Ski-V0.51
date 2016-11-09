package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JButton btnValider;
	private JButton btnRetour;
	private JPasswordField passwordField;

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
		lblPrenom.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
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
		
		btnValider = new JButton("Valider");
		
		btnRetour = new JButton("Retour");
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("(JJ/MM/AAAA)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1))
								.addComponent(lblPrenom)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPseudo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCompteBancaire, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCompteBancaire)
								.addComponent(txtDateNaissance)
								.addComponent(txtPrenom)
								.addComponent(txtNom)
								.addComponent(passwordField)
								.addComponent(txtPseudo, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
							.addGap(64))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(252)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(btnRetour)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnValider)
							.addGap(73)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPseudo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPseudo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCompteBancaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCompteBancaire, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValider)
						.addComponent(btnRetour))
					.addGap(47))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnRetour.addActionListener(this);
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
			
		}
	} 
}