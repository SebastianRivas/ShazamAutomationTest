package com.shazam.app.questions.api;

import net.serenitybdd.rest.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CheckResponseStatusLine implements Question<Boolean> {
    private final String expectedStatusLine;

    public CheckResponseStatusLine(String expectedStatusLine) {
        this.expectedStatusLine = expectedStatusLine;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String requestStatusLine = SerenityRest.lastResponse().getStatusLine().toString();

        actor.attemptsTo(
                Ensure.that(requestStatusLine).isEqualTo(expectedStatusLine));

        return true;
    }

    public static CheckResponseStatusLine is(String expectedStatusLine) {
        return new CheckResponseStatusLine(expectedStatusLine);
    }
}
