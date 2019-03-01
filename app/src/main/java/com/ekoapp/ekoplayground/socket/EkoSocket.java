package com.ekoapp.ekoplayground.socket;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.google.gson.JsonObject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class EkoSocket {

    public static Single<JsonObject> call(EkoRequest request) {
        return Single.never();
    }

    public Completable connect() {
        return Completable.never();
    }

    public void disconnect() {

    }
}
