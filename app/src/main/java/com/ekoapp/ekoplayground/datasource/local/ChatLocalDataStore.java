package com.ekoapp.ekoplayground.datasource.local;

import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatLocalDataStore extends EkoListLocalDataStore<Chat> {

    public ChatLocalDataStore(ChatDao dao) {
        super(dao);
    }
}
