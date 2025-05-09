package com.shazam.app.questions.api;

import java.util.*;
import net.serenitybdd.rest.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CheckResponseHeaders implements Question<Boolean> {
    private final Map<String, Object> expectedHeaders;

    public CheckResponseHeaders(Map<String, Object> expectedHeaders) {
        this.expectedHeaders = expectedHeaders;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        expectedHeaders.forEach((key, value) -> {
            String requestHeaderValue = SerenityRest.lastResponse().getHeader(key).toString();

            actor.attemptsTo(
                    Ensure.that(requestHeaderValue).isEqualTo(value.toString()));
        });

        return true;
    }

    public static CheckResponseHeaders is(Map<String, Object> expectedHeaders) {
        return new CheckResponseHeaders(expectedHeaders);
    }
}
