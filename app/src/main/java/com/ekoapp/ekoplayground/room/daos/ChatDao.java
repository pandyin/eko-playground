package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.models.ChatType;
import com.ekoapp.ekoplayground.room.entities.Chat;
import com.google.common.base.Objects;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Dao
public abstract class ChatDao extends EkoDao<Chat> {

    @Override
    public DataSource.Factory<Integer, Chat> getDataSourceFactory(String id) {
        return getDataSourceFactoryImpl();
    }

    @Query("select * from chat order by lastUpdated DESC")
    abstract DataSource.Factory<Integer, Chat> getDataSourceFactoryImpl();

    @Transaction
    public void insert(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonObject chat = jsonObject.get("group").getAsJsonObject();

            if (Objects.equal(ChatType.DIRECT, ChatType.fromApikey(chat.get("type").getAsString()))) {
                insert(new Chat(chat.get("_id").getAsString(),
                        "direct",
                        ChatType.DIRECT));
            } else {
                insert(new Chat(chat.get("_id").getAsString(),
                        chat.get("name").getAsString(),
                        ChatType.GROUP));
            }
        }
    }
}
