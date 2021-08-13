
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/comp";
        String user = "postgres";
        String pass = "postgres";
        try (Connection connection = DBConnect.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
            bigSales(statement);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void bigSales(Statement statement) throws SQLException{
        String query = "SELECT  SUM(sales.quantity * products.retail_price) AS sales_may,\n" +
                "        concat(employees.surname, ' ', substring(employees.first_name for 1), '. ', substring(employees.middle_name for 1), '. ') AS employees\n" +
                "        FROM sales\n" +
                "        INNER JOIN products ON sales.product_id = products.id\n" +
                "        INNER JOIN employees ON sales.employee_id = employees.id\n" +
                "        WHERE to_char(sales.implementation_date, 'YYYY-MM') = '2020-05'\n" +
                "        GROUP BY employees\n" +
                "        HAVING SUM(sales.quantity * products.retail_price) > 5000\n" +
                "        ORDER BY sales_may DESC;";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String employee = resultSet.getString("employees");
            int salesMay = resultSet.getInt("sales_may");
            System.out.println(String.format("Employee: %s \t Sales may: %d", employee, salesMay));
        }
    }

    public static void printSale(Statement statement) throws SQLException {
        String query = "SELECT * FROM sales ";
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


    }
}
