package relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import relations.entity.Detail;
import relations.entity.Employee;

public class Example {
    public static void main(String[] args) {
        Session session = null;
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        try {
            session = sessionFactory.getCurrentSession();
            //Employee employee = new Employee("Petr", "Kapustin", "IT", 1900);
            //Detail detail = new Detail("Tomsk", "89251234444", "kapustin@gmail.com");
           // employee.setDetailId(detail);

            session.beginTransaction();
            //session.save(employee);

            Employee emp = session.get(Employee.class, 2L);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println(emp);
            System.out.println(emp.getDetailId());
        } catch (Exception e){
            if (session != null) {
                session.beginTransaction().rollback();
            }
    } finally {
           if (session != null) {
               session.close();
           }
            sessionFactory.close();
        }

    }
}
