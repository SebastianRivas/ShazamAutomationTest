package com.shazam.app.models.api;

import java.util.*;

public class ResponseData {
    public String status_line;
    public Map<String, String> headers;
    public Object body;

    public ResponseData() {
        this.status_line = null;
        this.headers = null;
        this.body = null;
    }

    public ResponseData(String status_line, Map<String, String> headers, Object body) {
        this.status_line = status_line;
        this.headers = headers;
        this.body = body;
    }

    public String getStatus_line() {
        return status_line;
    }

    public void setStatus_line(String status_line) {
        this.status_line = status_line;
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
