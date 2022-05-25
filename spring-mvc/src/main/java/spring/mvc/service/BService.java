package spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class BService {

    private final AService aService;

    public BService(final AService aService) {
        this.aService = aService;
    }

    public void sayHi() {
        System.out.println("Hi, from B");
        aService.sayHi();
    }
}
