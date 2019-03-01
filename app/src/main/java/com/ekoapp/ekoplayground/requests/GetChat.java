package com.ekoapp.ekoplayground.requests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.immutables.value.Value;

@Value.Immutable
public interface GetChat extends EkoRequest {

    @Override
    default String getMethod() {
        return "v1/group.query";
    }

    @Override
    default JsonElement getParam1() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("direct_chatv2");
        jsonArray.add("group_chatv2");
        return jsonArray;
    }

    @Override
    default JsonElement getParam2() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("skip", getSkip());
        jsonObject.addProperty("limit", getLimit());
        return jsonObject;
    }

    int getSkip();

    int getLimit();
}
