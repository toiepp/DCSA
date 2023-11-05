package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.AbstractEntity;
import me.mikholsky.practice6.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {
    private S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Iterable<E>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<E> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<E> save(E e) {
        e = service.save(e);

        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    @Override
    public void update(E e) {
        service.save(e);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
