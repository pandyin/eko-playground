package com.ekoapp.ekoplayground.data.persistences.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.common.MessageType;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Dao
public abstract class MessageDao extends EkoDao<Message> {

    @Override
    @Transaction
    public void insert(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject message = jsonArray.get(i).getAsJsonObject();
            insert(new Message(message.get("_id").getAsString(),
                    message.get("data").getAsString(),
                    message.get("tid").getAsString(),
                    MessageType.TEXT));
        }
    }

    @Override
    public DataSource.Factory<Integer, Message> getDataSourceFactory(String id) {
        return getDataSourceFactoryImpl(id);
    }

    @Query("select * from message where topicId =:id")
    abstract DataSource.Factory<Integer, Message> getDataSourceFactoryImpl(String id);
}
