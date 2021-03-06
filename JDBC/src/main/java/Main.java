
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/comp";
        String user = "postgres";
        String pass = "postgres";


        try (Connection connection = DBConnect.getConnection(url, user, pass)) {
            for (int i=0; i<10; i++){
                int prodId = (int)(Math.random() * 15 + 1);
                int quantity = (int)(Math.random() * 20 + 1);
                int clientId = (int)(Math.random() * 10 + 1);
                int empId = (int)(Math.random() * 10 + 1);
                preparedInsertSale(connection, prodId, quantity, clientId, empId, java.sql.Date.valueOf("2021-08-16"));
            }




            //bigSales(statement);
           /* statement.addBatch("INSERT INTO sales (product_id, quantity, client_id, employee_id, implementation_date) VALUES (2, 5, 1, 2, '2021-08-14')");
            statement.addBatch("INSERT INTO sales (product_id, quantity, client_id, employee_id, implementation_date) VALUES (1, 2, 2, 1, '2021-08-14')");
            statement.addBatch("INSERT INTO sales (product_id, quantity, client_id, employee_id, implementation_date) VALUES (3, 4, 3, 4, '2021-08-14')");
            statement.executeBatch();
            statement.clearBatch();*/
            Statement statement = connection.createStatement();
            printSale(statement);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void preparedInsertSale(Connection connection, int productId, int quantity, int clientId, int employeeId, Date implementation_date) throws SQLException {
        final String insert = "INSERT INTO sales(product_id, quantity, client_id, employee_id, implementation_date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, productId);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setInt(3, clientId);
        preparedStatement.setInt(4, employeeId);
        preparedStatement.setDate(5, implementation_date);
        preparedStatement.executeUpdate();
        preparedStatement.close();
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
        statement.close();


    }
}
