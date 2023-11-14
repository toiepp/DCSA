package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.WashingMachine;
import me.mikholsky.practice5.domain.repository.WashingMachineRepository;
import org.springframework.stereotype.Service;

@Service
public class WashingMachineService extends AbstractService<WashingMachine, WashingMachineRepository> {
    public WashingMachineService(WashingMachineRepository repository) {
        super(repository);
    }
}
