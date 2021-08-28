package com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface StandardDAO<T, N extends Number> {
    List<T> getAll();
    void save(T item);
    Optional<T> get(N id);
}
