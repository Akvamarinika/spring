package com.akvamarinika.spring.mvc_hibernate_aop.dao;

import com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories.EmployeeDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("SELECT e FROM Employee e",  Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        Long id = employee.getDepartment().getId();
        Session session = sessionFactory.getCurrentSession();
        Query<Department> departmentQuery = session.createQuery("SELECT depart from Department depart WHERE depart.id = :id", Department.class);
        departmentQuery.setParameter("id", id);
        Department department = departmentQuery.getSingleResult();
        employee.setDepartment(department);
        session.persist(employee);

    }
}
