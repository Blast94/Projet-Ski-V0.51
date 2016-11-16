package Be.Rochez.Singleton;

import java.util.ArrayList;

import Be.Rochez.Classes.TypeCours;
import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.DAO;
import Be.Rochez.DAO.TypeCoursDAO;

public class ListeTypeCours {
	private ArrayList<TypeCours> listeTypeCours = new ArrayList<TypeCours>();
	DAO<TypeCours> typeCoursDAO = new TypeCoursDAO(ConnexionDAO.getInstance());
    private static ListeTypeCours _instance = null;
    public ArrayList<TypeCours> getListeTypeCours() {
		return listeTypeCours;
	}
	public void setListeTypeCours(ArrayList<TypeCours> listeTypeCours) {
		this.listeTypeCours = listeTypeCours;
	}
    private ListeTypeCours()
    {	
    	for(int id = 1 ; id < 3 ; id++)
    	{
        	listeTypeCours.add(typeCoursDAO.find(id));
    	}	
    }
    public static ListeTypeCours Instance()
    {
        if (_instance == null)
        {
            _instance = new ListeTypeCours();
        }
        return _instance;
    }
}
