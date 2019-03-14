package com.ekoapp.ekoplayground.domain.usecases;

import com.ekoapp.ekoplayground.data.persistences.EkoDatabase;
import com.ekoapp.ekoplayground.data.repositories.UserRepository;
import com.ekoapp.ekoplayground.domain.requests.UserLogInRequest;

import io.reactivex.Completable;

public class UserLogInUseCase extends UserUseCase<UserLogInRequest, Completable> {

    public UserLogInUseCase() {
        super(new UserRepository(EkoDatabase.get().getUserDao()));
    }

    @Override
    public Completable execute(UserLogInRequest request) {
        return getRepository().logIn(request.getUsername(), request.getPassword());
    }
}
