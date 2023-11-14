package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.Client;
import me.mikholsky.practice5.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<Client, ClientRepository> {
    public ClientService(ClientRepository repository) {
        super(repository);
    }
}
