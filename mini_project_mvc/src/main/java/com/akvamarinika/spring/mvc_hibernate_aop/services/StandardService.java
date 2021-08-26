package com.akvamarinika.spring.mvc_hibernate_aop.services;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import java.util.List;

public interface StandardService<T> {
    List<T> getAll();
    void save(T item);
}
