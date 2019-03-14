package com.ekoapp.ekoplayground.data.datasources.remote;

import com.ekoapp.ekoplayground.socket.requests.EkoRequest;
import com.ekoapp.ekoplayground.socket.requests.ImmutableGetChat;
import com.ekoapp.ekoplayground.data.persistences.daos.ChatDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;

public class ChatRemoteDataStore extends EkoListRemoteDataStore<Chat> {

    public ChatRemoteDataStore(ChatDao dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest(String id) {
        return ImmutableGetChat.builder()
                .skip(0)
                .limit(15)
                .build();
    }
}
