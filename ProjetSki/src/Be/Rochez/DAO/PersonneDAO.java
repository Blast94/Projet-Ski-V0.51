package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Be.Rochez.Classes.Personne;

public class PersonneDAO extends DAO<Personne> {
	public PersonneDAO(Connection conn) {
	    super(conn);
	  }
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
}
