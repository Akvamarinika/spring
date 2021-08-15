package one_to_many;


import one_to_many.entity.Department;
import one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("org.hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession()){

            session.beginTransaction();

            session.getTransaction().commit();
        }

    }
}
