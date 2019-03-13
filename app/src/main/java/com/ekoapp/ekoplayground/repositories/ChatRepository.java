package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Chat;

public class ChatRepository extends EkoRepository<Chat> {

    public ChatRepository() {
        super(EkoDatabase.get().getChatDao());
    }
}
