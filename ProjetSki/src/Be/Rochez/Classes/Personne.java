package Be.Rochez.Classes;

public class Personne {
	int id;
	String nom;
	String prenom;
	String dateNaissance; 
	int age;
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
	public Personne(String nom, String prenom, String dateNaissance, int age)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
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
	public int GetAge()
	{
		return this.age;
	}
	public void SetAge(int age)
	{
		this.age = age;
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
