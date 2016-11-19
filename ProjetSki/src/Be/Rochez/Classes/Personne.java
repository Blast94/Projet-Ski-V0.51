package Be.Rochez.Classes;

public class Personne {
	int id;
	String nom;
	String prenom;
	String dateNaissance; 
	public Personne() {	}
	public Personne(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne(String nom, String prenom, String dateNaissance)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;	
	}
	public Personne(int id , String nom, String prenom, String dateNaissance)
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public int GetId()
	{
		return this.id;
	}
	public String GetNom()
	{
		return this.nom;
	}
	public void SetNom(String nom)
	{
		this.nom = nom;
	}
	public String GetPrenom()
	{
		return this.prenom;
	}
	public void SetPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public String GetDateNaissance()
	{
		return this.dateNaissance;
	}
	public void SetDateNaissance(String dateNaissance)
	{
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
