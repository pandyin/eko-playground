package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.daos.UserDao;

import io.reactivex.Completable;

public class LogInViewModel extends EkoViewModel {

    public LogInViewModel(@NonNull Application application) {
        super(application);
    }

    public Completable logIn(String username, String password) {
        UserDao userDao = EkoDatabase.get().getUserDao();
        return Completable.complete();
    }
}
