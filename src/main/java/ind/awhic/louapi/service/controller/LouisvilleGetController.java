package ind.awhic.louapi.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LouisvilleGetController {

    @GetMapping("/")
    public String index() {
        return "Hello from LouAPI!";
    }
}
