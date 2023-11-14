package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {
    @GetMapping
    ResponseEntity<List<E>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<E> findById(@PathVariable int id) throws Exception;

    @PostMapping
    ResponseEntity<E> save(@RequestBody E e);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E e);

    @DeleteMapping
    ResponseEntity<E> delete(@RequestBody E e);

    @DeleteMapping("/{id}")
    ResponseEntity<E> delete(@PathVariable int id);
}
