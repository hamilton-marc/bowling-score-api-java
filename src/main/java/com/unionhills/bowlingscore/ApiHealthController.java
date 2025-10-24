package com.unionhills.bowlingscore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiHealthController {

    @GetMapping("api")
    public Map<String, String> apiHealth() {
        return Map.of("status", "pass");
    }
}
