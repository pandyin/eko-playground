package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.EkoDao;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatLocalDataStore extends LocalDataStore<Chat> {

    public ChatLocalDataStore(EkoDao<Chat> dao) {
        super(dao);
    }
}
