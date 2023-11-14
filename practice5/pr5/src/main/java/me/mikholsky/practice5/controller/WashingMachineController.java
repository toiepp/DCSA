package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.WashingMachine;
import me.mikholsky.practice5.service.WashingMachineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/w-m")
public class WashingMachineController extends AbstractController<WashingMachine, WashingMachineService> {
    public WashingMachineController(WashingMachineService service) {
        super(service);
    }
}
