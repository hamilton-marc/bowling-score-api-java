package com.unionhills.bowlingscore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * This route allows an API consumer to check that the API is up and running.
 *
 */
@RestController
public class ApiHealthController {

    /**
     * This route provides the status of the API. { status : "pass" } means
     * we're good to go.
     *
     * @return JSON representation indicating the API is up and running.
     */
    @GetMapping("api")
    public Map<String, String> apiHealth() {
        return Map.of("status", "pass");
    }
}
