package com.ekoapp.ekoplayground.presenters;

import com.ekoapp.ekoplayground.contract.ChatContract;
import com.ekoapp.ekoplayground.viewmodels.ChatViewModel;
import com.uber.autodispose.AutoDispose;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ChatPresenter extends EkoListPresenter<ChatViewModel, ChatContract> {

    public ChatPresenter(ChatViewModel viewModel, ChatContract contract) {
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
