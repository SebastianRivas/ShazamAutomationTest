package com.shazam.app.tasks.api;

import java.util.*;
import net.serenitybdd.screenplay.*;
import com.shazam.app.questions.api.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.*;

public class ValidateResponse implements Task {
    private final String args;

    public ValidateResponse(String args) {
        this.args = args;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String, Object>> json = null;

        try {
            json = mapper.readValue(args, new TypeReference<Map<String, Map<String, Object>>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Map.Entry<String, Map<String, Object>> value : json.entrySet()) {
            if (value.getValue() != null) {
                switch (value.getKey()) {
                    case "status_line":
                        actor.asksFor(CheckResponseStatusLine.is(value.getValue().get("status_line").toString()));
                        break;

                    case "headers":
                        actor.asksFor(CheckResponseHeaders.is(value.getValue()));
                        break;

                    case "body":
                        actor.asksFor(CheckResponseBody.is(value.getValue()));
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public static ValidateResponse validate(String args) {
        return Tasks.instrumented(ValidateResponse.class, args);
    }
}
