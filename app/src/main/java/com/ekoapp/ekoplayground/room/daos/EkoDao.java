package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

import org.joda.time.DateTime;

import java.util.List;

public abstract class EkoDao<ENTITY extends EkoEntity> {

    @Update
    abstract void updateImpl(ENTITY entity);

    public void update(ENTITY entity) {
        entity.setLastUpdated(DateTime.now());
        updateImpl(entity);
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertImpl(ENTITY entity);

    public void insert(ENTITY entity) {
        entity.setLastUpdated(DateTime.now());
        insertImpl(entity);
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertImpl(List<ENTITY> entities);

    public void insert(List<ENTITY> entities) {
        for (ENTITY entity : entities) {
            entity.setLastUpdated(DateTime.now());
        }
        insertImpl(entities);
    }

    public DataSource.Factory<Integer, ENTITY> getDataSourceFactory(String id) {
        return null;
    }
}
