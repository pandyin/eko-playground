package com.ekoapp.ekoplayground.requests;

import org.immutables.value.Value;

@Value.Immutable
public class LogInRequest implements EkoRequest {

    @Override
    public String getMethod() {
        return "";
    }
}
