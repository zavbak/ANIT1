package ru.a799000.alexander.anit.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;


import butterknife.BindView;
import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.common.manager.MyLinearLayoutManager;
import ru.a799000.alexander.anit.mvp.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit.mvp.view.BaseFeedView;
import ru.a799000.alexander.anit.ui.adapter.BaseAdapter;
import ru.a799000.alexander.anit.ui.fragment.base.BaseFragment;

public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView {

    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    protected BaseFeedPresenter mPresenter;

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = onCreateFeedPresenter();
        setUpSwipeToRefreshLayout(view);
        setUpRecyclerView();
        mPresenter.onStart();
        setUpAdapter();
    }


    private void setUpRecyclerView() {
        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (mLinearLayoutManager.isOnNextPagePosition()) {
                   onScroll();
                }
            }
        });
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    protected void setUpAdapter(){
        mRecyclerView.setAdapter(getAdapter());
    }


    private void setUpSwipeToRefreshLayout(View rootView) {
        mSwipeRefreshLayout.setOnRefreshListener(() -> onSwipe());
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();
    protected abstract void onSwipe();
    protected abstract void onScroll();
    protected abstract BaseAdapter getAdapter();


}
