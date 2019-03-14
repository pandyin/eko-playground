package com.ekoapp.ekoplayground.presenters;

import com.ekoapp.ekoplayground.contract.MessageContract;
import com.ekoapp.ekoplayground.viewmodels.MessageViewModel;
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
