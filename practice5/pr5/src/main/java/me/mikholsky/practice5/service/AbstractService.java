package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.AbstractEntity;
import me.mikholsky.practice5.domain.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> findAll() {
        return (List<E>) repository.findAll();
    }

    @Override
    public Optional<E> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public void update(E e) {
        repository.save(e);
    }

    @Override
    public void delete(E e) {
        repository.delete(e);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
