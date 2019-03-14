package com.ekoapp.ekoplayground.data.datasources.local;

import android.arch.paging.DataSource;

import com.ekoapp.ekoplayground.data.persistences.daos.EkoDao;
import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;

public abstract class EkoListLocalDataStore<ENTITY extends EkoEntity> extends EkoLocalDataStore {

    EkoListLocalDataStore(EkoDao<ENTITY> dao) {
        super(dao);
    }

    public DataSource.Factory<Integer, ENTITY> getFactory(String id) {
        return dao.getDataSourceFactory(id);
    }
}
