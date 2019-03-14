package com.ekoapp.ekoplayground.datasource.local;

import android.arch.paging.DataSource;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public abstract class EkoListLocalDataStore<ENTITY extends EkoEntity> extends EkoLocalDataStore {

    EkoListLocalDataStore(EkoDao<ENTITY> dao) {
        super(dao);
    }

    public DataSource.Factory<Integer, ENTITY> getFactory(String id) {
        return dao.getDataSourceFactory(id);
    }
}
