package ru.a799000.alexander.anit.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.a799000.alexander.anit.mvp.view.BaseFeedView;
import ru.a799000.alexander.anit.ui.adapter.BaseAdapter;
import ru.a799000.alexander.anit.ui.model.view.BaseFeedViewModel;
import ru.a799000.alexander.anit.ui.model.view.BaseViewModel;

public abstract class BaseFeedPresenter<V extends BaseFeedView> extends MvpPresenter<V>{

    BaseAdapter mAdapter;

    public BaseFeedPresenter() {
        mAdapter = new BaseAdapter();
        loadData();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onStart(){

    }

    private void loadData() {
        //onLoadViewModelObservableTest()
        onCreateLoadDataObservable(10,  2, "торг")
        //onLoadViewModelObservableTest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseFeedViewModel ->{
                    mAdapter.setItems(baseFeedViewModel.getViewModelList(),baseFeedViewModel.getFullSizeRs());
                },error -> {
                    getViewState().showMessage(error.getMessage());

                });
    }

    public void onStop(){

    }

    public void OnSwipe() {
        getViewState().showMessage("onSwipe");
    }


    public void onScroll() {
        getViewState().showMessage("onScroll");
    }

    public BaseAdapter getAdapter() {
        return mAdapter;
    }

    abstract Single<BaseFeedViewModel<BaseViewModel>> onLoadViewModelObservableTest();

    abstract Single<BaseFeedViewModel<BaseViewModel>> onCreateLoadDataObservable(int count, int offset, String filterName);


}
