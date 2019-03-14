package com.ekoapp.ekoplayground.socket.requests;

import com.google.gson.JsonElement;

public interface EkoRequest {

    String getMethod();

    JsonElement getParam1();

    JsonElement getParam2();
}
