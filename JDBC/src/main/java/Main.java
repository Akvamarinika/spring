import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:postgres://localhost:5432/demo";
        String user = "postgres";
        String pass = "postgres";
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, user, pass);

            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
