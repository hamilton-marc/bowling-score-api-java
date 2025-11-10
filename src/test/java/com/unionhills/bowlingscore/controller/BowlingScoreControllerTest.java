package com.unionhills.bowlingscore.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.blankOrNullString;

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
        var mockResult = mvc.perform(mockRequest);

        mockResult.andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        var isValidJsonResponse = jsonPath("$.error", not(blankOrNullString()));

        mockResult.andExpect(isValidJsonResponse);
    }

    /**
     * If the "throws" query parameter is given but contains invalid values, this is an
     * invalid request.
     *
     * @param throwValue
     * @throws Exception
     */
    @ParameterizedTest
    @ValueSource(strings = { "X", "10,10", "26,58", "-3,-5" })
    public void shouldReturnBadRequestGivenInvalidInput(String throwValue) throws Exception {
        var mockRequest = MockMvcRequestBuilders.get("/api/score")
                .param("throws", throwValue)
                .accept(MediaType.APPLICATION_JSON);

        var mockResult = mvc.perform(mockRequest);

        mockResult.andExpect(status().isBadRequest())
                  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        var isValidJsonResponse = jsonPath("$.error", not(blankOrNullString()));

        mockResult.andExpect(isValidJsonResponse);
    }

    @Test
    public void shouldReturnOkGivenValidParameters() throws Exception {
        var mockRequest = MockMvcRequestBuilders.get("/api/score").accept(MediaType.APPLICATION_JSON)
                .param("throws", "6")
                .accept(MediaType.APPLICATION_JSON);

        var mockResult = mvc.perform(mockRequest);

        mockResult.andExpect(status().isOk())
                  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
