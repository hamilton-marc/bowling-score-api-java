package com.unionhills.bowlingscore.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Tests the ApiHealthController
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ApiHealthControllerTest {
    @Autowired
    private MockMvc mvc;

    /**
     * Make sure the ApiHealthController returns the appropriate status message when
     * the API is up and running.
     *
     * @throws Exception
     */
    @Test
    public void shouldReturnPassingHealthStatus() throws Exception {
        var mockRequest = MockMvcRequestBuilders.get("/api").accept(MediaType.APPLICATION_JSON);

        mvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", equalTo("pass")));
    }
}
