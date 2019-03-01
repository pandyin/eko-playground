package com.ekoapp.ekoplayground.room.daos;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import com.ekoapp.ekoplayground.room.entities.EkoEntity;

import java.util.List;

public abstract class EkoDao<ENTITY extends EkoEntity> {

    @Update
    abstract void update(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insert(ENTITY entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insert(List<ENTITY> entities);
}
