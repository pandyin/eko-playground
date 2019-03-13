package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;
import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.google.gson.JsonElement;

import io.reactivex.schedulers.Schedulers;

public abstract class RemoteDataStore<ENTITY extends EkoEntity> {

    private final EkoDao<ENTITY> dao;

    RemoteDataStore(EkoDao<ENTITY> dao) {
        this.dao = dao;
    }

    public void queryFirstPage() {
        EkoSocket.call(getFirstPageRequest())
                .map(JsonElement::getAsJsonArray)
                .doOnSuccess(dao::insert)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    abstract EkoRequest getFirstPageRequest();
}
