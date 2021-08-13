
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/comp";
        String user = "postgres";
        String pass = "postgres";
        try(Connection connection = DBConnect.getConnection(url, user, pass);
            Statement statement = connection.createStatement()){
            String query = "SELECT * FROM sales";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int prodId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                int client_id = resultSet.getInt("client_id");
                int employee_id =  resultSet.getInt("employee_id");
                Date date = resultSet.getDate("implementation_date");
                System.out.println(new Sale(id, prodId, quantity, client_id, employee_id, date));

            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }






    }
}
