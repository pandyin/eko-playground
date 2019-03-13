package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageLocalDataStore extends LocalDataStore<Message> {

    public MessageLocalDataStore(EkoDao<Message> dao) {
        super(dao);
    }
}
