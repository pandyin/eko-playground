package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Message;

public abstract class MessageUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Message>, REQUEST, SOMETHING> {

    MessageUseCase(EkoListRepository<Message> repository) {
        super(repository);
    }
}
