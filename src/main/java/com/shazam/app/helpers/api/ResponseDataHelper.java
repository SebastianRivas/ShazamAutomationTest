package com.shazam.app.helpers.api;

import com.shazam.app.models.api.*;
import com.fasterxml.jackson.databind.*;

public class ResponseDataHelper {
    public static String responseDataToJson(ResponseData responseData) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseData);
        } catch (Exception e) {
            throw new RuntimeException("Error en ResponseData: ", e);
        }
    }
}
