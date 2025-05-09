package com.shazam.app.questions.api;

import java.util.*;
import net.serenitybdd.rest.*;
import net.serenitybdd.screenplay.*;
import io.restassured.common.mapper.*;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CheckResponseBody implements Question<Boolean> {
    private final Map<String, Object> expectedBody;

    public CheckResponseBody(Map<String, Object> expectedBody) {
        this.expectedBody = expectedBody;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Map<String, Object> requestBody = SerenityRest.lastResponse().getBody().as(new TypeRef<Map<String, Object>>() {
        });

        requestBody.forEach((key, value) -> {
            String requestValue = "", expectedValue = "";

            requestValue = value.toString();
            expectedValue = expectedBody.get(key).toString();

            actor.attemptsTo(
                    Ensure.that(requestValue).isEqualTo(expectedValue));

        });

        return true;
    }

    public static CheckResponseBody is(Map<String, Object> expectedBody) {
        return new CheckResponseBody(expectedBody);
    }
}
