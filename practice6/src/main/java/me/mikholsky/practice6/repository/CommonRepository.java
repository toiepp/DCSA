package me.mikholsky.practice6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E> extends JpaRepository<E, Long> {
}
