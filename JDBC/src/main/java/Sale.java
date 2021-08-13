import java.util.Date;

public class Sale {
    private int id;
    private int product_id;
    private int quantity;
    private int client_id;
    private int employee_id;
    private Date implementation_date;

    public Sale(int id, int product_id, int quantity, int client_id, int employee_id, Date implementation_date){
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.client_id = client_id;
        this.employee_id = employee_id;
        this.implementation_date = implementation_date;
    }

    @Override
    public String toString() {
        return "id: " + id + '\t' +
                "product_id: " + product_id + '\t' +
                "quantity: " + quantity + '\t' +
                "client_id: " + client_id + '\t' +
                "employee_id: " + employee_id + '\t' +
                "implementation_date: " + implementation_date;
    }
}
