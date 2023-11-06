package me.mikholsky.practice6.service;

import me.mikholsky.practice6.entity.AbstractEntity;
import me.mikholsky.practice6.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {
    protected R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public void update(E e) {
        if (e.getId() != null) {
            repository.save(e);
        } else {
            throw new IllegalArgumentException("ID should be passed within updatable entity");
        }
    }

    @Override
    public void deleteById(Long id) {
        var e = findById(id);

        repository.delete(e);
    }
}
