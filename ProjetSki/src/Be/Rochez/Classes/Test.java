package Be.Rochez.Classes;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import Be.Rochez.DAO.ConnexionDAO;
import Be.Rochez.DAO.HoraireDAO;
import Be.Rochez.DAO.PersonneDAO;
import Be.Rochez.InterfaceGraphique.Accueil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ConnexionDAO.getInstance());
		Accueil page1 = new Accueil();
		Date date = new Date();
		
		Date date2 = new Date();
		Date date3 = new Date();
		
		LocalDate datelocal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		date.setMonth(date.getMonth()+ 1);
		date2.setMonth(date.getMonth()+ 2);
		date3.setMonth(date.getMonth()-1);
		if(date.before(date2) && date.after(date3))
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("pas ok");
		}
		System.out.println(date);
		System.out.println(datelocal);
		System.out.println(date2);
		System.out.println(date3);
		
	}

}
