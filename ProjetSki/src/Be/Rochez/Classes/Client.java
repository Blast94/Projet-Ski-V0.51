package Be.Rochez.Classes;

public class Client extends Personne{
	int id;
	String login;
	String password;
	int compteBancaire;
	public Client(){
		
	}
	public Client(String nom, String prenom, String dateNaissance, String login, String password, int compteBancaire)
	{
		super(nom, prenom, dateNaissance);
		this.login = login;
		this.password = password;
		this.compteBancaire = compteBancaire;
	}
	public Client(int id, String nom, String prenom, String dateNaissance, String login, String password, int compteBancaire)
	{
		super(nom, prenom, dateNaissance);
		this.id = id;
		this.login = login;
		this.password = password;
		this.compteBancaire = compteBancaire;
	}
	public int GetId()
	{
		return this.id;
	}
	public String GetLogin()
	{
		return this.login;
	}
	public void SetLogin(String login)
	{
		this.login = login;
	}
	public String GetPassword()
	{
		return this.password;
	}
	public void SetPassword(String password)
	{
		this.password = password;
	}
	public int GetCompteBancaire()
	{
		return this.compteBancaire;
	}
	public void SetCompteBancaire(int compteBancaire)
	{
		this.compteBancaire = compteBancaire;
	}
}
