package com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;

import java.util.List;

public interface StandardDAO<T> {
    List<T> getAll();
    void save(T item);
}
