package Be.Rochez.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnexionDAO {
	private static Connection snglConnection = null;

    private ConnexionDAO() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String url = "jdbc:ucanaccess://./DBSki.accdb";

            snglConnection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Impossible de trouver le driver pour la base de donn�e!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Impossible de se connecter �  la base de donn�e.");
        }

        if (snglConnection == null) {
            JOptionPane.showMessageDialog(null, "La base de donn�e est innaccessible, fermeture du programme.");
            System.exit(0);
        }
    }
    public static Connection getInstance() {
        if (snglConnection == null) {
            new ConnexionDAO();
        }
        return snglConnection;
    }
}
