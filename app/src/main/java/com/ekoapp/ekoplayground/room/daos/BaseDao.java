package com.ekoapp.ekoplayground.room.daos;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import com.ekoapp.ekoplayground.room.entities.BaseEntity;

import java.util.List;

public abstract class BaseDao<ENTITY extends BaseEntity> {

    @Update
    abstract void updateImpl(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertImpl(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertImpl(List<ENTITY> entities);
}
