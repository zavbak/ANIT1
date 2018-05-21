package ru.a799000.alexander.anit.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.ui.activity.MainActivity;

import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.DETAIL_ACTION;

public class DetailFragment extends MvpAppCompatFragment {

    public static DetailFragment getNewInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @BindView(R.id.tv_text)
    TextView tvText;

    Date mDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDate = new Date();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.dateil_fragment, container, false);
        ButterKnife.bind(this, view);
        tvText.setText(mDate.toString());
        return view;
    }

    @OnClick(R.id.tv_text)
    public void submit(View view) {
        mDate = new Date();
        tvText.setText(mDate.toString());
    }
}
