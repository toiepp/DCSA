package me.mikholsky.practice5.domain.repository;

import me.mikholsky.practice5.domain.entity.WashingMachine;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingMachineRepository extends CommonRepository<WashingMachine> {
}
