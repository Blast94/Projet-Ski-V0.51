package Be.Rochez.Classes;

public class Horaire {
	int id;
	String heureDebut;
	String heureFin;
	int prixParticulier;
	TypeCours typeCours;
	public Horaire()
	{
		
	}
	public Horaire(int id, String heureDebut, String heureFin , TypeCours typeCours, int prixParticulier)
	{
		this.id = id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.typeCours = typeCours;
		this.prixParticulier = prixParticulier;
	}
	public int GetId()
	{
		return this.id;
	}
	public String GetHeureDebut()
	{
		return this.heureDebut;
	}
	public void SetHeureDebut(String heureDebut)
	{
		this.heureDebut = heureDebut;
	}
	public String GetHeureFin()
	{
		return this.heureFin;
	}
	public void SetHeureFin()
	{
		this.heureFin = heureFin;
	}
	public int GetPrixParticulier()
	{
		return this.prixParticulier;
	}
	public void SetPrixParticuliers(int prixParticulier)
	{
		this.prixParticulier = prixParticulier;
	}
	@Override
	public String toString() {
		return "De " + heureDebut + " à " + heureFin + " - Cours " + typeCours.GetDenomination();
	}
	
}
