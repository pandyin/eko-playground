package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.common.socket.requests.EkoRequest;
import com.ekoapp.ekoplayground.common.socket.requests.ImmutableGetTopic;
import com.ekoapp.ekoplayground.data.persistences.daos.TopicDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Topic;

public class TopicRemoteDataStore extends EkoListRemoteDataStore<Topic> {

    public TopicRemoteDataStore(TopicDao dao) {
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
