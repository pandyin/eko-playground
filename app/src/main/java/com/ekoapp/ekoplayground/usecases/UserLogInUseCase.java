package com.ekoapp.ekoplayground.usecases;

import com.ekoapp.ekoplayground.repositories.UserRepository;

import io.reactivex.Completable;

public class UserLogInUseCase extends UserUseCase<UserLogInRequest, Completable> {

    public UserLogInUseCase(UserRepository repository) {
        super(repository);
    }

    @Override
    public Completable execute(UserLogInRequest request) {
        return getRepository().logIn(request.getUsername(), request.getPassword());
    }
}
