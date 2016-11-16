package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.TypeCours;

public class TypeCoursDAO extends DAO<TypeCours> {
	public TypeCoursDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(TypeCours obj) {
		return false;
	  }
	  public boolean delete(TypeCours obj) {
		  return false;
	  }
	  public boolean update(TypeCours obj) {
	    return false;
	  }
	  public TypeCours find(int id)
	  {
		  TypeCours typeCours = new TypeCours();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM TypeCours WHERE ID = " + id);
			  if(result.first())
				  typeCours = new TypeCours(
						  result.getInt("ID"),
						  result.getString("Denomination")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return typeCours;
	  }
	  ////
}