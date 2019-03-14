package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Chat;

public abstract class ChatUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Chat>, REQUEST, SOMETHING> {

    ChatUseCase(EkoListRepository<Chat> repository) {
        super(repository);
    }
}
