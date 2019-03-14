package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.data.persistences.daos.EkoDao;
import com.ekoapp.ekoplayground.data.persistences.entities.EkoEntity;

public abstract class EkoRemoteDataStore<ENTITY extends EkoEntity> {

    private final EkoDao<ENTITY> dao;

    EkoRemoteDataStore(EkoDao<ENTITY> dao) {
        this.dao = dao;
    }

    public <DAO extends EkoDao> DAO getDao() {
        return (DAO) dao;
    }
}
