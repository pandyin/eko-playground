package com.ekoapp.ekoplayground.data.datasources.local;

import com.ekoapp.ekoplayground.data.persistences.daos.EkoDao;

public abstract class EkoLocalDataStore {

    final EkoDao dao;

    EkoLocalDataStore(EkoDao dao) {
        this.dao = dao;
    }

    public <DAO extends EkoDao> DAO getDao() {
        return (DAO) dao;
    }
}
