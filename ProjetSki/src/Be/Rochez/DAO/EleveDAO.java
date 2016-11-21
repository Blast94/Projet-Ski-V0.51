package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.Client;
import Be.Rochez.Classes.Eleve;

public class EleveDAO extends DAO<Eleve> {
	public EleveDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Eleve obj) {
		  try
			{
			  //test si l'eleve existe deja
				if(!RechercheEleve(obj))
				{
					int idPersonne = -1;
					//test si la personne existe deja
					if(!RecherchePersonne(obj))
					{
						//Ajout dans la table Personne
						String query = "INSERT INTO Personne (Nom, Prenom, DateNaissance) VALUES (\"" + obj.GetNom() + "\", \"" + obj.GetPrenom() + "\", \"" + obj.GetDateNaissance() + "\")"; 
						PreparedStatement s = this.connect.prepareStatement(query);
						s.execute();
					}
					//Recherche de l'ID
					ResultSet result = this.connect.createStatement(
							  ResultSet.TYPE_SCROLL_INSENSITIVE,
							  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT ID FROM Personne where Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \""+ obj.GetDateNaissance() + "\"");
					if(result.first())
					{
						idPersonne = result.getInt("ID");	
					}
					if(idPersonne == -1)
					{
						return false;
					}
					else
					{
						String query2 = "INSERT INTO Eleve (PersonneID, Assurance) VALUES (" + idPersonne + "," + obj.GetAssurance() + ")";
						PreparedStatement s2 = this.connect.prepareStatement(query2);
						s2.execute();
						return true;
					}	
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
	  public boolean delete(Eleve obj) {
	    return false;
	  }
	  //Permet de mettre � jour l'assurance de l'eleve
	  public boolean update(Eleve obj) {
		  try
		  {
			  String query = "UPDATE Eleve SET Assurance = " + obj.GetAssurance() + " WHERE ID = " + obj.GetId();
				PreparedStatement s = this.connect.prepareStatement(query);
				s.execute();
				return true;
		  }
		  catch(SQLException e)
		  {
			  return false;
		  }	
	  }
	  //M�thode de rechercher l'ID d'un �l�ve via ces informations
	  public int RechercheEleveID(Eleve obj)
	  {
		  int id = -1;
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT E.ID FROM Eleve E INNER JOIN Personne P ON E.PersonneID = P.ID WHERE Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \"" + obj.GetDateNaissance() + "\"");
			  if(result.first())
				 id = result.getInt("ID");
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  } 
		  return id;
	  }
	  //M�thode testant si un eleve existe ou non
	  public boolean RechercheEleve(Eleve obj)
	  {   
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve M INNER JOIN Personne P ON M.PersonneID = P.ID WHERE Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \"" + obj.GetDateNaissance() + "\"");
			  if(result.first())
				 return true;
			  else
				  return false;
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
			  return false;
		  } 
	  }
	  //M�thode retournant un �l�ve en fonction de son ID
	  public Eleve find(int id)
	  {
		  Eleve monEleve = new Eleve();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT E.ID, Nom, Prenom, DateNaissance, Age, Assurance FROM Eleve E INNER JOIN Personne P ON E.PersonneID = P.ID WHERE E.ID = " + id);
			  if(result.first())
				  monEleve = new Eleve(
						  result.getInt("ID"),
						  result.getString("Nom"),
						  result.getString("Prenom"),
						  result.getString("DateNaissance"),
						  result.getInt("Age"),
						  result.getInt("Assurance")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return monEleve;
	  }
	  //M�thode testant si un personne existe ou non
	  public boolean RecherchePersonne(Eleve obj)
	  {
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \"" + obj.GetDateNaissance() + "\"");
			  if(result.first())
				 return true;
			  else
				  return false;
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
			  return false;
		  } 
	  }  
}
