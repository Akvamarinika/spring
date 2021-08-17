import one_to_many.entity.Department;
import one_to_many.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    public void saveDepertmentWithEmployees(){
        Department department = new Department("IT", 1000, 3000);

        Employee emp1 = new Employee("Mike", "Aleksandrov",2500);
        Employee emp2 = new Employee("Elena", "Sidorova", 2500);
        Employee emp3 = new Employee("Alex", "Ivanov", 2000);

        department.addEmployeeToDepartment(emp1);
        department.addEmployeeToDepartment(emp2);
        department.addEmployeeToDepartment(emp3);

        entityManager.persist(department);
        Employee employeeFromDB = entityManager.find(Employee.class, 2L);
        Assert.assertNotNull(employeeFromDB);
        Assert.assertEquals(employeeFromDB.getSurname(), "Sidorova");



    }
}
