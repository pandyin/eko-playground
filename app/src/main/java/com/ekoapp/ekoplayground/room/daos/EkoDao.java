package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;
import com.google.gson.JsonArray;

import java.util.List;

public abstract class EkoDao<ENTITY extends EkoEntity> {

    @Update
    public abstract void update(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(List<ENTITY> entities);

    public void insert(JsonArray jsonArray) {

    }

    public DataSource.Factory<Integer, ENTITY> getDataSourceFactory(String id) {
        return null;
    }
}
