package com.shazam.app.interactions.api;

import java.util.*;
import java.time.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.rest.interactions.*;

public class PostRequest implements Interaction {
    private final String route;
    private final Map<String, String> pathParams;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;
    private final Object body;

    public PostRequest(String route, Map<String, String> pathParams, Map<String, String> queryParams,
            Map<String, String> headers, Object body) {
        this.route = route;
        this.pathParams = pathParams != null ? pathParams : Collections.emptyMap();
        this.queryParams = queryParams != null ? queryParams : Collections.emptyMap();
        this.headers = headers != null ? headers : Collections.emptyMap();
        this.body = body != null ? body : Collections.emptyMap();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(route)
                        .with(request -> request
                                .headers(headers)
                                .pathParams(pathParams)
                                .queryParams(queryParams)
                                .body(body)
                                .log().all()));

        actor.remember("executedAt", Instant.now().toString());
    }

    public static PostRequest to(String route, Map<String, String> pathParams, Map<String, String> queryParams,
            Map<String, String> headers, Object body) {
        return Tasks.instrumented(PostRequest.class, route, pathParams, queryParams, headers, body);
    }
}
