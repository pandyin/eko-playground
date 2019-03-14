package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.requests.ImmutableGetChat;
import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.entities.Chat;

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
