package hql;

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


           session.createQuery("update Employee set department = 'IT', salary = 2500 where name='Alex'").executeUpdate();


            session.getTransaction().commit();
            System.out.println(1111);


        }
    }
}
