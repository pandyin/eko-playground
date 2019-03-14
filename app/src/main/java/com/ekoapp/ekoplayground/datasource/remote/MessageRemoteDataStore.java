package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.requests.ImmutableGetLatestMessage;
import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageRemoteDataStore extends EkoListRemoteDataStore<Message> {

    public MessageRemoteDataStore(MessageDao dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest(String id) {
        return ImmutableGetLatestMessage.builder()
                .topicId(id)
                .limit(15)
                .build();
    }
}
