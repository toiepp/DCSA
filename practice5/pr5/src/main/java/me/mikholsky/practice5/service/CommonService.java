package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {
    List<E> findAll();

    Optional<E> findById(int id);

    E save(E e);

    void update(E e);

    void delete(E e);

    void deleteById(int id);
}
