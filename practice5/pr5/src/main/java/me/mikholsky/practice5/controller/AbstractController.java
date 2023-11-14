package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.AbstractEntity;
import me.mikholsky.practice5.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
    implements CommonController<E> {

    private final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<E> findById(int id) {
        return ResponseEntity.ok(service.findById(id).get());
    }

    @Override
    public ResponseEntity<E> save(E e) {
        var entity = service.save(e);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @Override
    public ResponseEntity<E> update(E e) {
        service.update(e);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<E> delete(E e) {
        service.delete(e);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<E> delete(int id) {
        service.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
