package com.unionhills.bowlingscore.controller;

import com.unionhills.bowlingscore.shared.BowlingScoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * The bowling score controller is the entry point to the API. There's really only 1
 * HTTP method (GET) which is used as there is no state persistence required for this
 * project.
 * <p>
 * The consumer of the web service will initiate a request containing a comma delimited
 * set of "throws" (max of 21) and then an object is returned representing the score card
 *
 */
@RestController
public class BowlingScoreController {

    /**
     * This method responds to an HTTP GET, expecting a "throws" parameter containing
     * a comma-delimited set of consecutive bowling throws.
     *
     * @return a response containing the bowling score information or error information.
     * @throws Exception
     */
    @GetMapping("api/score")
    public ResponseEntity<?> scoreGame() throws Exception {
        throw new BowlingScoreException("Invalid input. No bowling throws were provided. " +
                "Use a \"throws\" query parameter with a comma delimited " +
                "set of throw values indicating the number of pins " +
                "knocked down for each throw.");
    }

    /**
     * Interprets Throwable to decide which HTTP response code to use.
     *
     * @param exception
     * @return a JSON payload with the proper error code and message
     */
    private ResponseEntity<Map<String, String>> mapErrorResponse(Throwable exception) {
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (exception instanceof BowlingScoreException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        var response = ResponseEntity.status(httpStatus)
                .body(Map.of("error", exception.getMessage()));

        return response;
    }
}
