package com.ekoapp.ekoplayground.data.datasources.local;

import com.ekoapp.ekoplayground.data.persistences.daos.ChatDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;

public class ChatLocalDataStore extends EkoListLocalDataStore<Chat> {

    public ChatLocalDataStore(ChatDao dao) {
        super(dao);
    }
}
