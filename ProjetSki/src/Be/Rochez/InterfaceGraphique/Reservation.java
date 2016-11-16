package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.Moniteur;
import Be.Rochez.DAO.AccreditationDAO;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.MoniteurDAO;
import Be.Rochez.Singleton.ListeCours;
import Be.Rochez.Singleton.ListeHoraire;
import Be.Rochez.Singleton.ListeSemaine;
import Be.Rochez.Singleton.ListeTypeCours;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Reservation extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private ButtonGroup bg;
	private JButton button;
	private JRadioButton rbOui;
	private JRadioButton rbNon;
	private int monIdClient;
	private JTextField txtDateNaissance;
	private JComboBox comboBoxCours;
	private JComboBox comboBoxMoniteur;
	private MoniteurDAO m;
	
	public Reservation(int id) {
		monIdClient = id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblRservation = new JLabel("R\u00E9servation");
		lblRservation.setForeground(Color.WHITE);
		lblRservation.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		
		button = new JButton("Retour");
		
		JButton btnSuivant = new JButton("Suivant");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRservation)
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSuivant)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRservation)
						.addComponent(button)
						.addComponent(btnSuivant))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, 0, 0, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
		);
		
		JLabel lblInformationCours = new JLabel("Informations Cours");
		lblInformationCours.setForeground(Color.WHITE);
		lblInformationCours.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		JLabel lblCours = new JLabel("Cours :");
		lblCours.setForeground(Color.WHITE);
		lblCours.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		comboBoxCours = new JComboBox();
		comboBoxCours.setBackground(Color.WHITE);
		comboBoxCours.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		
		JLabel lblHoraire = new JLabel("Horaire :");
		lblHoraire.setForeground(Color.WHITE);
		lblHoraire.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		JComboBox comboBoxHoraire = new JComboBox();
		comboBoxHoraire.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		
		JLabel lblSemaine = new JLabel("Semaine :");
		lblSemaine.setBackground(Color.WHITE);
		lblSemaine.setForeground(Color.WHITE);
		lblSemaine.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		JComboBox comboBoxSemaine = new JComboBox();
		comboBoxSemaine.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		
		JLabel lblMoniteur = new JLabel("Moniteur :");
		lblMoniteur.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lblMoniteur.setForeground(Color.WHITE);
		
		comboBoxMoniteur = new JComboBox();
		comboBoxMoniteur.setEnabled(false);
		comboBoxMoniteur.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(105)
							.addComponent(lblInformationCours))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBoxHoraire, 0, 301, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHoraire))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBoxMoniteur, 0, 301, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMoniteur))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBoxCours, 0, 301, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCours))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSemaine))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBoxSemaine, 0, 301, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblInformationCours)
					.addGap(33)
					.addComponent(lblCours)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxCours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMoniteur)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxMoniteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHoraire)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxHoraire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSemaine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxSemaine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblInformationElve = new JLabel("Informations El\u00E8ve");
		lblInformationElve.setForeground(Color.WHITE);
		lblInformationElve.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		
		JLabel lblAssurance = new JLabel("Assurances :");
		lblAssurance.setForeground(Color.WHITE);
		lblAssurance.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		rbOui = new JRadioButton("Oui");
		rbOui.setSelected(true);
		rbOui.setForeground(Color.WHITE);
		rbOui.setBackground(Color.DARK_GRAY);
		rbOui.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		
		rbNon = new JRadioButton("Non");
		rbNon.setForeground(Color.WHITE);
		rbNon.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		rbNon.setBackground(Color.DARK_GRAY);
		
		JLabel lblDateNaissance = new JLabel("Date De Naissance :");
		lblDateNaissance.setForeground(Color.WHITE);
		lblDateNaissance.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(69)
							.addComponent(lblInformationElve))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNom))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNom, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPrenom))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtPrenom, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDateNaissance))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDateNaissance, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAssurance))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(rbOui))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(rbNon)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblInformationElve)
					.addGap(39)
					.addComponent(lblNom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrenom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDateNaissance)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAssurance)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rbOui)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rbNon)
					.addGap(26))
		);
		
		bg = new ButtonGroup();
		bg.add(rbOui);
		bg.add(rbNon);
		
		
		
		//Remplir ComboBox Cours
		ListeCours listeCours = ListeCours.Instance();
		comboBoxCours.addItem("");
		for(int i = 0 ; i < listeCours.getListeCours().size(); i++)
		{
			comboBoxCours.addItem(listeCours.getListeCours().get(i).toString());
		}
		//Remplissage de la ComboBox Semaine
		ListeSemaine listeSemaine = ListeSemaine.Instance();
		comboBoxSemaine.addItem("");
		for(int i = 0 ; i < listeSemaine.getListeSemaine().size(); i++)
		{
			comboBoxSemaine.addItem(listeSemaine.getListeSemaine().get(i).toString());
		}
		//Remplissage ComboBox Horaire
		ListeHoraire listeHoraire = ListeHoraire.Instance();
		comboBoxHoraire.addItem("");
		for(int i = 0 ; i < listeHoraire.getListeHoraire().size(); i++)
		{
			comboBoxHoraire.addItem(listeHoraire.getListeHoraire().get(i).toString());
		}
		comboBoxCours.addActionListener(this);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == comboBoxCours)
		{
			if(comboBoxCours.getSelectedIndex() > 0)
			{
				comboBoxMoniteur.removeAllItems();
				m = new MoniteurDAO(ConnexionDAO.getInstance());
				ArrayList<Moniteur> monTableauDeMoniteur = m.MoniteurAccredite(comboBoxCours.getSelectedIndex());
				
				comboBoxMoniteur.addItem("");
				if(monTableauDeMoniteur != null)
				{
					
					for(int i = 0; i < monTableauDeMoniteur.size(); i++)
					{
						comboBoxMoniteur.addItem(monTableauDeMoniteur.get(i).toString());
						comboBoxMoniteur.setEnabled(true);
					}
				}
				else
				{
					comboBoxMoniteur.setSelectedIndex(0);
					comboBoxMoniteur.setEnabled(false);
				}
			}
			else
			{
				comboBoxMoniteur.setSelectedIndex(0);
				comboBoxMoniteur.setEnabled(false);
			}
		}
	}
}