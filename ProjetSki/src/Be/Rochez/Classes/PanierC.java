package Be.Rochez.Classes;

import java.util.ArrayList;

public class PanierC {
	ArrayList<ReservationC> monPanier;
	public PanierC()
	{
		this.monPanier = new ArrayList<ReservationC>();
	}
	public ArrayList<ReservationC> GetMonPanier() {
		return this.monPanier;
	}
	public void SetMonPanier(ArrayList<ReservationC> monPanier) {
		this.monPanier = monPanier;
	}
}
