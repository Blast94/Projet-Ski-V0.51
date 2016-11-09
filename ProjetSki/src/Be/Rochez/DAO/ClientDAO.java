package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.Client;

public class ClientDAO extends DAO<Client>{
	public ClientDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Client obj) {
		try
		{
			if(!RechercheClient(obj))
			{
				int id = -1;
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
						  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT ID FROM Personne where nom = \"" + obj.GetNom() + "\" and prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \""+ obj.GetDateNaissance() + "\"");
				if(result.first())
				{
					id = result.getInt("ID");	
				}
				if(id == -1)
				{
					System.out.println("Erreur lors de l'ajout du Client");
					return false;
				}
				else
				{
					//Ajout dans la table Client
					String query2 = "INSERT INTO Client (PersonneID, Login, Password, CompteBancaire) VALUES (" + id + ", \"" + obj.GetLogin() +"\",\"" + obj.GetPassword() + "\" ," + obj.GetCompteBancaire() +")";
					PreparedStatement s2 = this.connect.prepareStatement(query2);
					s2.execute();
					System.out.println("L'ajout s'est effectu� correctement");
					return true;
				}	
			}
			else
			{
				System.out.println("Le client que vous tentez d'ajouter existe d�ja");
				return false;
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erreur d'ajout dans la base de donn�es");
			return false;
		}  
	  }
	  public boolean delete(Client obj) {
	    return false;
	  }
	  public boolean update(Client obj) {
	    return false;
	  }
	  public boolean RechercheClient(Client obj)
	  {   
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Client M INNER JOIN Personne P ON M.PersonneID = P.ID WHERE Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \"" + obj.GetDateNaissance() + "\"");
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
	  public boolean RecherchePersonne(Client obj)
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

