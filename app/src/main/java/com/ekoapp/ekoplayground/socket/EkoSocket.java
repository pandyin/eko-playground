package com.ekoapp.ekoplayground.socket;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.google.common.base.Optional;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.annotation.Nullable;

import io.reactivex.Completable;
import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class EkoSocket {

    private static Optional<WebSocket> SOCKET = Optional.absent();

    public static Single<JsonObject> call(EkoRequest request) {
        return Single.never();
    }

    public static Completable connect(String username, String password, String deviceId) {
        return auth(username, password, deviceId)
                .doOnSuccess(EkoSocket::connect)
                .ignoreElement();
    }

    private static Single<String> auth(String username, String password, String deviceId) {
        return Single.fromCallable(() -> {
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            JsonObject json = new JsonObject();
            json.addProperty("username", username);
            json.addProperty("password", password);
            json.addProperty("deviceId", deviceId);
            json.addProperty("deviceVersion", "android");
            json.addProperty("deviceType", "android");
            json.addProperty("deviceModel", "android");
            json.addProperty("appId", "android");

            RequestBody body = RequestBody.create(mediaType, json.toString());

            Request request = new Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .url("https://staging-h1.dev.ekoapp.com/api/v1/auth/login")
                    .post(body)
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request)
                    .execute();

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response.body().string());
            return element.getAsJsonObject()
                    .get("accessToken")
                    .getAsString();
        });
    }

    private static void connect(String token) {
        Request request = new Request.Builder()
                .url(String.format("ws://staging-s1.dev.ekoapp.com/v2?token=%s", token))
                .build();

        OkHttpClient client = new OkHttpClient();
        SOCKET = Optional.of(client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable throwable, @Nullable Response response) {
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
            }
        }));
    }

    public static void disconnect() {
        if (SOCKET.isPresent()) {
            SOCKET.get().cancel();
            SOCKET = Optional.absent();
            EkoDatabase.get()
                    .getUserDao()
                    .deleteUser();
        }
    }
}
