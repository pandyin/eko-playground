package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.UserRepository;

public abstract class UserUseCase<REQUEST extends EkoRequest, SOMETHING> extends EkoUseCase<UserRepository, REQUEST, SOMETHING> {

    UserUseCase(UserRepository repository) {
        super(repository);
    }
}
