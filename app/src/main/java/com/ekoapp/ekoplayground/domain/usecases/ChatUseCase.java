package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.persistences.entities.Chat;
import com.ekoapp.ekoplayground.data.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.domain.requests.EkoRequest;

public abstract class ChatUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Chat>, REQUEST, SOMETHING> {

    ChatUseCase(EkoListRepository<Chat> repository) {
        super(repository);
    }
}
