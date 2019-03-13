package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.Topic;

public abstract class TopicUseCase<SOMETHING> extends EkoUseCase<Topic, SOMETHING> {

    TopicUseCase(EkoRepository<Topic> repository) {
        super(repository);
    }
}
