package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.ekoapp.ekoplayground.room.entities.Chat;

@Dao
public abstract class ChatDao extends EkoDao {

    @Query("select * from chat")
    public abstract DataSource.Factory<Integer, Chat> getChat();
}
