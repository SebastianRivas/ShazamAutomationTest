package com.shazam.app.stepdefinitions.api;

import com.shazam.app.utils.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.rest.abilities.*;
import net.thucydides.model.util.*;

public class CommonStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("{actor} quiere probar el endpoint {string}")
    public void actor_quiere_probar_el_endpoint(Actor actor, String endpoint) {
        String url = environmentVariables.optionalProperty("restapi.baseurl").orElse("https://shazam.p.rapidapi.com");
        actor.can(CallAnApi.at(url));

        switch (endpoint) {
            case "Songs Detect":
                actor.remember("route", APIConstants.DETECT);
                break;

            case "Songs Details":
                actor.remember("route", APIConstants.DETAILS);
                break;

            default:
                break;
        }
    }
}
