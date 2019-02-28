package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.ekoapp.ekoplayground.room.entities.Message;

@Dao
public abstract class MessageDao extends EkoDao {

    @Query("select * from message where id =:id")
    public abstract DataSource.Factory<Integer, Message> getMessage(String id);
}
