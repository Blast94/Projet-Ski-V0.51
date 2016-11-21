package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Be.Rochez.Classes.AccreditationC;
import Be.Rochez.Classes.Cours;

public class AccreditationDAO extends DAO<AccreditationC> {
	public AccreditationDAO(Connection conn) {
	    super(conn);
	  }
	//M�thode cr�ant une nouvelle accreditation
	  public boolean create(AccreditationC obj) {
		  try
		  {
				String query = "INSERT INTO Accreditation (MoniteurID, CoursID) VALUES (" + obj.GetIdMoniteur() + "," + obj.GetIdCours() + ")";
				PreparedStatement s2 = this.connect.prepareStatement(query);
				s2.execute();
				return true;
		  }
		  catch(SQLException e)
		  {
			  return false;
		  }  
	  }
	  //Methode supprimant une accreditation
	  public boolean delete(AccreditationC obj) {
		  try
		  {
			 String query = "DELETE FROM Accreditation WHERE MoniteurID = " + obj.GetIdMoniteur() 
			 + " AND CoursID = " + obj.GetIdCours();
			 PreparedStatement s = this.connect.prepareStatement(query);
			 s.execute();
			 return true;
		  }
		  catch(SQLException e)
		  {
			  return false;
		  }
	  }
	  public boolean update(AccreditationC obj) {
	    return false;
	  }
	  public AccreditationC find(int id) {
		  
		  return null;
	  }
	  //M�thode permettant de retourner un tableau d'accr�ditation pour un moniteur ayant pour but � charger la liste
	  public ArrayList<Cours> AccreditationProf(int idMoniteur)
	  {
		  ArrayList<Cours> mesAccreditations = new ArrayList<Cours>();
		  Cours monCours = new Cours();
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT C.ID, Sport, CategorieAge,Niveau FROM Moniteur M INNER JOIN Accreditation A ON M.ID = A.MoniteurID INNER JOIN Cours C ON A.CoursID = C.ID Where ID = " + idMoniteur );
			 if(result.first())
			 {
				 while(!result.isAfterLast())
				 {
					 monCours = new Cours(
							 result.getInt("ID"),
							 result.getString("Sport"),
							 result.getString("CategorieAge"),
							 result.getString("Niveau")
							 );
					 mesAccreditations.add(monCours);
					 result.next(); 
				 }
			 }
			 return mesAccreditations;
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
			  return null;
		  }
	  }
	  //Methode recherchant si une accr�ditation existe d�ja ou non
	  public boolean AccreditationExistante(int idMoniteur, int idCours)
	  {
		  try
		  {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accreditation WHERE MoniteurID = " + idMoniteur + " AND CoursID = " + idCours); 
			  if(result.first())
			  {
				  return true;
			  }
			  else
			  {
				  return false;
			  }
		  }
		  catch(SQLException e)
		  {
			  return false;
		  }
	  }
}
