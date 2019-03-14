package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.persistences.entities.Topic;
import com.ekoapp.ekoplayground.data.repositories.EkoListRepository;
import com.ekoapp.ekoplayground.domain.requests.EkoRequest;

public abstract class TopicUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<EkoListRepository<Topic>, REQUEST, SOMETHING> {

    TopicUseCase(EkoListRepository<Topic> repository) {
        super(repository);
    }
}
