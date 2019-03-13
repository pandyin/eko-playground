package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Message;

public class MessageRepository extends EkoRepository<Message> {

    public MessageRepository() {
        super(EkoDatabase.get().getMessageDao());
    }
}
