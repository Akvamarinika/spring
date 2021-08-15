package one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import one_to_one.entity.Detail;
import one_to_one.entity.Employee;

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
            Employee employee = new Employee("Mike", "Alexandrov", "IT", 2100);
            Detail detail = new Detail("New-York", "89257774444", "mike@gmail.com");
            detail.setEmployee(employee);
            employee.setDetail(detail); // detail_id in table employees

            session.beginTransaction();

            session.save(detail);

            Detail detailEmp = session.get(Detail.class, 7L);
            detailEmp.setPhoneNumber("89101237777");
            detailEmp.getEmployee().setDepartment("HR");


            session.getTransaction().commit();
            System.out.println(detail);
            System.out.println(detailEmp);
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
