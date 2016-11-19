package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.Cours;
import Be.Rochez.Classes.PanierC;
import Be.Rochez.Classes.ReservationC;
import Be.Rochez.DAO.AccreditationDAO;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.ReservationDAO;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Panier extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSupprimer;
	private JButton btnPayer;
	private JButton btnAnnuler;
	private JButton btnAutreReservation;
	private int monIdClient;
	private JList list;
	private PanierC monPanierReservation;
	private int prixTotal = 0;
	ReservationDAO reservationDAO;
	/**
	 * Create the frame.
	 */
	public Panier(int id) {
		
		monIdClient = id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblPanier = new JLabel("Panier");
		lblPanier.setForeground(Color.WHITE);
		lblPanier.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		
		btnAnnuler = new JButton("Annuler");
		
		btnAutreReservation = new JButton("Nouvelle R\u00E9servation");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPanier)
					.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
					.addComponent(btnAnnuler)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAutreReservation)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPanier)
						.addComponent(btnAutreReservation)
						.addComponent(btnAnnuler))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnSupprimer = new JButton("Supprimer");
		
		btnPayer = new JButton("Payer");
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblTotal.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(482)
							.addComponent(btnSupprimer))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(394)
									.addComponent(btnPayer)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(lblTotal)))
							.addGap(22)))
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(btnSupprimer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPayer)
						.addComponent(lblTotal))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		
		//Remplissage de la liste
		reservationDAO= new ReservationDAO(ConnexionDAO.getInstance());
		monPanierReservation = new PanierC();
		monPanierReservation.SetMonPanier(reservationDAO.RecuperationReservationPanier(monIdClient));
		
		DefaultListModel dlm = new DefaultListModel();
		for(int i = 0; i < monPanierReservation.GetMonPanier().size(); i++)
		{
			//Modification des condition du prix du cours si c'est un cours particulier qui est s�lectionn�
			if(monPanierReservation.GetMonPanier().get(i).GetCours().GetTypeCours().GetDenomination().equals("Particulier"))
			{
				monPanierReservation.GetMonPanier().get(i).GetCours().SetPrix(monPanierReservation.GetMonPanier().get(i).GetHoraire().GetPrixParticulier());
			} 
			//Ajout du prix de l'assurance au prix du cours si celle ci a �t� choisie
			if(monPanierReservation.GetMonPanier().get(i).GetEleve().GetAssurance() == 1)
			{
				monPanierReservation.GetMonPanier().get(i).GetCours().SetPrix((monPanierReservation.GetMonPanier().get(i).GetCours().GetPrix()) + 15);
			}
			prixTotal += monPanierReservation.GetMonPanier().get(i).GetCours().GetPrix();
			dlm.addElement(monPanierReservation.GetMonPanier().get(i).toString());
		}
		list.setModel(dlm);
		
		lblTotal.setText("Total :    � " + prixTotal );
		btnAnnuler.addActionListener(this);
		btnAutreReservation.addActionListener(this);
		btnPayer.addActionListener(this);
		btnSupprimer.addActionListener(this);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()  == btnAnnuler)
		{
			this.dispose();
			MenuClient fen = new MenuClient(monIdClient);
		}
		if(arg0.getSource() == btnAutreReservation)
		{
			this.dispose();
			Reservation fen = new Reservation(monIdClient);
		}
		if(arg0.getSource() == btnSupprimer)
		{
			if(list.getSelectedIndex() != -1)
			{
				reservationDAO = new ReservationDAO(ConnexionDAO.getInstance());
				String[] s = list.getSelectedValue().toString().split(" - ");
				reservationDAO.delete(Integer.parseInt(s[0]));
				this.dispose();
				Panier fen = new Panier(monIdClient);
			}
		}
		if(arg0.getSource() == btnPayer)
		{
			reservationDAO = new ReservationDAO(ConnexionDAO.getInstance());
			for(int i = 0; i < monPanierReservation.GetMonPanier().size(); i++)
			{
				reservationDAO.update(monPanierReservation.GetMonPanier().get(i));
				this.dispose();
				MenuClient fen = new MenuClient(monIdClient);
			}
		}
	}
}
