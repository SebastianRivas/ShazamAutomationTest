package com.shazam.app.tasks.api;

import com.shazam.app.models.api.*;
import net.serenitybdd.screenplay.*;
import com.shazam.app.helpers.api.*;
import com.shazam.app.interactions.api.*;

public class DetectSong implements Task {
    private final RequestData requestData;

    public DetectSong(String args) {
        this.requestData = RequestDataHelper.jsonToRequestData(args);
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostRequest.to(
                        actor.recall("route"),
                        requestData.getPathParams(),
                        requestData.getQueryParams(),
                        requestData.getHeaders(),
                        requestData.getBody()));
    }

    public static DetectSong withHeaders(String args) {
        return Tasks.instrumented(DetectSong.class, args);
    }
}