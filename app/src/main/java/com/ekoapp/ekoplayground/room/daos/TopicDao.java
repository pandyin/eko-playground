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

    @Override
    public DataSource.Factory<Integer, Topic> getDataSourceFactory(String id) {
        return getDataSourceFactoryImpl(id);
    }

    @Query("select * from topic where chatId =:id order by lastUpdated DESC")
    abstract DataSource.Factory<Integer, Topic> getDataSourceFactoryImpl(String id);

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
