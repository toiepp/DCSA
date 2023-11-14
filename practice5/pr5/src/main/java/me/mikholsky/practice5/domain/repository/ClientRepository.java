package me.mikholsky.practice5.domain.repository;

import me.mikholsky.practice5.domain.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CommonRepository<Client> {
}
