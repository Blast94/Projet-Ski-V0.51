package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Be.Rochez.DAO.MoniteurDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class MenuMoniteur extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int monIdMoniteur;
	private JButton btnModifAccreditation;
	private JButton btnModifProfil;
	private JButton btnDeconnexion;
	private JPanel panel;
	private JLabel label_2;

	/**
	 * Create the frame.
	 */
	public MenuMoniteur(int id) {
		
		monIdMoniteur = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		btnDeconnexion = new JButton("D\u00E9connexion");
		btnDeconnexion.addActionListener(this);
		
		btnModifProfil = new JButton("Modifier mon Profil");
		btnModifProfil.addActionListener(this);
		
		JLabel label = new JLabel("MENU");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addGap(192))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnModifProfil)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeconnexion)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDeconnexion)
							.addComponent(btnModifProfil)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnModifAccreditation = new JButton("Modifier mes accr\u00E9ditations");
		btnModifAccreditation.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnModifAccreditation)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifAccreditation)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnDeconnexion)
		{
			this.dispose();
			Accueil fen = new Accueil();
		}
		if(arg0.getSource() == btnModifProfil)
		{
			this.dispose();
			ModifProfilMoniteur fen = new ModifProfilMoniteur(monIdMoniteur);
		}
		if(arg0.getSource() == btnModifAccreditation)
		{
			this.dispose();
			Accreditation fen = new Accreditation(monIdMoniteur);
		}
	}
}
