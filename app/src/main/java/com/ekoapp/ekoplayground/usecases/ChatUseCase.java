package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Chat;

public abstract class ChatUseCase<SOMETHING> extends EkoUseCase<Chat, SOMETHING> {

    ChatUseCase(EkoRepository<Chat> repository) {
        super(repository);
    }
}
