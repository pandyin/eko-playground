package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;
import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.google.gson.JsonElement;

import io.reactivex.schedulers.Schedulers;

public abstract class EkoListRemoteDataStore<ENTITY extends EkoEntity> extends EkoRemoteDataStore<ENTITY> {

    EkoListRemoteDataStore(EkoDao<ENTITY> dao) {
        super(dao);
    }

    public void getFirstPage(String id) {
        EkoSocket.call(getFirstPageRequest(id))
                .map(JsonElement::getAsJsonArray)
                .doOnSuccess(getDao()::insert)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    abstract EkoRequest getFirstPageRequest(String id);
}
