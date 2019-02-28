package com.ekoapp.ekoplayground.requests;

import org.immutables.value.Value;

@Value.Immutable
public class GetChat implements EkoRequest {

    @Override
    public String getMethod() {
        return "";
    }
}
