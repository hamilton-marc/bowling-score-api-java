package com.unionhills.bowlingscore.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the /api/score route.
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class BowlingScoreControllerTest {
    @Autowired
    private MockMvc mvc;

    /**
     * If no query parameters are given, this is an invalid request.
     *
     * @throws Exception
     */
    @Test
    public void shouldReturnBadRequestGivenNoQueryParameters() throws Exception {
        var mockRequest = MockMvcRequestBuilders.get("/api/score").accept(MediaType.APPLICATION_JSON);

        mvc.perform(mockRequest)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
