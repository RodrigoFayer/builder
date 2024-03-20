package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestBuilderTest {
    @Test
    void shouldReturnAnErrorWhenBuildingARequestWithAnEmptyUrl() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setMethod("GET");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            requestBuilder.build();
        });

        String expectedMessage = "Invalid URL";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldReturnAnErrorWhenBuildingARequestWithAnEmptyMethod() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setUrl("https://api.example.com");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            requestBuilder.build();
        });

        String expectedMessage = "Invalid method";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldReturnARequest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        Request request = requestBuilder.setUrl("https://api.example.com")
                .setMethod("GET")
                .build();

        assertEquals("https://api.example.com", request.getUrl());
        assertEquals("GET", request.getMethod());
        assertNotNull(request);
    }
}
