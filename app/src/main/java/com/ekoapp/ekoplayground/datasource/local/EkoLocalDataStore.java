package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.EkoDao;

public abstract class EkoLocalDataStore {

    final EkoDao dao;

    EkoLocalDataStore(EkoDao dao) {
        this.dao = dao;
    }

    public <DAO extends EkoDao> DAO getDao() {
        return (DAO) dao;
    }
}
