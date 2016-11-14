package Be.Rochez.Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;


public class Verification {
	public static boolean IsNumeric(String Nombre) {
        try {
        	Integer.parseInt(Nombre);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
	public static boolean IsDate(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	        sdf.parse(date);
	        return true;
	    }
	    catch(ParseException ex) {
	        return false;
	    }
	}
	public static boolean IsString(String mot)
	{
		if(Pattern.matches("[a-zA-Z]*", mot))
			return true;
		else
			return false;
	}
}
