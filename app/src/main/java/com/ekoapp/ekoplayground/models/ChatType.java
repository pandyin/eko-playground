package com.ekoapp.ekoplayground.models;

import android.support.annotation.NonNull;

import com.google.common.base.Objects;

public enum ChatType {
    DIRECT("direct_chatv2"),
    GROUP("group_chatv2"),
    UNKNOWN("unknown");

    private final String apiKey;

    ChatType(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    @NonNull
    public static ChatType fromApikey(String apiKey) {
        for (ChatType type : values()) {
            if (Objects.equal(type.getApiKey(), apiKey)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
