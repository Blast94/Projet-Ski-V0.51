package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.Horaire;
import Be.Rochez.Classes.Semaine;

public class HoraireDAO extends DAO<Horaire> {
	public HoraireDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Horaire obj) {
		return false;
	  }
	  public boolean delete(Horaire obj) {
		  return false;
	  }
	  public boolean update(Horaire obj) {
	    return false;
	  }
	  public Horaire find(int id)
	  {
		  TypeCoursDAO t = new TypeCoursDAO(ConnexionDAO.getInstance());
		  Horaire horaire = new Horaire();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Horaire WHERE ID = " + id);
			  if(result.first())
				  horaire = new Horaire(
						  result.getInt("ID"),
						  result.getString("HeureDebut"),
						  result.getString("HeureFin"),
						  t.find(result.getInt("TypeCoursID")),
						  result.getInt("PrixParticulier")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return horaire;
	  }
}