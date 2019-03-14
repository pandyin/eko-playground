package com.ekoapp.ekoplayground.data.datasources.local;

import com.ekoapp.ekoplayground.data.persistences.daos.TopicDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Topic;

public class TopicLocalDataStore extends EkoListLocalDataStore<Topic> {

    public TopicLocalDataStore(TopicDao dao) {
        super(dao);
    }
}
