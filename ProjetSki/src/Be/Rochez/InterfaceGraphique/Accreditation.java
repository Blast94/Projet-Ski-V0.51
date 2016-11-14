package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.Classes.Cours;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.MoniteurDAO;
import Be.Rochez.Singleton.ListeCours;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class Accreditation extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int monIdMoniteur;
	private MoniteurDAO m;
	private JComboBox comboBox;
	private JButton btnValider;
	private JButton btnRetour;
	
	/**
	 * Create the frame.
	 */
	public Accreditation(int id) {
		
		monIdMoniteur = id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		
		JLabel lblAccrditation = new JLabel("Accr\u00E9ditation");
		lblAccrditation.setForeground(Color.WHITE);
		lblAccrditation.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		
		btnRetour = new JButton("Retour");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAccrditation)
					.addPreferredGap(ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
					.addComponent(btnRetour)
					.addGap(19))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccrditation)
						.addComponent(btnRetour))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		comboBox = new JComboBox();
		
		btnValider = new JButton("Valider");
		
		JList list = new JList();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, 413, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnValider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(1, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnValider))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
		);
		
		// Remplissage de la combobox des cours 
		ListeCours listeCours = ListeCours.Instance();
		comboBox.addItem("");
		for(int i = 0 ; i < listeCours.getListeCours().size(); i++)
		{
			comboBox.addItem(listeCours.getListeCours().get(i).toString());
		}
		btnValider.addActionListener(this);
		
		
		//Remplissage de la liste
		m = new MoniteurDAO(ConnexionDAO.getInstance());
		ArrayList<Cours> maListeAccreditation = new ArrayList<Cours>();
		System.out.println("avant Appel");
		maListeAccreditation = m.AccreditationProf(monIdMoniteur);
		System.out.println("Apr�s Appel");
		DefaultListModel dlm = new DefaultListModel();
		for(int i = 0; i < maListeAccreditation.size(); i++)
		{
			dlm.addElement(maListeAccreditation.get(i).GetSport() + "  -  " + maListeAccreditation.get(i).GetCategorieAge() + "  -  " + maListeAccreditation.get(i).GetNiveau());
		}
		list.setModel(dlm);
		
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == btnValider)
		{
			if(!comboBox.getSelectedItem().toString().equals(""))
			{
				m = new MoniteurDAO(ConnexionDAO.getInstance());
				if(!m.AccreditationExistante(monIdMoniteur, comboBox.getSelectedIndex()))
				{
					m.AjoutAccreditation(monIdMoniteur, comboBox.getSelectedIndex());
					this.dispose();
					Accreditation fen = new Accreditation(monIdMoniteur);
				}
				
			}	
		}
		
	}
}