package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicLocalDataStore extends LocalDataStore<Topic> {

    public TopicLocalDataStore(EkoDao<Topic> dao) {
        super(dao);
    }
}
