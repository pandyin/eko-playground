package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public abstract class EkoRemoteDataStore<ENTITY extends EkoEntity> {

    private final EkoDao<ENTITY> dao;

    EkoRemoteDataStore(EkoDao<ENTITY> dao) {
        this.dao = dao;
    }

    public <DAO extends EkoDao> DAO getDao() {
        return (DAO) dao;
    }
}
