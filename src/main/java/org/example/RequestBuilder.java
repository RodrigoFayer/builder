package org.example;

import java.util.Map;

public class RequestBuilder {
    private Request request;

    public RequestBuilder() {
        this.request = new Request();
    }

    public Request build() {
        if (this.request.getUrl().isEmpty()) {
            throw new IllegalArgumentException("Invalid URL");
        }

        if (this.request.getMethod().isEmpty()) {
            throw new IllegalArgumentException("Invalid method");
        }

        return this.request;
    }

    public RequestBuilder setUrl(String url) {
        this.request.setUrl(url);
        return this;
    }

    public RequestBuilder setMethod(String method) {
        this.request.setMethod(method);
        return this;
    }

    public RequestBuilder setHeaders(Map<String, String> headers) {
        this.request.setHeaders(headers);
        return this;
    }

    public RequestBuilder setQueryParams(Map<String, String> queryParams) {
        this.request.setQueryParams(queryParams);
        return this;
    }

    public RequestBuilder setBody(Map<String, String> body) {
        this.request.setBody(body);
        return this;
    }
}
