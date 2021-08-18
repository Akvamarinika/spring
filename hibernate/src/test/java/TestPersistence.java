import one_to_many.entity.Department;
import one_to_many.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestPersistence {
    private EntityManager entityManager;
    @Before
    public void init() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "QuickStart" );
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void close() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }

    @Test
    public void saveDepartmentWithEmployees(){
        Department department = new Department("IT", 1000, 3000);

        Employee emp1 = new Employee("Mike", "Aleksandrov",2500);
        Employee emp2 = new Employee("Elena", "Sidorova", 2500);
        Employee emp3 = new Employee("Alex", "Ivanov", 2000);
        Employee emp4 = new Employee("Vasilii", "Petrov",2100);

        department.addEmployeeToDepartment(emp1);
        department.addEmployeeToDepartment(emp2);
        department.addEmployeeToDepartment(emp3);
        department.addEmployeeToDepartment(emp4);

        entityManager.persist(department);
        Employee employeeFromDB = entityManager.find(Employee.class, 2L);
        Assert.assertNotNull(employeeFromDB);
        Assert.assertEquals(employeeFromDB.getSurname(), "Sidorova");

    }

    @Test
    public void removeEmployee(){
        Employee employeeFromDB = entityManager.find(Employee.class, 3L);
        Assert.assertEquals(employeeFromDB.getSurname(), "Ivanov");
        entityManager.remove(employeeFromDB);


    }

    @Test
    public void saveEmployeeWithDepartment(){
        Department department = new Department("sales", 1000, 2000);
        Employee emp1 = new Employee("Nik", "Alekseev",1500);

        emp1.setDepartment(department);
        entityManager.persist(emp1);

        Department departFromDB = null;

        try {
            Query query = entityManager.createQuery("SELECT depart FROM Department depart WHERE depart.departmentName = 'sales'");
            departFromDB = (Department) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(department, departFromDB);

    }

    @Test
    public void getEmployeesFromDepartment(){
        Query query = entityManager.createQuery("SELECT depart FROM Department depart WHERE depart.departmentName = 'IT'");
        Department department = (Department) query.getSingleResult();

        department.getListEmp().forEach(System.out::println);

    }

    @Test
    public void getDepartmentFromEmployee(){
        Query query = entityManager.createQuery("SELECT emp FROM Department dep JOIN dep.listEmp emp WHERE emp.surname = 'Ivanov'");
        Employee emp = (Employee) query.getSingleResult();

        Assert.assertNotNull(emp);
        Assert.assertEquals("Ivanov", emp.getSurname());
        Assert.assertEquals("IT", emp.getDepartment().getDepartmentName());

    }


}
