package com.ekoapp.ekoplayground.data.datasources.local;

import com.ekoapp.ekoplayground.common.socket.EkoSocket;
import com.ekoapp.ekoplayground.data.persistences.daos.UserDao;

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
