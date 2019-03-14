package com.ekoapp.ekoplayground.data.datasources.local;

import com.ekoapp.ekoplayground.data.persistences.daos.MessageDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Message;

public class MessageLocalDataStore extends EkoListLocalDataStore<Message> {

    public MessageLocalDataStore(MessageDao dao) {
        super(dao);
    }
}
