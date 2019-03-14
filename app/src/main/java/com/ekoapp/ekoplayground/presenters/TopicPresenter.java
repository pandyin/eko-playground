package com.ekoapp.ekoplayground.presenters;

import com.ekoapp.ekoplayground.contract.TopicContract;
import com.ekoapp.ekoplayground.viewmodels.TopicViewModel;
import com.uber.autodispose.AutoDispose;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopicPresenter extends EkoListPresenter<TopicViewModel, TopicContract> {

    public TopicPresenter(TopicViewModel viewModel, TopicContract contract) {
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
