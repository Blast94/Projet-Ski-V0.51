package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Be.Rochez.Classes.Cours;
import Be.Rochez.Classes.ReservationC;

public class ReservationDAO extends DAO<ReservationC> {
	public ReservationDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(ReservationC obj) {
		  try
		  {
				String query = "INSERT INTO Reservation (SemaineID, Cours_TypeCoursID, MoniteurID, EleveID, ClientID, HoraireID, StatutClient) VALUES (" + obj.GetSemaine().GetId() + ","  + obj.GetCours().GetId() + "," + obj.GetMoniteur().GetId() + "," + obj.GetEleve().GetId() + "," + obj.GetClient().GetId() + "," + obj.GetHoraire().GetId() + "," + obj.GetStatutClient() + ")";
				PreparedStatement s2 = this.connect.prepareStatement(query);
				s2.execute();
				System.out.println("L'ajout s'est effectu� correctement");
				return true;
		  }
		  catch(SQLException e)
		  {
			  System.out.println("Erreur lors de la reservation" + e.getMessage());
			  return false;
		  }  
	  }
	  public boolean delete(int numReservation) {
		  try
		  {
			 String query = "DELETE FROM Reservation WHERE ID = " + numReservation;
			 PreparedStatement s = this.connect.prepareStatement(query);
			 s.execute();
			 return true;
		  }
		  catch(SQLException e)
		  {
			  return false;
		  }
	  }
	  public boolean delete(ReservationC obj) {
		  return false;
	  }
	  public boolean update(ReservationC obj) {
		int valeurStatutClient = -1;
	    try
	    {
	    	String query = "UPDATE Reservation SET StatutClient = " + valeurStatutClient + " WHERE ID = " + obj.GetId();
			PreparedStatement s = this.connect.prepareStatement(query);
			s.execute();
			return true;
	    }
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur" + e.getMessage());
	    	return false;
	    }
	  }
	  public ReservationC find(int id) {
		  
		  return null;
	  }
	  public int RechercheReservationExistante(ReservationC obj)
	  {
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE SemaineID = " + obj.GetSemaine().GetId() + " AND Cours_TypeCoursID = " + obj.GetCours().GetId() + " AND MoniteurID = " + obj.GetMoniteur().GetId() + " AND EleveID = " + obj.GetEleve().GetId() + " AND ClientID = " + obj.GetClient().GetId() + " AND HoraireID = " + obj.GetHoraire().GetId());
			  if(result.first())
			  {
				  return 1;       
			  }
			  else
			  {
				  return 2;
			  }
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
			  return 3;
		  }
	  }
	  public int CountReservation(ReservationC obj)
	  { 
		  try
		  {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT count(*) FROM Reservation WHERE SemaineID = " + obj.GetSemaine().GetId() + " AND Cours_TypeCoursID = " + obj.GetCours().GetId() + " AND MoniteurID = " + obj.GetMoniteur().GetId() + " AND HoraireID = " + obj.GetHoraire().GetId());
			 if(result.first())
				 return result.getInt(1);
			 else
				 return -1;
		  }
		  catch(SQLException e)
		  {
			  return -2;
		  } 
	  }
	  public ArrayList<ReservationC> RecuperationReservationPanier(int idClient)
	  {
		  int statutClient = 0;
		  ReservationC maReservation = new ReservationC();
		  ArrayList<ReservationC> maListeReservation = new ArrayList<ReservationC>();
		  
		  ClientDAO clientDAO = new ClientDAO(ConnexionDAO.getInstance());
		  EleveDAO eleveDAO = new EleveDAO(ConnexionDAO.getInstance());
		  MoniteurDAO moniteurDAO = new MoniteurDAO(ConnexionDAO.getInstance());
		  HoraireDAO horaireDAO = new HoraireDAO(ConnexionDAO.getInstance());
		  SemaineDAO semaineDAO = new SemaineDAO(ConnexionDAO.getInstance());
		  CoursDAO coursDAO = new CoursDAO(ConnexionDAO.getInstance());
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE ClientID = " + idClient + " AND StatutClient = " + statutClient);
			 if(result.first())
			 {
				 while(!result.isAfterLast())
				 {
					 maReservation = new ReservationC(
							result.getInt("ID"),
							clientDAO.find(result.getInt("ClientID")),
							eleveDAO.find(result.getInt("EleveID")),
							moniteurDAO.find(result.getInt("MoniteurID")),
							horaireDAO.find(result.getInt("HoraireID")),
							semaineDAO.find(result.getInt("SemaineID")),
							coursDAO.CoursTypeCoursFind(result.getInt("Cours_TypeCoursID")),
							result.getInt("StatutClient")	
							);
					 maListeReservation.add(maReservation);
					 result.next(); 
				 }
			 }
			 return maListeReservation;
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
			  System.out.println("Erreur de requete " + e.getMessage());
			  return null;
		  }
	  }
}