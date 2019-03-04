package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.models.ChatType;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Dao
public abstract class ChatDao extends EkoDao<Chat> {

    @Query("select * from chat")
    public abstract DataSource.Factory<Integer, Chat> getChat();

    @Transaction
    public void insert(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonObject chat = jsonObject.get("group").getAsJsonObject();
            insert(new Chat(chat.get("_id").getAsString(),
                    ChatType.DIRECT));
        }
    }
}
