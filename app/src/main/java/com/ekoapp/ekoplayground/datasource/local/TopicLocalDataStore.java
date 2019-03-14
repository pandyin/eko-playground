package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.TopicDao;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicLocalDataStore extends EkoListLocalDataStore<Topic> {

    public TopicLocalDataStore(TopicDao dao) {
        super(dao);
    }
}
