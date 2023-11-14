package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.Telephone;
import me.mikholsky.practice5.service.TelephoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telephone")
public class TelephoneController extends AbstractController<Telephone, TelephoneService> {
    public TelephoneController(TelephoneService service) {
        super(service);
    }
}
