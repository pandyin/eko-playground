package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.requests.ImmutableGetTopic;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicRemoteDataStore extends RemoteDataStore<Topic> {

    public TopicRemoteDataStore(EkoDao<Topic> dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest(String id) {
        return ImmutableGetTopic.builder()
                .chatId(id)
                .skip(0)
                .limit(15)
                .build();
    }
}
