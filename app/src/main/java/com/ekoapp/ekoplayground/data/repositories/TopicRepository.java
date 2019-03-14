package com.ekoapp.ekoplayground.data.repositories;

import com.ekoapp.ekoplayground.data.datasources.local.TopicLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.TopicRemoteDataStore;
import com.ekoapp.ekoplayground.data.persistences.daos.TopicDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Topic;

public class TopicRepository extends EkoListRepository<Topic> {

    public TopicRepository(TopicDao dao) {
        super(new TopicLocalDataStore(dao), new TopicRemoteDataStore(dao));
    }
}
