import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {


            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = new Employee("Kate", "Ivanova", "HR", 1500);
            session.save(employee);

            Employee emp = session.get(Employee.class, employee.getId());
            session.getTransaction().commit();
            System.out.println(emp);


        }
    }
}
