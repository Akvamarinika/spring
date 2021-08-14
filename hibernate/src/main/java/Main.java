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
           Employee employee = session.get(Employee.class, 6L);
           employee.setSalary(1200);

           session.createQuery("update Employee set salary=1800 where name='Ivan'").executeUpdate();


            session.getTransaction().commit();
            System.out.println(1111);


        }
    }
}
