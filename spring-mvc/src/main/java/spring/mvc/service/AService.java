package spring.mvc.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AService {

    private final BService bService;

    public AService(@Lazy final BService bService) {
        this.bService = bService;
    }

    public void sayHi() {
        System.out.println("Hi, from A");
        bService.sayHi();
    }
}
