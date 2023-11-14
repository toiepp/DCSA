package me.mikholsky.practice5.domain.repository;

import me.mikholsky.practice5.domain.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Integer> {
}
