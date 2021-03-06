package Be.Rochez.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;

import Be.Rochez.Classes.Semaine;

public class SemaineDAO extends DAO<Semaine> {
	public SemaineDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Semaine obj) {
		return false;
	  }
	  public boolean delete(Semaine obj) {
		  return false;
	  }
	  public boolean update(Semaine obj) {
	    return false;
	  }
	  //m�thode retournant une semaine en fonction de l'ID pass�e en param�tre
	  public Semaine find(int id)
	  {
		  Semaine semaine = new Semaine();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Semaine WHERE ID = " + id);
			  if(result.first())
				  semaine = new Semaine(
						  result.getInt("ID"),
						  result.getDate("DateDebut").toLocalDate(),
						  result.getDate("DateFin").toLocalDate(),
						  result.getString("Descriptif"),
						  result.getInt("CongeScolaire")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return semaine;
	  }
}