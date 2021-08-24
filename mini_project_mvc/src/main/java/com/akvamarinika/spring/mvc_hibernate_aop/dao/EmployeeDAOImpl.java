package com.akvamarinika.spring.mvc_hibernate_aop.dao;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee",  Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }
}
