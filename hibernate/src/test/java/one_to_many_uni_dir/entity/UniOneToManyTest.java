package one_to_many_uni_dir.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class UniOneToManyTest {
    SessionFactory factory;
    private Session session;

    @Before
    public void setUp(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    @After
    public void tearDown(){
        if (session.isOpen()){
            session.getTransaction().commit();
        }
        session.close();
        factory.close();
    }

    @Test
    public void createDepartmentWithEmployees(){
        Department depart1 = new Department("HR", 1000, 2000);
        Department depart2 = new Department("IT", 2000, 3000);

        Employee emp1 = new Employee("Mike", "Aleksandrov",2500);
        Employee emp2 = new Employee("Elena", "Sidorova", 2500);
        Employee emp3 = new Employee("Alex", "Ivanov", 2000);
        Employee emp4 = new Employee("Vasilii", "Petrov",1000);
        Employee emp5 = new Employee("Oleg", "Sidorov",1200);

        depart1.addEmployeeToDepartment(emp1);
        depart1.addEmployeeToDepartment(emp2);
        depart1.addEmployeeToDepartment(emp3);
        depart2.addEmployeeToDepartment(emp4);
        depart2.addEmployeeToDepartment(emp5);

        session.save(depart1);
        session.save(depart2);

        List<Employee> employees = session.createQuery("SELECT emp FROM Department depart JOIN depart.listEmp emp WHERE depart.departmentName = 'HR'").list();
        employees.forEach(System.out::println);

    }

    @Test
    public void updateDepartmentWithEmployees(){
        createDepartmentWithEmployees();

        Query<Employee> query = session.createQuery("SELECT emp FROM Department depart JOIN depart.listEmp emp WHERE emp.surname ='Petrov' ");
        Employee emp = query.getSingleResult();

        assertNotNull(emp);
        assertEquals("Petrov", emp.getSurname());

        emp.setSalary(5555);

    }

    @Test
    public void deleteDepartmentWithEmployees(){
        createDepartmentWithEmployees();

        Query<Department> query = session.createQuery("SELECT depart FROM Department depart WHERE depart.departmentName = 'HR'");
        Department department = query.getSingleResult();

        assertNotNull(department);
        assertEquals("HR", department.getDepartmentName());

        session.delete(department);
    }


}