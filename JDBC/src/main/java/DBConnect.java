import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection connection;

    public static Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection != null){
            return connection;
        }
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


}
