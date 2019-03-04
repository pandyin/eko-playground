package com.ekoapp.ekoplayground.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.immutables.value.Value;

@Value.Immutable
public interface GetTopic extends EkoRequest {

    @Override
    default String getMethod() {
        return "thread.query";
    }

    @Override
    default JsonElement getParam1() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("gid", getChatId());
        return jsonObject;
    }

    @Override
    default JsonElement getParam2() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("isArchived", false);
        jsonObject.addProperty("skip", getSkip());
        jsonObject.addProperty("limit", getLimit());
        return jsonObject;
    }

    String getChatId();

    int getSkip();

    int getLimit();
}
