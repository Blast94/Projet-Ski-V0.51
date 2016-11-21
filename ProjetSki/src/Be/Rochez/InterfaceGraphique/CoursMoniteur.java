package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.PanierC;
import Be.Rochez.Classes.ReservationC;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.ReservationDAO;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class CoursMoniteur extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ReservationDAO reservationDAO;
	private JButton btnRetour;
	private int monIdMoniteur;
	/**
	 * Create the frame.
	 */
	public CoursMoniteur(int id) {
		
		monIdMoniteur = id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblMesCours = new JLabel("Mes cours");
		lblMesCours.setForeground(Color.WHITE);
		lblMesCours.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMesCours)
					.addPreferredGap(ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
					.addComponent(btnRetour)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMesCours)
						.addComponent(btnRetour))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		DefaultListModel dlm = new DefaultListModel();
		//Remplissage de la liste
		reservationDAO= new ReservationDAO(ConnexionDAO.getInstance());
		ArrayList<ReservationC> mesCoursValides = reservationDAO.CoursValidesMoniteur(monIdMoniteur);
		for(int i =0; i < mesCoursValides.size(); i++)
		{
			dlm.addElement("Du " + mesCoursValides.get(i).GetSemaine().GetDateDebut().getDayOfMonth() + "/" + mesCoursValides.get(i).GetSemaine().GetDateDebut().getMonthValue() + "/" + mesCoursValides.get(i).GetSemaine().GetDateDebut().getYear() 
					+ " Au " + mesCoursValides.get(i).GetSemaine().GetDateFin().getDayOfMonth() + "/" +  mesCoursValides.get(i).GetSemaine().GetDateFin().getMonthValue() + "/" +  mesCoursValides.get(i).GetSemaine().GetDateFin().getYear() 
					+ " - " + mesCoursValides.get(i).GetHoraire().GetHeureDebut() + " � " + mesCoursValides.get(i).GetHoraire().GetHeureFin()
					+ " - " + mesCoursValides.get(i).GetCours().GetSport() + " " + mesCoursValides.get(i).GetCours().GetNiveau() + " " 
					+ mesCoursValides.get(i).GetCours().GetCategorieAge() + "(" + mesCoursValides.get(i).GetHoraire().GetTypeCours().GetDenomination() + ")");
		}
		list.setModel(dlm);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnRetour)
		{
			this.dispose();
			MenuMoniteur fen = new MenuMoniteur(monIdMoniteur);
		}
	}
}
