package com.ekoapp.ekoplayground.common.socket.requests;

import com.google.gson.JsonElement;

public interface EkoRequest {

    String getMethod();

    JsonElement getParam1();

    JsonElement getParam2();
}
