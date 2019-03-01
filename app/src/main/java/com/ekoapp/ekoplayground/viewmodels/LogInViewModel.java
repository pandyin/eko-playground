package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.UserDao;
import com.ekoapp.ekoplayground.room.entities.User;
import com.ekoapp.ekoplayground.socket.EkoSocket;

import java.util.UUID;

import io.reactivex.Single;

public class LogInViewModel extends EkoViewModel {

    public LogInViewModel(@NonNull Application application) {
        super(application);
    }

    public Single<User> logIn(String username, String password) {
        UserDao userDao = EkoDatabase.get()
                .getUserDao();

        return userDao
                .getUser()
                .switchIfEmpty(EkoSocket.connect(username, password, UUID.randomUUID().toString())
                        .doOnComplete(() -> userDao.insertUser(new User()))
                        .andThen(userDao.getUser().toSingle()));
    }
}
