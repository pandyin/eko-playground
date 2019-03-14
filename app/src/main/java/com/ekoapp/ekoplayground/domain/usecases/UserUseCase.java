package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.repositories.UserRepository;
import com.ekoapp.ekoplayground.domain.requests.EkoRequest;

public abstract class UserUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<UserRepository, REQUEST, SOMETHING> {

    UserUseCase(UserRepository repository) {
        super(repository);
    }
}
