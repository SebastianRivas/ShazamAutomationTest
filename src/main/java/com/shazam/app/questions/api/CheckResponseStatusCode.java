package com.shazam.app.questions.api;

import net.serenitybdd.rest.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CheckResponseStatusCode implements Question<Boolean> {
    private final Integer expectedStatusCode;

    public CheckResponseStatusCode(Integer expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Integer requestStatusCode = SerenityRest.lastResponse().getStatusCode();

        actor.attemptsTo(
                Ensure.that(requestStatusCode).isEqualTo(expectedStatusCode));

        return true;
    }

    public static CheckResponseStatusCode is(Integer expectedStatusCode) {
        return new CheckResponseStatusCode(expectedStatusCode);
    }
}
