package me.mikholsky.practice6.service;

import me.mikholsky.practice6.entity.AbstractEntity;
import me.mikholsky.practice6.repository.CommonRepository;

import java.util.List;

public interface CommonService<E extends AbstractEntity, R extends CommonRepository<E>> {
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void update(E e);

    void deleteById(Long id);
}
