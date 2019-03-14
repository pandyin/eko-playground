package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.datasource.local.MessageLocalDataStore;
import com.ekoapp.ekoplayground.datasource.remote.MessageRemoteDataStore;
import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageRepository extends EkoListRepository<Message> {

    public MessageRepository(MessageDao dao) {
        super(new MessageLocalDataStore(dao), new MessageRemoteDataStore(dao));
    }
}
