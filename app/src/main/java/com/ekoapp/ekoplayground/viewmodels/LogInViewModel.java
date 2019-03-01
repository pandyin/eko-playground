package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.requests.ImmutableLogInRequest;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.User;
import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.google.gson.Gson;

import io.reactivex.Single;

public class LogInViewModel extends EkoViewModel {

    public LogInViewModel(@NonNull Application application) {
        super(application);
    }

    public Single<User> getUser() {
        return EkoDatabase.get()
                .getUserDao()
                .getUser()
                .switchIfEmpty(logIn());
    }

    private Single<User> logIn() {
        return EkoSocket.call(ImmutableLogInRequest.builder().build())
                .doOnSuccess(json -> EkoDatabase.get()
                        .getUserDao()
                        .insertUser(new Gson().fromJson(json, User.class)))
                .ignoreElement()
                .andThen(EkoDatabase.get()
                        .getUserDao()
                        .getUser()
                        .toSingle());
    }
}
