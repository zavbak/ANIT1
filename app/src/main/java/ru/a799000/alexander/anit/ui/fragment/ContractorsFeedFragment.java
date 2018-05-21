package ru.a799000.alexander.anit.ui.fragment;


import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;


import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.mvp.presenter.BaseFeedPresenter;
import ru.a799000.alexander.anit.mvp.presenter.ContractorsPresenter;
import ru.a799000.alexander.anit.ui.adapter.BaseAdapter;
import ru.a799000.alexander.anit.ui.fragment.base.BaseFeedFragment;


public class ContractorsFeedFragment extends BaseFeedFragment {

    @InjectPresenter
    ContractorsPresenter mContractorsPresenter;

    public static ContractorsFeedFragment getNewInstance() {
        ContractorsFeedFragment fragment = new ContractorsFeedFragment();
        return fragment;
    }


    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mContractorsPresenter;
    }

    @Override
    protected void onSwipe() {
        mPresenter.OnSwipe();
        //mContractorsPresenter.onLoadViewModelObservable();
    }

    @Override
    protected void onScroll() {
        mPresenter.onScroll();
    }

    @Override
    protected BaseAdapter getAdapter() {
        return mPresenter.getAdapter();
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_contractors;
    }


    @Override
    public void showMessage(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }
}
