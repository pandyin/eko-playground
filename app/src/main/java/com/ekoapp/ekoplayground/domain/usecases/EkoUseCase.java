package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.repositories.EkoRepository;
import com.ekoapp.ekoplayground.domain.requests.EkoRequest;

public abstract class EkoUseCase<REPOSITORY extends EkoRepository, REQUEST extends EkoRequest, RESPONSE> {

    private final REPOSITORY repository;

    EkoUseCase(REPOSITORY repository) {
        this.repository = repository;
    }

    REPOSITORY getRepository() {
        return repository;
    }

    public abstract RESPONSE execute(REQUEST request);
}
