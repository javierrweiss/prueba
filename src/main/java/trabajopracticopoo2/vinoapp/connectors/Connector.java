package trabajopracticopoo2.vinoapp.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

//    private static String driver = "org.mariadb.jdbc.Driver";
//    private static String url = "jdbc:mariadb://localhost:3306/VinoappDB";
//    private static String user = "root";
//    private static String pass = "Leon 22 *";
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://remotemysql.com:3306/pg5dcP32qz";
    private static String user = "pg5dcP32qz";
    private static String pass = "TgypFEybwT";

    
    private static Connection conn = null;
    private Connector() {
    }

    public synchronized static Connection getConnection() {
//        try { //modificado 
//            if (conn == null || conn.isClosed()) { //conn.isClosed() modificado en caso que hubiesen errores que se presentaron en trabajos de otros compañeros
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, user, pass);
                } catch (Exception e) {e.printStackTrace(); }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex); //código creado por el IDE tras el "Surround with try-catch"
//        }
        return conn;
    }
}
