package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.EkoRepository;
import com.ekoapp.ekoplayground.room.entities.EkoEntity;

public abstract class EkoUseCase<ENTITY extends EkoEntity, SOMETHING> {

    EkoRepository<ENTITY> repository;

    EkoUseCase(EkoRepository<ENTITY> repository) {
        this.repository = repository;
    }

    public abstract SOMETHING execute(String id);
}
