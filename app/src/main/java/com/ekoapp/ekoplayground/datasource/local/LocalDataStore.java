package com.ekoapp.ekoplayground.datasource.local;

import android.arch.paging.DataSource;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public abstract class LocalDataStore<ENTITY extends EkoEntity> {

    private final EkoDao<ENTITY> dao;

    LocalDataStore(EkoDao<ENTITY> dao) {
        this.dao = dao;
    }

    public DataSource.Factory<Integer, ENTITY> getFactory(String id) {
        return dao.getDataSourceFactory(id);
    }
}
