package com.ekoapp.ekoplayground.requests;

import com.google.gson.annotations.SerializedName;

import org.immutables.value.Value;

@Value.Immutable
public interface LogInRequest extends EkoRequest {

    @Override
    default String getMethod() {
        return "";
    }

    @SerializedName("username")
    String getUsername();

    @SerializedName("password")
    String getPassword();
}
