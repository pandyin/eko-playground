package com.ekoapp.ekoplayground.presentation.presenters;

import com.ekoapp.ekoplayground.presentation.contracts.LogInContract;
import com.ekoapp.ekoplayground.presentation.viewmodels.UserViewModel;
import com.uber.autodispose.AutoDispose;

import io.reactivex.schedulers.Schedulers;

public class UserPresenter extends EkoPresenter<UserViewModel, LogInContract> {

    public UserPresenter(UserViewModel viewModel, LogInContract contract) {
        super(viewModel, contract);
    }

    public void logIn() {
        logIn(null, null);
    }

    public void logIn(String username, String password) {
        getViewModel().logIn(username, password)
                .doOnComplete(getContract()::onLoggedIn)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(getContract().getScopeProvider()))
                .subscribe();
    }
}
