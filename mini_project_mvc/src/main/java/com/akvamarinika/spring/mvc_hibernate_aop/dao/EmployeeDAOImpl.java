package com.akvamarinika.spring.mvc_hibernate_aop.dao;

import com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories.EmployeeDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

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
        Query<Employee> query = session.createQuery("SELECT e FROM Employee e JOIN FETCH e.department depart",  Employee.class);
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
        session.saveOrUpdate(employee);

    }

    @Override
    public Optional<Employee> get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("SELECT emp FROM Employee emp JOIN FETCH emp.department depart WHERE emp.id = :id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        //Hibernate.initialize(employee.getDepartment());
        return Optional.ofNullable(employee);
    }

    @Override
    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("SELECT emp from Employee emp WHERE emp.id = :idEmployee", Employee.class);
        employeeQuery.setParameter("idEmployee", id);
        Employee employee = employeeQuery.getSingleResult();
        if (employee != null){
            session.delete(employee);
            return true;
        }
        return false;
    }
}
