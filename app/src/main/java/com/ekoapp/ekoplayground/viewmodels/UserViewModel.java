package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.repositories.UserRepository;
import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.usecases.UserLogInRequest;
import com.ekoapp.ekoplayground.usecases.UserLogInUseCase;

import io.reactivex.Completable;

public class UserViewModel extends EkoViewModel {

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public Completable logIn(String username, String password) {
        UserRepository repository = new UserRepository(EkoDatabase.get().getUserDao());
        UserLogInRequest request = new UserLogInRequest(username, password);
        UserLogInUseCase useCase = new UserLogInUseCase(repository);
        return useCase.execute(request);
    }
}
