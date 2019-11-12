package trabajopracticopoo2.vinoapp.connectors;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private static String driver = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://localhost:3306/VinoappDB";
    private static String user = "root";
    private static String pass = "root";
    
//    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String url = "jdbc:mysql://remotemysql.com:3306/pg5dcP32qz";
//    private static String user = "pg5dcP32qz";
//    private static String pass = "TgypFEybwT";

    
    private static Connection conn = null;
    private Connector() {
    }

    public synchronized static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
