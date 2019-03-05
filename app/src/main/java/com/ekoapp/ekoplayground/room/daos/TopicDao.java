package com.ekoapp.ekoplayground.room.daos;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ekoapp.ekoplayground.room.entities.Topic;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Dao
public abstract class TopicDao extends EkoDao<Topic> {

    @Query("select * from topic where chatId =:chatId order by lastUpdated DESC")
    public abstract DataSource.Factory<Integer, Topic> getTopic(String chatId);

    @Transaction
    public void insert(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject topic = jsonArray.get(i).getAsJsonObject();
            insert(new Topic(topic.get("_id").getAsString(),
                    topic.get("name").getAsString(),
                    topic.get("gid").getAsString()));
        }
    }
}
