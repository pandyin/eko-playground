package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.common.socket.requests.EkoRequest;
import com.ekoapp.ekoplayground.common.socket.requests.ImmutableGetLatestMessage;
import com.ekoapp.ekoplayground.data.persistences.daos.MessageDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;

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
