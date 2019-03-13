package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.datasource.local.TopicLocalDataStore;
import com.ekoapp.ekoplayground.datasource.remote.TopicRemoteDataStore;
import com.ekoapp.ekoplayground.room.daos.TopicDao;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicRepository extends EkoRepository<Topic> {

    public TopicRepository(TopicDao dao) {
        super(new TopicLocalDataStore(dao), new TopicRemoteDataStore(dao));
    }
}
