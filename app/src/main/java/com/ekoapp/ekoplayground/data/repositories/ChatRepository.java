package com.ekoapp.ekoplayground.data.repositories;

import com.ekoapp.ekoplayground.data.datasources.local.ChatLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.ChatRemoteDataStore;
import com.ekoapp.ekoplayground.data.persistences.daos.ChatDao;
import com.ekoapp.ekoplayground.data.persistences.entities.Chat;

public class ChatRepository extends EkoListRepository<Chat> {

    public ChatRepository(ChatDao dao) {
        super(new ChatLocalDataStore(dao), new ChatRemoteDataStore(dao));
    }
}
