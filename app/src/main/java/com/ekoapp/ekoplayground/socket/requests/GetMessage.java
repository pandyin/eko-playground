package com.ekoapp.ekoplayground.socket.requests;

import com.ekoapp.ekoplayground.common.Direction;
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
        jsonObject.addProperty("tid", getTopicId());
        jsonObject.addProperty("threadSegment", getSkip());
        jsonObject.addProperty("direction", Direction.PREVIOUS.getApiKey());
        jsonObject.addProperty("limit", getLimit());
        return jsonObject;
    }

    @Override
    default JsonElement getParam2() {
        return null;
    }

    String getTopicId();

    int getSkip();

    int getLimit();
}
