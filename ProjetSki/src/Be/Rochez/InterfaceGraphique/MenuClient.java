package Be.Rochez.InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class MenuClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int monIdClient;
	private JButton btnModifProfil;
	private JButton btnDeconnexion;
	private JButton btnReservation;
	private JButton btnPanier;
	private JButton btnMesCours;

	/**
	 * Create the frame.
	 */
	public MenuClient(int id) {
		
		monIdClient = id;
		
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
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		btnDeconnexion = new JButton("Deconnexion");
		
		btnDeconnexion.addActionListener(this);
		
		btnModifProfil = new JButton("Modifier Profil");
		btnModifProfil.addActionListener(this);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenu)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addGap(192))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnModifProfil)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeconnexion)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMenu)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDeconnexion)
							.addComponent(btnModifProfil))
						.addComponent(label_2))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnReservation = new JButton("R\u00E9server !");
		btnReservation.addActionListener(this);
		
		btnPanier = new JButton("Mon Panier");
		btnPanier.addActionListener(this);
		
		btnMesCours = new JButton("Mes Cours");
		btnMesCours.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnReservation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPanier)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMesCours))
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReservation)
						.addComponent(btnPanier)
						.addComponent(btnMesCours))
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
			ModifProfil fen = new ModifProfil(monIdClient);
		}
		if(arg0.getSource() == btnReservation)
		{
			this.dispose();
			Reservation fen = new Reservation(monIdClient);
		}
		if(arg0.getSource() == btnPanier)
		{
			this.dispose();
			Panier fen = new Panier(monIdClient);
		}
		if(arg0.getSource() == btnMesCours)
		{
			this.dispose();
			CoursClient fen = new CoursClient(monIdClient);
		}
	}
}
