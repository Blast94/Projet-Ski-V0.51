package Be.Rochez.Classes;

public class Semaine {
	int id;
	String dateDebut;
	String dateFin;
	String descriptif;
	int congeScolaire;
	public Semaine()
	{
		
	}
	public Semaine(String dateDebut, String dateFin, String descriptif, int congeScolaire)
	{
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.descriptif = descriptif;
		this.congeScolaire = congeScolaire;
	}
	public Semaine(int id,String dateDebut, String dateFin, String descriptif, int congeScolaire)
	{
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.descriptif = descriptif;
		this.congeScolaire = congeScolaire;
	}
	public int GetId()
	{
		return this.id;
	}
	public String GetDateDebut() {
		return this.dateDebut;
	}
	public void SetDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String GetDateFin() {
		return this.dateFin;
	}
	public void SetDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String GetDescriptif() {
		return this.descriptif;
	}
	public void SetDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public int GetCongeScolaire() {
		return congeScolaire;
	}
	public void SetCongeScolaire(int congeScolaire) {
		this.congeScolaire = congeScolaire;
	}
	@Override
	public String toString() {
		if(!this.descriptif.equals(""))
		{
			return "Du " + dateDebut + " au " + dateFin + " (" + descriptif + ")";
		}
		else
		{
			return "Du " + dateDebut + " au " + dateFin;
		}
		
	}
	
	
}
