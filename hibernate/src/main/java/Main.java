import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {


            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
           Employee employee = session.get(Employee.class, 3L);
           session.delete(employee);

           session.createQuery("delete Employee where name='Ivan'").executeUpdate();


            session.getTransaction().commit();
            System.out.println(1111);


        }
    }
}
