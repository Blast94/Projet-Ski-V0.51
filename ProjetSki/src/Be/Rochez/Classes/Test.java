package Be.Rochez.Classes;

import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.InterfaceGraphique.Accueil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ConnexionDAO.getInstance());
		Accueil page1 = new Accueil();
	}

}
