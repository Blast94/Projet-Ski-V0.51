package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Be.Rochez.Classes.Personne;

public class PersonneDAO extends DAO<Personne> {
	public PersonneDAO(Connection conn) {
	    super(conn);
	  }
	//M�thode permettant de cr�er une personne 
	  public boolean create(Personne obj) {
		try
		{
			String query = "INSERT INTO PERSONNE (Nom, Prenom) VALUES (\"" + obj.GetNom() + "\", \"" + obj.GetPrenom() + "\")"; 
			PreparedStatement s = this.connect.prepareStatement(query);
			s.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	  }
	  public boolean delete(Personne obj) {
		  return false;
	  }
	  public boolean update(Personne obj) {
	    return false;
	  }
	  public Personne find(int id)
	  {
		  return null;
	  }
	  //M�thode mettant � jour le champs dateNaissanceFormatDate de la db
	  public void MAJDateNaissance()
	  {
		  try
		  {
			  String query = "UPDATE Personne SET Personne.DateNaissanceFormatDate = CDate([Personne].[DateNaissance])";
			  PreparedStatement s = this.connect.prepareStatement(query);
			  s.execute();
		  }
		  catch(SQLException e)
		  {
			  
		  }
	  }
	  //M�thode mettant � jour le champs age dans la db
	  public void MAJCalculAge()
	  {
		  try
		  {
			  String query = "UPDATE Personne SET Personne.Age = (Now()-[Personne].[DateNaissanceFormatDate])/365.25";
			  PreparedStatement s = this.connect.prepareStatement(query);
			  s.execute();
		  }
		  catch(SQLException e)
		  {
		  }
	  }
	 
	  
}
