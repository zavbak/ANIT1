package ru.a799000.alexander.anit.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import ru.a799000.alexander.anit.R;

import ru.a799000.alexander.anit.ui.navigate.NavigateManager;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;


import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.START_ACTION;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }



}
