package Be.Rochez.Classes;

public class AccreditationC {
	int idMoniteur;
	int idCours;
	public AccreditationC()
	{
		
	}
	public AccreditationC(int idMoniteur, int idCours)
	{
		this.idMoniteur = idMoniteur;
		this.idCours = idCours;
	}
	public int GetIdMoniteur()
	{
		return this.idMoniteur;
	}
	public int GetIdCours()
	{
		return this.idCours;
	}
}
