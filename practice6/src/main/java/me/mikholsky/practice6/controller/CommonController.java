package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommonController<E extends AbstractEntity> {
    @GetMapping
    ResponseEntity<Iterable<E>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<E> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<E> save(E e);

    @PutMapping
    void update(E e);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);
}
