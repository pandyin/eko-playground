package com.ekoapp.ekoplayground.common;

public enum Direction {

    PREVIOUS("previous"),
    NEXT("next"),
    CENTER("center");

    private final String apiKey;

    Direction(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
