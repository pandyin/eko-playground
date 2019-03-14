package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.persistences.entities.Message;
import com.ekoapp.ekoplayground.data.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.domain.requests.EkoRequest;

public abstract class MessageUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Message>, REQUEST, SOMETHING> {

    MessageUseCase(EkoListRepository<Message> repository) {
        super(repository);
    }
}
