package com.shazam.app.interactions.api;

import java.util.*;
import java.time.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.rest.interactions.*;

public class GetRequest implements Interaction {
    private final String route;
    private final Map<String, String> pathParams;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;

    public GetRequest(String route, Map<String, String> pathParams, Map<String, String> queryParams,
            Map<String, String> headers) {
        this.route = route;
        this.pathParams = pathParams != null ? pathParams : Collections.emptyMap();
        this.queryParams = queryParams != null ? queryParams : Collections.emptyMap();
        this.headers = headers != null ? headers : Collections.emptyMap();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(route)
                        .with(request -> request
                                .headers(headers)
                                .pathParams(pathParams)
                                .queryParams(queryParams)
                                .log().all()));

        actor.remember("executedAt", Instant.now().toString());
    }

    public static GetRequest to(String route, Map<String, String> pathParams, Map<String, String> queryParams,
            Map<String, String> headers) {
        return Tasks.instrumented(GetRequest.class, route, pathParams, queryParams, headers);
    }
}
