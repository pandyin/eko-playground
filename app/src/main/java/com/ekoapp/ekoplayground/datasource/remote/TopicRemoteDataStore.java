package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicRemoteDataStore extends RemoteDataStore<Topic> {

    public TopicRemoteDataStore(EkoDao<Topic> dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest() {
        return null;
    }
}
