package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.socket.EkoSocket;
import com.ekoapp.ekoplayground.socket.requests.EkoRequest;
import com.ekoapp.ekoplayground.data.persistences.daos.EkoDao;
import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;
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
