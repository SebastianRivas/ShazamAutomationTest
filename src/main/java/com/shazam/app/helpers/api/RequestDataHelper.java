package com.shazam.app.helpers.api;

import com.shazam.app.models.api.*;
import com.fasterxml.jackson.databind.*;

public class RequestDataHelper {
    public static RequestData jsonToRequestData(String args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(args, RequestData.class);
        } catch (Exception e) {
            throw new RuntimeException("Error en RequestDataHelper: ", e);
        }
    }
}
