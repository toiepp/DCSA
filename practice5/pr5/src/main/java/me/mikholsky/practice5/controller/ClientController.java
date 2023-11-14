package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.Client;
import me.mikholsky.practice5.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends AbstractController<Client, ClientService> {
    public ClientController(ClientService service) {
        super(service);
    }
}
