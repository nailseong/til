package spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.service.AService;

@RestController
@RequestMapping("/cycles")
public class CycleController {

    private final AService aService;

    public CycleController(final AService aService) {
        this.aService = aService;
    }

    @GetMapping
    public ResponseEntity<Void> sayHi() {
        aService.sayHi();
        return ResponseEntity.ok().build();
    }
}
