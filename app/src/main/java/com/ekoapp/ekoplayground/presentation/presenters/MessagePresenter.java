package com.ekoapp.ekoplayground.presentation.presenters;

import com.ekoapp.ekoplayground.presentation.contracts.MessageContract;
import com.ekoapp.ekoplayground.presentation.viewmodels.MessageViewModel;
import com.uber.autodispose.AutoDispose;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MessagePresenter extends EkoListPresenter<MessageViewModel, MessageContract> {

    public MessagePresenter(MessageViewModel viewModel, MessageContract contract) {
        super(viewModel, contract);
    }

    public void test(String topicId) {
        getViewModel().getPagedList(topicId)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(getContract()::submitList)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(getContract().getScopeProvider()))
                .subscribe();
    }
}
