package com.akvamarinika.spring.mvc_hibernate_aop.services;
import java.util.List;
import java.util.Optional;

public interface StandardService<T, N extends Number> {
    List<T> getAll();
    void save(T item);
    Optional<T> get(N id);
}
