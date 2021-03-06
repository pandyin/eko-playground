package com.ekoapp.ekoplayground.data.persistences.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.common.ChatType;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.google.common.base.Objects;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.joda.time.DateTime;

@Dao
public abstract class ChatDao extends EkoDao<Chat> {

    @Override
    @Transaction
    public void insert(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonObject chat = jsonObject.get("group").getAsJsonObject();
            if (Objects.equal(ChatType.DIRECT, ChatType.fromApikey(chat.get("type").getAsString()))) {
                insert(new Chat(chat.get("_id").getAsString(),
                        "direct",
                        ChatType.DIRECT,
                        DateTime.parse(chat.get("lastActivity").getAsString())));
            } else {
                insert(new Chat(chat.get("_id").getAsString(),
                        chat.get("name").getAsString(),
                        ChatType.GROUP,
                        DateTime.parse(chat.get("lastActivity").getAsString())));
            }
        }
    }

    @Override
    public DataSource.Factory<Integer, Chat> getDataSourceFactory(String id) {
        return getDataSourceFactoryImpl();
    }

    @Query("select * from chat order by lastActivity DESC")
    abstract DataSource.Factory<Integer, Chat> getDataSourceFactoryImpl();
}
