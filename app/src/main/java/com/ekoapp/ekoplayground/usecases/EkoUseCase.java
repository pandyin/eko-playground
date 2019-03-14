package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoRepository;

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
