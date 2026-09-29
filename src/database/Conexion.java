package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static String url = "jdbc:mysql://localhost:3306/inventory_db";
    static String user = System.getenv("DB_USER");
    static String password = System.getenv("DB_PASSWORD");

    public static Connection conectar() {

        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

             return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}