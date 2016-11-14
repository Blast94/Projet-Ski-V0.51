package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import Be.Rochez.Classes.Cours;


public class CoursDAO extends DAO<Cours> {
	public CoursDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Cours obj) {
		 return false;
	  }
	  public boolean delete(Cours obj) {
	    return false;
	  }
	  public boolean update(Cours obj) {
	    return false;
	  }
	  public Cours find(int id) {
		  Cours cours = new Cours();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cours WHERE ID = " + id);
			  if(result.first())
				  cours = new Cours(
						  result.getInt("ID"),
						  result.getString("Sport"),
						  result.getString("CategorieAge"),
						  result.getString("Niveau"),
						  result.getInt("Prix"),
						  result.getInt("EleveMinimum"),
						  result.getInt("EleveMaximum"),
						  result.getInt("AgeMinimum")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return cours;
	  }
	 
}

