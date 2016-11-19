package Be.Rochez.Classes;

public class Horaire {
	private int id;
	private String heureDebut;
	private String heureFin;
	private float prixParticulier;
	private int eleveMinParticulier;
	private int eleveMaxParticulier;
	private TypeCours typeCours;
	public Horaire()
	{
		
	}
	public Horaire(int id, String heureDebut, String heureFin , TypeCours typeCours, float prixParticulier, int eleveMinParticulier, int eleveMaxParticulier)
	{
		this.id = id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.typeCours = typeCours;
		this.prixParticulier = prixParticulier;
		this.eleveMinParticulier = eleveMinParticulier;
		this.eleveMaxParticulier = eleveMaxParticulier;
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
	public void SetHeureFin(String heureFin)
	{
		this.heureFin = heureFin;
	}
	public float GetPrixParticulier()
	{
		return this.prixParticulier;
	}
	public void SetPrixParticuliers(float prixParticulier)
	{
		this.prixParticulier = prixParticulier;
	}
	public TypeCours GetTypeCours()
	{
		return this.typeCours;
	}
	public void SetTypeCours(TypeCours typeCours)
	{
		this.typeCours = typeCours;
	}
	public int GetEleveMinParticulier() {
		return this.eleveMinParticulier;
	}
	public void SetEleveMinParticulier(int eleveMinParticulier) {
		this.eleveMinParticulier = eleveMinParticulier;
	}
	public int GetEleveMaxParticulier() {
		return this.eleveMaxParticulier;
	}
	public void SetEleveMaxParticulier(int eleveMaxParticulier) {
		this.eleveMaxParticulier = eleveMaxParticulier;
	}
	@Override
	public String toString() {
		return "De " + heureDebut + " � " + heureFin + " - Cours " + typeCours.GetDenomination();
	}
	
}
