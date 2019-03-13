package com.ekoapp.ekoplayground.datasource.remote;

import com.ekoapp.ekoplayground.requests.EkoRequest;
import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageRemoteDataStore extends RemoteDataStore<Message> {

    public MessageRemoteDataStore(EkoDao<Message> dao) {
        super(dao);
    }

    @Override
    EkoRequest getFirstPageRequest() {
        return null;
    }
}
