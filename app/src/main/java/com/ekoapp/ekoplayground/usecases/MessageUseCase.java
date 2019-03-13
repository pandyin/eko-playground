package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Message;

public abstract class MessageUseCase<SOMETHING> extends EkoUseCase<Message, SOMETHING> {

    MessageUseCase(EkoRepository<Message> repository) {
        super(repository);
    }
}
