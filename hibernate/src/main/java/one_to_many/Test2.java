package one_to_many;


import one_to_many.entity.Department;
import one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession()){
            Department department = new Department("IT", 1000, 3000);

            Employee emp1 = new Employee("Mike", "Aleksandrov",2500);
            Employee emp2 = new Employee("Elena", "Sidorova", 2500);
            Employee emp3 = new Employee("Alex", "Ivanov", 2000);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            department.addEmployeeToDepartment(emp3);

            session.beginTransaction();

            session.save(department);

            Department depart = session.get(Department.class, department.getId());
            depart.getListEmp().forEach(System.out::println);

            session.getTransaction().commit();

            System.out.println(department);
        }



    }
}
