package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.datasource.local.ChatLocalDataStore;
import com.ekoapp.ekoplayground.datasource.remote.ChatRemoteDataStore;
import com.ekoapp.ekoplayground.room.daos.ChatDao;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatRepository extends EkoRepository<Chat> {

    public ChatRepository(ChatDao dao) {
        super(new ChatLocalDataStore(dao), new ChatRemoteDataStore(dao));
    }
}
