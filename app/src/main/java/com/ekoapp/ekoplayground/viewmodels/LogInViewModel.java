package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.UserDao;
import com.ekoapp.ekoplayground.room.entities.User;
import com.ekoapp.ekoplayground.socket.EkoSocket;

import java.util.UUID;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class LogInViewModel extends EkoViewModel {

    public LogInViewModel(@NonNull Application application) {
        super(application);
    }

    public Maybe<User> logIn() {
        UserDao userDao = EkoDatabase.get()
                .getUserDao();

        return userDao.getUser()
                .switchIfEmpty(Maybe.empty())
                .doOnSuccess(user -> EkoSocket.connect(user.getToken()));
    }

    public Single<User> logIn(String username, String password) {
        UserDao userDao = EkoDatabase.get()
                .getUserDao();

        return EkoSocket.auth(username, password, UUID.randomUUID().toString())
                .flatMap(token -> {
                    User user = new User(UUID.randomUUID().toString(),
                            username,
                            token);
                    userDao.insertUser(user);
                    return Single.just(user);
                })
                .doOnSuccess(user -> EkoSocket.connect(user.getToken()));
    }
}
