package com.shazam.app.tasks.api;

import com.shazam.app.models.api.*;
import net.serenitybdd.screenplay.*;
import com.shazam.app.helpers.api.*;
import com.shazam.app.interactions.api.*;

public class DetailSong implements Task {
    private final RequestData requestData;

    public DetailSong(String args) {
        this.requestData = RequestDataHelper.jsonToRequestData(args);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetRequest.to(
                        actor.recall("route"),
                        requestData.getPathParams(),
                        requestData.getQueryParams(),
                        requestData.getHeaders()));
    }

    public static DetailSong withId(String args) {
        return Tasks.instrumented(DetailSong.class, args);
    }
}