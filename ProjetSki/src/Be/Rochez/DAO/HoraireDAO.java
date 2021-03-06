package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.Horaire;

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
	  //M�thode permettant de retourner un horaire en fonction de son ID
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
						  result.getInt("PrixParticulier"),
						  result.getInt("EleveMinParticulier"),
						  result.getInt("EleveMaxParticulier")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return horaire;
	  }
	  //M�thode permettant de retourner un horaire en fonction de son heure de d�but et de son heure de fin
	  public Horaire find(String heureDebut, String heureFin)
	  {
		  TypeCoursDAO t = new TypeCoursDAO(ConnexionDAO.getInstance());
		  Horaire horaire = new Horaire();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Horaire WHERE HeureDebut = \"" + heureDebut + "\" and HeureFin = \"" + heureFin + "\"");
			  if(result.first())
				  horaire = new Horaire(
						  result.getInt("ID"),
						  result.getString("HeureDebut"),
						  result.getString("HeureFin"),
						  t.find(result.getInt("TypeCoursID")),
						  result.getInt("PrixParticulier"),
						  result.getInt("EleveMinParticulier"),
						  result.getInt("EleveMaxParticulier")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return horaire;
	  }
}