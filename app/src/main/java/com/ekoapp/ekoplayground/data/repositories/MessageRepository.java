package com.ekoapp.ekoplayground.data.repositories;

import com.ekoapp.ekoplayground.data.datasources.local.MessageLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.MessageRemoteDataStore;
import com.ekoapp.ekoplayground.data.persistences.daos.MessageDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;

public class MessageRepository extends EkoListRepository<Message> {

    public MessageRepository(MessageDao dao) {
        super(new MessageLocalDataStore(dao), new MessageRemoteDataStore(dao));
    }
}
