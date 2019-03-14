package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.MessageDao;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageLocalDataStore extends EkoListLocalDataStore<Message> {

    public MessageLocalDataStore(MessageDao dao) {
        super(dao);
    }
}
