package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.ekoapp.ekoplayground.data.persistences.daos.UserDao;
import com.ekoapp.ekoplayground.data.persistences.entities.User;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UserRemoteDataStore extends EkoRemoteDataStore<User> {

    public UserRemoteDataStore(UserDao dao) {
        super(dao);
    }

    public Completable logIn(String username, String password) {
        return EkoSocket.auth(username, password, UUID.randomUUID().toString())
                .flatMap(token -> {
                    User user = new User(UUID.randomUUID().toString(),
                            username,
                            token);

                    UserDao dao = getDao();
                    dao.insertUser(user);
                    return Single.just(user);
                })
                .doOnSuccess(user -> EkoSocket.connect(user.getToken()))
                .ignoreElement();
    }
}
