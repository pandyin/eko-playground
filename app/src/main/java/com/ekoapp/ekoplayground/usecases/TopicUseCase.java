package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.room.entities.Topic;

public abstract class TopicUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Topic>, REQUEST, SOMETHING> {

    TopicUseCase(EkoListRepository<Topic> repository) {
        super(repository);
    }
}
