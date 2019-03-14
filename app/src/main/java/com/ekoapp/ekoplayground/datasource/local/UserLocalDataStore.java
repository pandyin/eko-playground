package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.UserDao;
import com.ekoapp.ekoplayground.socket.EkoSocket;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class UserLocalDataStore extends EkoLocalDataStore {

    public UserLocalDataStore(UserDao dao) {
        super(dao);
    }

    public Completable logIn() {
        UserDao dao = getDao();
        return dao.getUser()
                .switchIfEmpty(Maybe.never())
                .doOnSuccess(user -> EkoSocket.connect(user.getToken()))
                .ignoreElement();
    }
}
