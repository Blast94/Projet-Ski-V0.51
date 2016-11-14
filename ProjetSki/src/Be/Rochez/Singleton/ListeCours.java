package Be.Rochez.Singleton;

import java.util.ArrayList;

import Be.Rochez.Classes.Cours;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.CoursDAO;
import Be.Rochez.DAO.DAO;

public class ListeCours {
	private ArrayList<Cours> listeCours = new ArrayList<Cours>();
	DAO<Cours> coursDAO = new CoursDAO(ConnexionDAO.getInstance());
    private static ListeCours _instance = null;
    public ArrayList<Cours> getListeCours() {
		return listeCours;
	}
	public void setListeCours(ArrayList<Cours> listeCours) {
		this.listeCours = listeCours;
	}
    private ListeCours()
    {	
    	for(int id = 1 ; id < 41 ; id++)
    	{
        	listeCours.add(coursDAO.find(id));
    	}	
    }
    public static ListeCours Instance()
    {
        if (_instance == null)
        {
            _instance = new ListeCours();
        }
        return _instance;
    }
}
