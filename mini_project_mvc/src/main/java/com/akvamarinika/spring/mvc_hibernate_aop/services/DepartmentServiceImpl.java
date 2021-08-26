package com.akvamarinika.spring.mvc_hibernate_aop.services;
import com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories.DepartmentDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(DepartmentDAO departmentDAO){
        this.departmentDAO = departmentDAO;
    }

    @Override
    @Transactional
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Department item) {

    }
}
