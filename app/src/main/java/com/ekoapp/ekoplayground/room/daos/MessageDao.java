package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.models.MessageType;
import com.ekoapp.ekoplayground.room.entities.Message;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Dao
public abstract class MessageDao extends EkoDao<Message> {

    @Query("select * from message where topicId =:topicId")
    public abstract DataSource.Factory<Integer, Message> getMessage(String topicId);

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
}
