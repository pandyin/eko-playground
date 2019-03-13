package com.ekoapp.ekoplayground.presenters;

import com.ekoapp.ekoplayground.contract.TopicContract;
import com.ekoapp.ekoplayground.viewmodels.TopicViewModel;
import com.uber.autodispose.AutoDispose;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopicPresenter extends EkoPresenter<TopicViewModel, TopicContract> {

    public TopicPresenter(TopicViewModel viewModel, TopicContract contract) {
        super(viewModel, contract);
    }

    public void test(String topicId) {
        viewModel.getPagedList(topicId)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(contract::submitList)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(contract.getScopeProvider()))
                .subscribe();
    }
}
