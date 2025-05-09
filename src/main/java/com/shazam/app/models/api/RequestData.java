package com.shazam.app.models.api;

import java.util.*;

public class RequestData {
    public Map<String, String> pathParams;
    public Map<String, String> queryParams;
    public Map<String, String> headers;
    public Object body;

    public RequestData() {
        this.pathParams = null;
        this.queryParams = null;
        this.headers = null;
        this.body = null;
    }

    public RequestData(Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers,
            Object body) {
        this.pathParams = pathParams;
        this.queryParams = queryParams;
        this.headers = headers;
        this.body = body;
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public void setPathParams(Map<String, String> pathParams) {
        this.pathParams = pathParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
