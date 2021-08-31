package com.akvamarinika.spring.mvc_hibernate_aop.dao;
import com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories.DepartmentDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    SessionFactory sessionFactory;

    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        return departmentList;
    }

    @Override
    public void save(Department item) {

    }

    @Override
    public Optional<Department> get(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return true;

    }
}
