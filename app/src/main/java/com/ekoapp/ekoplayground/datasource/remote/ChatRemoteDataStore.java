package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.requests.ImmutableGetChat;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatRemoteDataStore extends RemoteDataStore<Chat> {

    public ChatRemoteDataStore(EkoDao<Chat> dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest() {
        return ImmutableGetChat.builder()
                .skip(0)
                .limit(15)
                .build();
    }
}
