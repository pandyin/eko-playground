package com.ekoapp.ekoplayground.requests;

import org.immutables.value.Value;

@Value.Immutable
public interface GetChat extends EkoRequest {

    @Override
    default String getMethod() {
        return "";
    }
}
