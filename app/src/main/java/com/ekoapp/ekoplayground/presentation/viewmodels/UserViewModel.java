package com.ekoapp.ekoplayground.presentation.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.domain.requests.UserLogInRequest;
import com.ekoapp.ekoplayground.domain.usecases.UserLogInUseCase;

import io.reactivex.Completable;

public class UserViewModel extends EkoViewModel {

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public Completable logIn(String username, String password) {
        UserLogInRequest request = new UserLogInRequest(username, password);
        UserLogInUseCase useCase = new UserLogInUseCase();
        return useCase.execute(request);
    }
}
