package com.ekoapp.ekoplayground.presenters;

import com.ekoapp.ekoplayground.contract.LogInContract;
import com.ekoapp.ekoplayground.viewmodels.UserViewModel;
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
