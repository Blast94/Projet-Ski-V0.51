package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Be.Rochez.Classes.Client;
import Be.Rochez.Classes.Eleve;
import Be.Rochez.Classes.Moniteur;

public class MoniteurDAO extends DAO<Moniteur>{
	public MoniteurDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Moniteur obj) {
		try
		{
			//test si le moniteur existe d�ja
			if(!RechercheMoniteur(obj))
			{
				int id = -1;
				//test si la personne existe d�ja
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
					return false;
				}
				else
				{
					//Ajout dans la table Moniteur
					String query2 = "INSERT INTO Moniteur (PersonneID, Login, Password, Salaire) VALUES (" + id + "," + obj.GetSalaire() + ")";
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
	  public boolean delete(Moniteur obj) {
	    return false;
	  }
	  //M�thode retournant un moniteur en fonction de son ID
	  public Moniteur find(int id)
	  {
		  Moniteur monMoniteur = new Moniteur();      
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT M.ID, Nom, Prenom, DateNaissance, Salaire FROM Moniteur M INNER JOIN Personne P ON M.PersonneID = P.ID WHERE M.ID = " + id);
			  if(result.first())
				  monMoniteur = new Moniteur(
						  result.getInt("ID"),
						  result.getString("Nom"),
						  result.getString("Prenom"),
						  result.getString("DateNaissance"),
						  result.getInt("Salaire")
						  );    
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return monMoniteur;
	  }
	  //M�thode m�tant � jour le profil du moniteur
	  public boolean update(Moniteur obj) {
		  try
		  {
			  int idPersonne = -1;
			  //Retrouver L'ID de la personne associ�e au client
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("Select PersonneID FROM Moniteur WHERE ID = " + obj.GetId());
			if(result.first())
			{
				idPersonne = result.getInt("PersonneID");	
			}
			if(idPersonne != -1)
			{
				String query = "UPDATE Personne SET Nom = \"" +  obj.GetNom() + "\", Prenom = \"" + obj.GetPrenom() + " \", DateNaissance = \"" + obj.GetDateNaissance() + "\" WHERE ID = " + idPersonne;
				PreparedStatement s = this.connect.prepareStatement(query);
				s.execute();
				query = "UPDATE Moniteur SET Login = \"" + obj.GetLogin() + "\", Password = \"" + obj.GetPassword() + "\" WHERE ID = " + obj.GetId();
				s = this.connect.prepareStatement(query);
				s.execute();
			}
			  
		  }
		  catch(SQLException e)
		  {
			  
		  }
	    return false;
	  }
	  //M�thode permettant de savoir si un moniteur existe ou non
	  public boolean RechercheMoniteur(Moniteur obj)
	  {   
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Moniteur M INNER JOIN Personne P ON M.PersonneID = P.ID WHERE Nom = \"" + obj.GetNom() + "\" and Prenom = \"" + obj.GetPrenom() + "\" and DateNaissance = \"" + obj.GetDateNaissance() + "\"");
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
	  //Recherche de moniteur particuli�re
	  public Moniteur RechercheMoniteurSansDate(String nom, String prenom)
	  {   
		  Moniteur monMoniteur = new Moniteur();
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT M.ID, P.Nom, P.Prenom, P.DateNaissance, M.Salaire FROM Moniteur M INNER JOIN Personne P ON M.PersonneID = P.ID WHERE Nom = \"" + nom + "\" and Prenom = \"" + prenom + "\"");
			  if(result.first())
				  monMoniteur = new Moniteur(
						  result.getInt("ID"),
						  result.getString("Nom"),
						  result.getString("Prenom"),
						  result.getString("DateNaissance"),
						  result.getInt("Salaire")
						  );         
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
			  return null;
		  } 
		  return monMoniteur;
	  }
	  //M�thode testant si une personne existe ou non
	  public boolean RecherchePersonne(Moniteur obj)
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
	  //M�thode permettant la connexion du moniteur
	  public int ConnexionMoniteur(String login, String password)
	  {
		  int id;
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Moniteur Where Login = \"" + login + "\"");
			  if(result.first())
			  {
				  if(result.getString("Password").equals(password))
				  {
					  id = result.getInt("ID");
					  return id;
				  }
				  else
				  {
					  return -1;
				  }	         
			  }
			  else
			  {
				  return -2;
			  }
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
			  return -3;
		  }
	  }
	  
	  public Moniteur TrouverMoniteur(int id)
	  {
		  Moniteur monMoniteur = new Moniteur();
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Moniteur M INNER JOIN Personne P ON M.PersonneID = P.ID Where ID = " + id );
			  if(result.first())
			  {
				  monMoniteur = new Moniteur(
						  result.getString("Nom"),
						  result.getString("Prenom"),
						  result.getString("DateNaissance"),
						  result.getString("Login"),
						  result.getString("Password"),
						  result.getInt("Salaire")
						  );
			  }
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  return monMoniteur;
	  }
	  //M�thode retournant une liste de moniteur en fonction du cours pass� en param�tre
	  public ArrayList<Moniteur> MoniteurAccredite(int idCours)
	  {
		  ArrayList<Moniteur> monTableauDeMoniteur = new ArrayList<Moniteur>();
		  Moniteur monMoniteur = new Moniteur();
		  try {
			  ResultSet result = this.connect.createStatement(
					  ResultSet.TYPE_SCROLL_INSENSITIVE,
					  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT M.ID, P.Nom, P.Prenom FROM Accreditation A INNER JOIN Moniteur M ON A.MoniteurID = M.ID INNER JOIN Personne P ON M.PersonneID = P.ID WHERE A.CoursID = " + idCours);
			 if(result.first())
			 {
				 while(!result.isAfterLast())
				 {
					 monMoniteur = new Moniteur(
							 result.getInt("ID"),
							 result.getString("Nom"),
							 result.getString("Prenom")
							 );
					 monTableauDeMoniteur.add(monMoniteur);
					 result.next(); 
				 }
			 }
			 return monTableauDeMoniteur;
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
			  return null;
		  }
	  }
}
