package ru.a799000.alexander.anit.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.ui.activity.MainActivity;

import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.DETAIL_ACTION;

public class StartFragment extends MvpAppCompatFragment {

    @Inject
    MainActivity mMainActivity;

    public static StartFragment getNewInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.start_fragment, container, false);
        ButterKnife.bind(this, view);
        ((MainActivity)getActivity()).setToolbarTitle("Hello ..");
        return view;
    }

    @OnClick(R.id.avatar_imageView)
    public void submit(View view) {
        mMainActivity.getRouter().navigateTo(DETAIL_ACTION);
    }
}
