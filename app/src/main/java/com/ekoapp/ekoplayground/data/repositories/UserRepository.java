package com.ekoapp.ekoplayground.data.repositories;

import com.ekoapp.ekoplayground.data.datasources.local.UserLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.UserRemoteDataStore;
import com.ekoapp.ekoplayground.data.persistences.daos.UserDao;

import io.reactivex.Completable;

public class UserRepository extends EkoRepository<UserLocalDataStore, UserRemoteDataStore> {

    public UserRepository(UserDao dao) {
        super(new UserLocalDataStore(dao), new UserRemoteDataStore(dao));
    }

    public Completable logIn(String username, String password) {
        if (username != null && password != null) {
            return getRemote().logIn(username, password);
        } else {
            return getLocal().logIn();
        }
    }
}
