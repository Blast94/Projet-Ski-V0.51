package Be.Rochez.Singleton;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Be.Rochez.Classes.Horaire;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.DAO;
import Be.Rochez.DAO.HoraireDAO;

public class ListeHoraire {
	private ArrayList<Horaire> listeHoraire = new ArrayList<Horaire>();
	DAO<Horaire> horaireDAO = new HoraireDAO(ConnexionDAO.getInstance());
    private static ListeHoraire _instance = null;
    public ArrayList<Horaire> getListeHoraire() {
		return listeHoraire;
	}
	public void setListeHoraire(ArrayList<Horaire> listeHoraire) {
		this.listeHoraire = listeHoraire;
	}
    private ListeHoraire()
    {	
    	for(int id = 1 ; id < 6 ; id++)
    	{
        	listeHoraire.add(horaireDAO.find(id));
    	}	
    }
    public static ListeHoraire Instance()
    {
        if (_instance == null)
        {
            _instance = new ListeHoraire();
        }
        return _instance;
    }
}
