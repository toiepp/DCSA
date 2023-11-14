package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.Telephone;
import me.mikholsky.practice5.domain.repository.TelephoneRepository;
import org.springframework.stereotype.Service;

@Service
public class TelephoneService extends AbstractService<Telephone, TelephoneRepository> {
    public TelephoneService(TelephoneRepository repository) {
        super(repository);
    }
}
