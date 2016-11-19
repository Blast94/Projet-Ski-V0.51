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
				if(!RechercheEleve(obj))
				{
					int idPersonne = -1;
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
						System.out.println("Erreur lors de l'ajout du moniteur");
						return false;
					}
					else
					{
						String query2 = "INSERT INTO Eleve (PersonneID, Assurance) VALUES (" + idPersonne + "," + obj.GetAssurance() + ")";
						PreparedStatement s2 = this.connect.prepareStatement(query2);
						s2.execute();
						System.out.println("L'ajout de l'�l�ve s'est effectu� correctement");
						return true;
					}	
				}
				else
				{
					System.out.println("L'�l�ve que vous tentez d'ajouter existe d�ja");
					return false;
				}
			}
			catch(SQLException e)
			{
				System.out.println("Erreur d'ajout dans la base de donn�es");
				return false;
			}  
	  }
	  public boolean delete(Eleve obj) {
	    return false;
	  }
	  public boolean update(Eleve obj) {
		  try
		  {
			  System.out.println(obj.GetAssurance() + " " + obj.GetId());
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
	  public Eleve find(int id)
	  {
		  Eleve monEleve = new Eleve();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT E.ID, Nom, Prenom, DateNaissance, Assurance FROM Eleve E INNER JOIN Personne P ON E.PersonneID = P.ID WHERE E.ID = " + id);
			  if(result.first())
				  monEleve = new Eleve(
						  result.getInt("ID"),
						  result.getString("Nom"),
						  result.getString("Prenom"),
						  result.getString("DateNaissance"),
						  result.getInt("Assurance")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return monEleve;
	  }
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
