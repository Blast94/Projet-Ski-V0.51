package Be.Rochez.Classes;

public class Moniteur extends Personne{
	private int id;
	private String login;
	private String password;
	private float salaire;
	public Moniteur(){}
	public Moniteur(int id, String nom, String prenom)
	{
		super(nom, prenom);
		this.id = id;
	}
	public Moniteur(int id, String nom, String prenom, String dateNaissance, float salaire)
	{
		super(nom, prenom, dateNaissance);
		this.id = id;
		this.salaire = salaire;
	}
	public Moniteur(String nom, String prenom, String dateNaissance, String login, String password, float salaire)
	{
		super(nom, prenom, dateNaissance);
		this.login = login;
		this.password = password;
		this.salaire = salaire;
	}
	public Moniteur(int id, String nom, String prenom, String dateNaissance, String login, String password)
	{
		super(nom, prenom, dateNaissance);
		this.id = id;
		this.login = login;
		this.password = password;
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
	public float GetSalaire()
	{
		return this.salaire;
	}
	public void SetSalaire(float salaire)
	{
		this.salaire = salaire;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
