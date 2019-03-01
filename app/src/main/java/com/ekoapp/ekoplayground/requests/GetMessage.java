package com.ekoapp.ekoplayground.requests;

import com.google.gson.annotations.SerializedName;

import org.immutables.value.Value;

@Value.Immutable
public interface GetMessage extends EkoRequest {

    @Override
    default String getMethod() {
        return "";
    }

    @SerializedName("")
    String getChatId();
}
