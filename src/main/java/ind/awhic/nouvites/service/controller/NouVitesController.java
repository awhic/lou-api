package ind.awhic.nouvites.service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/admin")
public class NouVitesController {
    @GetMapping("/version")
    public String getVersion() {
        return "NouVites Version 0.1.0";
    }

    @GetMapping("/host")
    public String getHost() {
        return "LocalHost";
    }
}
