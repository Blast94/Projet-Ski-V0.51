package Be.Rochez.Singleton;

import java.util.ArrayList;

import Be.Rochez.Classes.Semaine;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.DAO;
import Be.Rochez.DAO.SemaineDAO;

public class ListeSemaine {
	private ArrayList<Semaine> listeSemaine = new ArrayList<Semaine>();
	DAO<Semaine> semaineDAO = new SemaineDAO(ConnexionDAO.getInstance());
    private static ListeSemaine _instance = null;
    public ArrayList<Semaine> getListeSemaine() {
		return listeSemaine;
	}
	public void setListeSemaine(ArrayList<Semaine> listeSemaine) {
		this.listeSemaine = listeSemaine;
	}
    private ListeSemaine()
    {	
    	for(int id = 1 ; id < 23 ; id++)
    	{
        	listeSemaine.add(semaineDAO.find(id));
    	}	
    }
    public static ListeSemaine Instance()
    {
        if (_instance == null)
        {
            _instance = new ListeSemaine();
        }
        return _instance;
    }
}
