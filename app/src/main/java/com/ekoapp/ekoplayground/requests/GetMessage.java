package com.ekoapp.ekoplayground.requests;

import com.ekoapp.ekoplayground.models.Direction;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.immutables.value.Value;

@Value.Immutable
public interface GetMessage extends EkoRequest {

    @Override
    default String getMethod() {
        return "v1/message.findByThreadSegment";
    }

    @Override
    default JsonElement getParam1() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tid", getChatId());
        jsonObject.addProperty("threadSegment", getMessageNumber());
        jsonObject.addProperty("direction", getDirection().getApiKey());
        jsonObject.addProperty("limit", getLimit());
        return jsonObject;
    }

    @Override
    default JsonElement getParam2() {
        return null;
    }

    String getChatId();

    int getMessageNumber();

    Direction getDirection();

    int getLimit();
}
