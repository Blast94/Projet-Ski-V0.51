package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import Be.Rochez.Classes.Cours;
import Be.Rochez.Classes.TypeCours;


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
	  //M�thode recherchant un cours pars son ID et retournant un objet de type Cours
	  public Cours find(int id) {
		  TypeCoursDAO typeCoursDAO = new TypeCoursDAO(ConnexionDAO.getInstance());
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
						  result.getInt("AgeMinimum"),
						  result.getInt("AgeMaximum")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return cours;
	  }
	  //Pareil que m�thode du dessus mais on recherche avec Cours_TypeCours
	  public Cours CoursTypeCoursFind(int id)
	  {
		  TypeCoursDAO typeCoursDAO = new TypeCoursDAO(ConnexionDAO.getInstance()); 
		  
		  Cours cours = new Cours();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cours C INNER JOIN Cours_TypeCours CT ON C.ID = CT.CoursID INNER JOIN TypeCours T ON CT.TypeCoursID = T.ID WHERE CT.ID = " + id);
			  if(result.first())
				  cours = new Cours(
						  result.getInt("ID"),
						  result.getString("Sport"),
						  result.getString("CategorieAge"),
						  result.getString("Niveau"),
						  result.getInt("Prix"),
						  result.getInt("EleveMinimum"),
						  result.getInt("EleveMaximum"),
						  result.getInt("AgeMinimum"),
						  result.getInt("AgeMaximum"),
						  typeCoursDAO.find(result.getInt("TypeCoursID"))
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return cours;
	  }
	  //Recherche d'un cours via son ID et le type de cours choisi
	  public Cours find(int idCours, String typeCoursChoisi) {
		  TypeCoursDAO typeCoursDAO = new TypeCoursDAO(ConnexionDAO.getInstance()); 
		  TypeCours  monTypeCours = typeCoursDAO.find(typeCoursChoisi);
		  
		  Cours cours = new Cours();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT CT.ID, C.Sport, C.CategorieAge, C.Niveau, C.Prix, C.EleveMinimum, C.EleveMaximum, C.AgeMinimum, C.AgeMaximum FROM Cours C INNER JOIN Cours_TypeCours CT ON C.ID = CT.CoursID INNER JOIN TypeCours T ON CT.TypeCoursID = T.ID WHERE CT.CoursID = " + idCours + " AND CT.TypeCoursID = " + monTypeCours.Getid());
			  if(result.first())
				  cours = new Cours(
						  result.getInt("ID"),
						  result.getString("Sport"),
						  result.getString("CategorieAge"),
						  result.getString("Niveau"),
						  result.getInt("Prix"),
						  result.getInt("EleveMinimum"),
						  result.getInt("EleveMaximum"),
						  result.getInt("AgeMinimum"),
						  result.getInt("AgeMaximum"),
						  monTypeCours
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return cours;
	  }
	  //M�thode recherchant l'ID du cours
	  public int RechercheIDCours(Cours obj)
	  {
		  int id = -1;
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cours WHERE Sport = \"" + obj.GetSport() + "\" AND CategorieAge = \"" + obj.GetCategorieAge() + "\" AND Niveau = \"" + obj.GetNiveau() + "\"");
			  if(result.first())
			  {
				  id = result.getInt("ID");        
			  }
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return  id;
	  }
	 
}

